package shortestpath;

import com.google.inject.Provides;
import com.questhelper.questhelpers.ActionHelper;
import net.runelite.api.Point;
import net.runelite.api.*;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;
import shortestpath.pathfinder.CollisionMap;
import shortestpath.pathfinder.Pathfinder;
import shortestpath.pathfinder.SplitFlagMap;

import javax.inject.Inject;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

@PluginDescriptor(name = "Shortest Path", description = "Draws the shortest path to a chosen destination on the map (right click a spot on the world map to use)")
public class ShortestPathPlugin extends Plugin
{
    public static ShortestPathPlugin Shortpathplugin = null;

    private static final WorldArea WILDERNESS_ABOVE_GROUND = new WorldArea(2944, 3523, 448, 448, 0);
    private static final WorldArea WILDERNESS_UNDERGROUND = new WorldArea(2944, 9918, 320, 442, 0);
    @Inject
    public Client client;
    @Inject
    public ShortestPathConfig config;
    @Inject
    public OverlayManager overlayManager;
    @Inject
    public PathTileOverlay pathOverlay;
    @Inject
    public PathMinimapOverlay pathMinimapOverlay;
    @Inject
    public PathMapOverlay pathMapOverlay;
    @Inject
    private WorldMapPointManager worldMapPointManager;
    @Inject
    private WorldMapOverlay worldMapOverlay;
    public CollisionMap map;
    public List<WorldPoint> path = null;
    public WorldPoint target = null;
    private boolean running;
    private Point lastMenuOpenedPoint;
    public WorldMapPoint marker;
    private static final BufferedImage MARKER_IMAGE = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/marker.png");
    private static final BufferedImage MARKER_IMAGEGOLD = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskmarker.png");
    private static final BufferedImage MARKER_IMAGEGREEN = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskmarkerGreen.png");
    private static final BufferedImage MARKER_IMAGEPURPLE = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskmarkerPurp.png");
    private static final BufferedImage MARKER_IMAGERED = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskmarkerRed.png");
    private static final BufferedImage MARKER_IMAGEGOLDEASY = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskMarkerEasy.png");
    private static final BufferedImage MARKER_IMAGEGOLDMEDIUM = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskMarkerMedium.png");
    private static final BufferedImage MARKER_IMAGEGOLDHARD = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskMarkerHard.png");
    private static final BufferedImage MARKER_IMAGEGOLDELITE = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskMarkerElite.png");
    private static final BufferedImage MARKER_IMAGEGOLDMASTER = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskMarkerMaster.png");
    private static final BufferedImage MARKER_IMAGEGREENEASY = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskmarkerGreenEasy.png");
    private static final BufferedImage MARKER_IMAGEGREENMEDIUM = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskmarkerGreenMedium.png");
    private static final BufferedImage MARKER_IMAGEGREENHARD = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskmarkerGreenHard.png");
    private static final BufferedImage MARKER_IMAGEGREENELITE = ImageUtil.getResourceStreamFromClass(ShortestPathPlugin.class, "/taskmarkerGreenElite.png");
    public boolean pathUpdateScheduled = false;
    public final Map<WorldPoint, List<WorldPoint>> transports = new HashMap<>();
    public Pathfinder pathfinder;
    public WorldPoint transportStart;
    private MenuOptionClicked lastClick;

    public Map<String, WorldMapActionInfo> taskMarkers = new HashMap<>();

    @Override
    protected void startUp() {
        Shortpathplugin = this;
        Map<SplitFlagMap.Position, byte[]> compressedRegions = new HashMap<>();

        try (ZipInputStream in = new ZipInputStream(ShortestPathPlugin.class.getResourceAsStream("/collision-map.zip"))) {
            ZipEntry entry;
            while ((entry = in.getNextEntry()) != null) {
                String[] n = entry.getName().split("_");

                compressedRegions.put(
                        new SplitFlagMap.Position(Integer.parseInt(n[0]), Integer.parseInt(n[1])),
                        Util.readAllBytes(in)
                );
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        map = new CollisionMap(64, compressedRegions);

        try {
            String s = new String(Util.readAllBytes(ShortestPathPlugin.class.getResourceAsStream("/transports.txt")), StandardCharsets.UTF_8);
            Scanner scanner = new Scanner(s);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("#") || line.isEmpty()) {
                    continue;
                }

                String[] l = line.split(" ");
                WorldPoint a = new WorldPoint(Integer.parseInt(l[0]), Integer.parseInt(l[1]), Integer.parseInt(l[2]));
                WorldPoint b = new WorldPoint(Integer.parseInt(l[3]), Integer.parseInt(l[4]), Integer.parseInt(l[5]));
                transports.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        running = true;

        new Thread(() -> {
            while (running) {
                if (pathUpdateScheduled) {
                    if (target == null) {
                        path = null;
                    } else {
                        pathfinder = new Pathfinder(map, transports, client.getLocalPlayer().getWorldLocation(), target, config.avoidWilderness() && !isInWilderness(target));
                        path = pathfinder.find();
                        pathUpdateScheduled = false;
                    }
                }

                Util.sleep(10);
            }
        }).start();

        overlayManager.add(pathOverlay);
        overlayManager.add(pathMinimapOverlay);
        overlayManager.add(pathMapOverlay);
    }

    @Override
    protected void shutDown() {
        Shortpathplugin = null;
        map = null;
        running = false;
        overlayManager.remove(pathOverlay);
        overlayManager.remove(pathMinimapOverlay);
        overlayManager.add(pathMapOverlay);
    }

    public static boolean isInWilderness(WorldPoint p) {
        return WILDERNESS_ABOVE_GROUND.distanceTo(p) == 0 ||
                WILDERNESS_UNDERGROUND.distanceTo(p) == 0;
    }

    @Subscribe
    public void onMenuOpened(MenuOpened event) {
        lastMenuOpenedPoint = client.getMouseCanvasPosition();
    }

    @Subscribe
    public void onGameTick(GameTick tick) {
        if (path != null) {
            if (!isNearPath()) {
                if (config.cancelInstead()) {
                    target = null;
                }

                pathUpdateScheduled = true;
            }

            if (target != null && client.getLocalPlayer().getWorldLocation().distanceTo(target) < config.reachedDistance()) {
                target = null;
                pathUpdateScheduled = true;
            }
        }
    }

    private boolean isNearPath() {
        for (WorldPoint point : path) {
            if (client.getLocalPlayer().getWorldLocation().distanceTo(point) < config.recalculateDistance()) {
                return true;
            }
        }
        return false;
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event) {
        if (config.drawTransports()) {
            addMenuEntry(event, "Start");
            addMenuEntry(event, "End");
//            addMenuEntry(event, "Copy Position");
        }

        final Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);

        if (map == null) {
            return;
        }

        if (map.getBounds().contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY())) {
            addMenuEntry(event, "Set Target");
            addMenuEntry(event, "Clear Target");
        }
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event) {
        if (event.getMenuOption().equals("Start")) {
            transportStart = client.getLocalPlayer().getWorldLocation();
        }

        if (event.getMenuOption().equals("End")) {
            WorldPoint transportEnd = client.getLocalPlayer().getWorldLocation();
            System.out.println(transportStart.getX() + " " + transportStart.getY() + " " + transportStart.getPlane() + " " +
                    transportEnd.getX() + " " + transportEnd.getY() + " " + transportEnd.getPlane() + " " +
                    lastClick.getMenuOption() + " " + Text.removeTags(lastClick.getMenuTarget()) + " " + lastClick.getId()
            );
            transports.computeIfAbsent(transportStart, k -> new ArrayList<>()).add(transportEnd);
        }

        if (event.getMenuOption().equals("Copy Position"))
        {
            WorldPoint pos = client.getLocalPlayer().getWorldLocation();
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("(" + pos.getX() + ", " + pos.getY() + ", " + pos.getPlane() + ")"), null);
        }
        if (event.getMenuOption().equals("Set Target"))
        {
            setTarget(calculateMapPoint(client.isMenuOpen() ? lastMenuOpenedPoint : client.getMouseCanvasPosition()));
        }

        if (event.getMenuOption().equals("Clear Target")) {
            setTarget(null);
        }

        if (event.getMenuOption().equals("Focus on"))
        {
            String MenuTargetString = event.getMenuTarget();
            if (MenuTargetString.length() > 18)
            {
                String FinalString = MenuTargetString.substring(12, MenuTargetString.length() - 6);

                WorldMapActionInfo clickedOnActionInfo = taskMarkers.get(FinalString);

                if (clickedOnActionInfo != null)
                {
                    clickedOnActionInfo.AssociatedAction.questHelperPlugin.nextSelectedAction = clickedOnActionInfo.AssociatedAction;
                }
            }
        }

        if (event.getMenuAction() != MenuAction.WALK) {
            lastClick = event;
        }

        final Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);

        if (map == null)
        {
            return;
        }

        if (map.getBounds().contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY()))
        {
            WorldPoint worldlocationclick = calculateMapPoint(client.isMenuOpen() ? lastMenuOpenedPoint : client.getMouseCanvasPosition());
            String TargetLocationText = "Set target location at map point: " + worldlocationclick;
            System.out.println(TargetLocationText);
        }
    }

    public void clearTaskMarkers()
    {
        for (Map.Entry<String, WorldMapActionInfo> entry : taskMarkers.entrySet())
        {
            worldMapPointManager.remove(entry.getValue().marker);
            entry.getValue().Enabled = false;
        }
    }

    public void addTaskMarker(String TaskName, ActionHelper action, WorldPoint target, int markerType)
    {
        if (taskMarkers == null)
        {
            return;
        }

        BufferedImage ImageAssign = MARKER_IMAGEPURPLE;
        Color MarkerColor = Color.MAGENTA;
        if (markerType == 0)
        {
            ImageAssign = MARKER_IMAGE;
            MarkerColor = Color.blue;
        }
        else if (markerType == 1)
        {
            ImageAssign = MARKER_IMAGEGREEN;
            MarkerColor = Color.green;
        }
        else if (markerType == 2)
        {
            ImageAssign = MARKER_IMAGEGOLD;
            MarkerColor = Color.yellow;
        }
        else if (markerType == 3)
        {
            ImageAssign = MARKER_IMAGERED;
            MarkerColor = Color.red;
        }
        else if (markerType == 4)
        {
            ImageAssign = MARKER_IMAGEGOLDEASY;
            MarkerColor = new Color(240, 94, 255, 255);
        }
        else if (markerType == 5)
        {
            ImageAssign = MARKER_IMAGEGOLDMEDIUM;
            MarkerColor = new Color(199, 73, 213, 255);
        }
        else if (markerType == 6)
        {
            ImageAssign = MARKER_IMAGEGOLDHARD;
            MarkerColor = new Color(162, 62, 174, 255);
        }
        else if (markerType == 7)
        {
            ImageAssign = MARKER_IMAGEGOLDELITE;
            MarkerColor = new Color(133, 51, 142, 255);
        }
        else if (markerType == 8)
        {
            ImageAssign = MARKER_IMAGEGOLDMASTER;
            MarkerColor = new Color(89, 34, 95, 255);
        }
        else if (markerType == 9)
        {
            ImageAssign = MARKER_IMAGEGREENEASY;
            MarkerColor = Color.green;
        }
        else if (markerType == 10)
        {
            ImageAssign = MARKER_IMAGEGREENMEDIUM;
            MarkerColor = Color.green;
        }
        else if (markerType == 11)
        {
            ImageAssign = MARKER_IMAGEGREENHARD;
            MarkerColor = Color.green;
        }
        else if (markerType == 12)
        {
            ImageAssign = MARKER_IMAGEGREENELITE;
            MarkerColor = Color.green;
        }

        WorldMapPoint newWorldPoint = null;
        WorldMapActionInfo newActionInfo = null;
        if (!taskMarkers.containsKey(TaskName))
        {
            newActionInfo = new WorldMapActionInfo();
            newWorldPoint = new WorldMapPoint(target, ImageAssign);
            newWorldPoint.setName(TaskName);
            newWorldPoint.setTarget(target);
            newWorldPoint.setJumpOnClick(true);

            newActionInfo.Enabled = true;
            newActionInfo.marker = newWorldPoint;
            newActionInfo.markercolor = MarkerColor;
            newActionInfo.AssociatedAction = action;

            taskMarkers.put(TaskName, newActionInfo);
        }
        else
        {
            newActionInfo = taskMarkers.get(TaskName);
            newActionInfo.Enabled = true;
            newActionInfo.AssociatedAction = action;

            newWorldPoint = newActionInfo.marker;
        }

        worldMapPointManager.add(newWorldPoint);
    }

    public void setTarget(WorldPoint target)
    {
        this.target = target;
        pathUpdateScheduled = true;

        if (target == null) {
            worldMapPointManager.remove(marker);
            marker = null;
        } else {

            worldMapPointManager.removeIf(x -> x == marker);
            marker = new WorldMapPoint(target, MARKER_IMAGEPURPLE);
            marker.setName("ShortestPath");
            marker.setTarget(marker.getWorldPoint());
            marker.setJumpOnClick(true);
            worldMapPointManager.add(marker);
        }
    }

    private WorldPoint calculateMapPoint(Point point)
    {
        float zoom = client.getRenderOverview().getWorldMapZoom();
        RenderOverview renderOverview = client.getRenderOverview();
        final WorldPoint mapPoint = new WorldPoint(renderOverview.getWorldMapPosition().getX(), renderOverview.getWorldMapPosition().getY(), 0);
        final Point middle = worldMapOverlay.mapWorldPointToGraphicsPoint(mapPoint);

        final int dx = (int) ((point.getX() - middle.getX()) / zoom);
        final int dy = (int) ((-(point.getY() - middle.getY())) / zoom);

        return mapPoint.dx(dx).dy(dy);
    }

    @Provides
    public ShortestPathConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(ShortestPathConfig.class);
    }

    private void addMenuEntry(MenuEntryAdded event, String option) {
        List<MenuEntry> entries = new LinkedList<>(Arrays.asList(client.getMenuEntries()));

        if (entries.stream().anyMatch(e -> e.getOption().equals(option))) {
            return;
        }

        client.setMenuEntries(entries.toArray(new MenuEntry[0]));
    }
}
