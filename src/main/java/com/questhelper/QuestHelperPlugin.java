/*
 * Copyright (c) 2020, Zoinkwiz <https://github.com/Zoinkwiz>
 * Copyright (c) 2019, Trevor <https://github.com/Trevor159>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.questhelper;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.inject.Binder;
import com.google.inject.CreationException;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.questhelper.banktab.QuestBankTab;
import com.questhelper.banktab.QuestHelperBankTagService;
import com.questhelper.overlays.QuestHelperDebugOverlay;
import com.questhelper.overlays.QuestHelperOverlay;
import com.questhelper.overlays.QuestHelperWidgetOverlay;
import com.questhelper.overlays.QuestHelperWorldArrowOverlay;
import com.questhelper.overlays.QuestHelperWorldLineOverlay;
import com.questhelper.overlays.QuestHelperWorldOverlay;
import com.questhelper.panel.QuestHelperPanel;
import com.questhelper.questhelpers.*;
import com.questhelper.steps.QuestStep;
import com.questhelper.steps.overlay.leaguestasks.ShatteredRelicsLeagueTasks;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLite;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.bank.BankSearch;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;
import shortestpath.ShortestPathPlugin;

@PluginDescriptor(
		name = "Leagues Optimizer",
		description = "Helps you optimize your leagues attempt",
		tags = { "quest", "helper", "overlay", "leagues" }
)
@Slf4j
public class QuestHelperPlugin extends Plugin
{
	public ShortestPathPlugin shortestPathPlugin;

	public QuestStep CurrentStepSelected = null;
	public QuestStep OldStepSelected = null;
	private static final int[] QUESTLIST_WIDGET_IDS = new int[]
			{
					WidgetInfo.QUESTLIST_FREE_CONTAINER.getId(),
					WidgetInfo.QUESTLIST_MEMBERS_CONTAINER.getId(),
					WidgetInfo.QUESTLIST_MINIQUEST_CONTAINER.getId()
			};

	private static final String[] RFD_NAMES = new String[]
			{
					QuestHelperQuest.RECIPE_FOR_DISASTER_FINALE.getName(),
					QuestHelperQuest.RECIPE_FOR_DISASTER_MONKEY_AMBASSADOR.getName(),
					QuestHelperQuest.RECIPE_FOR_DISASTER_SIR_AMIK_VARZE.getName(),
					QuestHelperQuest.RECIPE_FOR_DISASTER_DWARF.getName(),
					QuestHelperQuest.RECIPE_FOR_DISASTER_EVIL_DAVE.getName(),
					QuestHelperQuest.RECIPE_FOR_DISASTER_WARTFACE_AND_BENTNOZE.getName(),
					QuestHelperQuest.RECIPE_FOR_DISASTER_SKRACH_UGLOGWEE.getName(),
					QuestHelperQuest.RECIPE_FOR_DISASTER_PIRATE_PETE.getName(),
					QuestHelperQuest.RECIPE_FOR_DISASTER_LUMBRIDGE_GUIDE.getName(),
					QuestHelperQuest.RECIPE_FOR_DISASTER_START.getName()
			};

	private static final int[] ACHIEVEMENTLIST_WIDGET_IDS = new int[]
			{
					WidgetInfo.ACHIEVEMENT_DIARY_CONTAINER.getId()
			};

	private static final String[] achievementTiers = new String[]
			{
					"Elite",
					"Hard",
					"Medium",
					"Easy"
			};

	private static final String QUEST_PACKAGE = "com.questhelper.quests";
	private static final String ACHIEVEMENT_PACKAGE = "com.questhelper.achievementdiaries";

	private static final String MENUOP_QUESTHELPER = "Leagues Optimizer";

	private static final String MENUOP_STARTGENERICHELPER = "Start Helper";
	private static final String MENUOP_STOPGENERICHELPER = "Stop Helper";
	private static final String MENUOP_GENERICHELPER = "Helper";

	private static final Zone PHOENIX_START_ZONE = new Zone(new WorldPoint(3204, 3488, 0), new WorldPoint(3221, 3501, 0));

	@Inject
	private QuestBank questBank;

	@Getter
	private QuestHelperBankTagService bankTagService;

	private QuestBankTab bankTagsMain;

	@Getter
	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Getter
	@Inject
	public ClientThread clientThread;

	@Inject
	private EventBus eventBus;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private QuestHelperOverlay questHelperOverlay;

	@Inject
	private QuestHelperWidgetOverlay questHelperWidgetOverlay;

	@Inject
	private QuestHelperWorldOverlay questHelperWorldOverlay;

	@Inject
	private QuestHelperWorldArrowOverlay questHelperWorldArrowOverlay;

	@Inject
	private QuestHelperWorldLineOverlay questHelperWorldLineOverlay;

	@Getter
	@Inject
	private BankSearch bankSearch;

	@Getter
	@Inject
	private ItemManager itemManager;

	@Getter
	@Inject
	ChatMessageManager chatMessageManager;

	@Inject
	private QuestHelperDebugOverlay questHelperDebugOverlay;

	@Getter
	@Inject
	private QuestHelperConfig config;

	@Getter
	private QuestHelper selectedQuest = null;

	@Getter
	@Inject
	@Named("developerMode")
	private boolean developerMode;

	@Setter
	private QuestHelper sidebarSelectedQuest = null;

	private QuestStep lastStep = null;

	private Map<String, QuestHelper> quests;

	private Map<String, QuestHelper> achievements;

	private ShatteredRelicsLeagueTasks leaguesQuestHelper;

	private Map<String, ActionHelper> actions;

	private List<ActionHelper> filteredActions = new ArrayList<>();

	@Inject
	SpriteManager spriteManager;

	@Getter
	@Inject
	private ColorPickerManager colorPickerManager;

	@Getter
	@Inject
	ConfigManager configManager;

	public ActionHelper nextSelectedAction = null;

	private QuestHelperPanel panel;

	private NavigationButton navButton;

	public boolean loadQuestList;

	public boolean refreshPanels = false;

	public boolean enableAutoRecalculate = true;

	private boolean displayNameKnown;

	@Provides
	QuestHelperConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(QuestHelperConfig.class);
	}

	public boolean isCurrentStepSelection(ActionHelper action)
	{
		if (getSelectedQuest() == action.questHelper)
		{
			if (CurrentStepSelected == action.getQuestStep())
			{
				return true;
			}

			if (action.questHelper.getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY &&
					action.questHelper.getQuest().getQuestType() != Quest.Type.LEAGUES_TASK)
			{
				if (CurrentStepSelected != null && action.getQuestStep().getCurrentStep() == action.getQuestStep())
				{
					return true;
				}
			}
		}

		return false;
	}

	public void recreateActions()
	{
		if (client != null && client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invokeLater(() ->
			{
				if (actions != null)
				{
					actions.clear();
				}
				actions = createAllLeaguesActions(quests, achievements, getClass().getClassLoader());
			});
		}
	}

	@Override
	protected void startUp() throws IOException
	{
		bankTagService = new QuestHelperBankTagService(this, questBank);
		bankTagsMain = new QuestBankTab(this);
		bankTagsMain.startUp();

		injector.injectMembers(bankTagsMain);
		eventBus.register(bankTagsMain);

		quests = scanAndInstantiateQuests(getClass().getClassLoader());
		achievements = scanAndInstantiateAchievements(getClass().getClassLoader());
		leaguesQuestHelper = new ShatteredRelicsLeagueTasks();


		overlayManager.add(questHelperOverlay);
		overlayManager.add(questHelperWorldOverlay);
		overlayManager.add(questHelperWorldArrowOverlay);
		overlayManager.add(questHelperWorldLineOverlay);
		overlayManager.add(questHelperWidgetOverlay);

		final BufferedImage icon = Icon.LEAGUES_ICON.getImage();

		panel = new QuestHelperPanel(this);
		navButton = NavigationButton.builder()
				.tooltip("Leagues Optimizer")
				.icon(icon)
				.priority(7)
				.panel(panel)
				.build();

		clientToolbar.addNavigation(navButton);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			MarkUIAndActionRefresh(false, false);
		}
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(bankTagsMain);
		overlayManager.remove(questHelperOverlay);
		overlayManager.remove(questHelperWorldOverlay);
		overlayManager.remove(questHelperWorldArrowOverlay);
		overlayManager.remove(questHelperWorldLineOverlay);
		overlayManager.remove(questHelperWidgetOverlay);
		overlayManager.remove(questHelperDebugOverlay);

		clientToolbar.removeNavigation(navButton);
		shutDownQuest(false);
		bankTagService = null;
		bankTagsMain = null;
		quests = null;
	}

	public void MarkUIAndActionRefresh(boolean bUIRefreshNeeded, boolean bActionRefreshNeeded)
	{
		if (client != null && (client.getGameState() == GameState.LOGGED_IN))
		{
			if (enableAutoRecalculate && bActionRefreshNeeded)
			{
				loadQuestList = true;
			}

			else if (bUIRefreshNeeded)
			{
				refreshPanels = true;
			}
		}
		// No game tick
		else if (bUIRefreshNeeded)
		{
			updateActionList(bActionRefreshNeeded);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (shortestPathPlugin == null)
		{
			shortestPathPlugin = ShortestPathPlugin.Shortpathplugin;
		}

		if (!displayNameKnown)
		{
			Player localPlayer = client.getLocalPlayer();
			if (localPlayer != null && localPlayer.getName() != null)
			{
				displayNameKnown = true;
				questBank.loadState();
			}
		}
		if (sidebarSelectedQuest != null)
		{
			startUpQuest(sidebarSelectedQuest);
			sidebarSelectedQuest = null;
		}
		else if (selectedQuest != null)
		{
			if (selectedQuest.getCurrentStep() != null)
			{
				panel.updateSteps();
				QuestStep currentStep = selectedQuest.getCurrentStep().getSidePanelStep();
				if (currentStep != null && currentStep != lastStep)
				{
					lastStep = currentStep;
					updateShortestPath();
					MarkUIAndActionRefresh(false, true);
				}
				clientThread.invokeLater(() -> panel.updateItemRequirements(client, questBank.getBankItems()));
				panel.updateLocks();
			}
		}

		if (loadQuestList)
		{
			loadQuestList = false;
			refreshPanels = false;
			updateActionList(true);
		}

		if (refreshPanels)
		{
			refreshPanels = false;
			updateActionList(false);
		}

		if (nextSelectedAction != null)
		{
			clientThread.invokeLater(() ->
			{
				if (isCurrentStepSelection(nextSelectedAction))
				{
					CurrentStepSelected = null;
					if (getSelectedQuest() != null)
					{
						getSelectedQuest().setCurrentStep(OldStepSelected);
					}
					nextSelectedAction.getQuestHelper().client = getClient();
					nextSelectedAction.getQuestHelper().updateQuest();

					startUpQuest(null);
				}
				else
				{
					nextSelectedAction.questHelperPlugin = this;
					nextSelectedAction.getQuestHelper().client = getClient();
					nextSelectedAction.getQuestHelper().updateQuest();
					OldStepSelected = nextSelectedAction.getQuestStep().getCurrentStep();
					if (OldStepSelected == null)
					{
						CurrentStepSelected = nextSelectedAction.getQuestStep();
					}
					else
					{
						CurrentStepSelected = OldStepSelected;
					}

					nextSelectedAction.getQuestHelper().setCurrentStep(CurrentStepSelected);

					startUpQuest(nextSelectedAction.getQuestHelper());
				}

				MarkUIAndActionRefresh(true, true);
				nextSelectedAction = null;
			});
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.BANK))
		{
			questBank.updateLocalBank(event.getItemContainer().getItems());
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		final GameState state = event.getGameState();

		if (state == GameState.LOGIN_SCREEN)
		{
			questBank.saveBankToConfig();
			panel.refresh(Collections.emptyList(), true);
			questBank.emptyState();
			if (selectedQuest != null && selectedQuest.getCurrentStep() != null)
			{
				shutDownQuest(true);
			}
		}

		if (state == GameState.LOGGED_IN)
		{
			MarkUIAndActionRefresh(false, false);
			displayNameKnown = false;
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (!(client.getGameState() == GameState.LOGGED_IN))
		{
			return;
		}

		if (selectedQuest == null)
		{
			return;
		}

		if (selectedQuest.updateQuest() && selectedQuest.getCurrentStep() == null)
		{
			shutDownQuest(true);
		}

		clientThread.invokeLater(() -> {
			if ((selectedQuest != null) && selectedQuest.isCompleted())
			{
				shutDownQuest(true);
			}
		});
	}

	private final Collection<String> configEvents = Arrays.asList("filterListBy");

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("leaguesOptimizer"))
		{
			clientThread.invokeLater(() ->
			{
				MarkUIAndActionRefresh(true, true);
			});
		}
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (developerMode && commandExecuted.getCommand().equals("questhelperdebug"))
		{
			if (commandExecuted.getArguments().length == 0 ||
					(Arrays.stream(commandExecuted.getArguments()).toArray()[0]).equals("disable"))
			{
				overlayManager.remove(questHelperDebugOverlay);
			}
			else if ((Arrays.stream(commandExecuted.getArguments()).toArray()[0]).equals("enable"))
				overlayManager.add(questHelperDebugOverlay);
		}
	}

	@Subscribe(priority = 100)
	private void onClientShutdown(ClientShutdown e)
	{
		questBank.saveBankToConfig();
	}

	public void updateActionList(boolean bUpdateFilteredActions)
	{
		clientThread.invokeLater(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				// Get all actions and use AI to figure out what order we should do them
				if (bUpdateFilteredActions && actions != null)
				{
					Comparator<ActionHelper> actionHelperComparator = (p1, p2) -> p1.sortLeaguePointPotential(p2);

					ActionConfig FilterConfig = config.filterListBy();

					// Update cached distance to player for all stored actions
					for (Map.Entry<String,ActionHelper> entry : actions.entrySet())
					{
						if (FilterConfig != ActionConfig.LP_Potential_NoDist &&
								FilterConfig != ActionConfig.Only_LP)
						{
							entry.getValue().UpdateDistanceFromPlayer(client);
						}
						entry.getValue().UpdateLeaguePointPotential();
					}

					if (FilterConfig == ActionConfig.LP_Potential_NoDist)
					{
						actionHelperComparator = (p1, p2) -> p1.sortLeaguePointPotentialNoDistance(p2);
					}
					else if (FilterConfig == ActionConfig.LP_Potential_NoReq)
					{
						actionHelperComparator = (p1, p2) -> p1.sortLeaguePointPotentialNoReq(p2);
					}
					else if (FilterConfig == ActionConfig.Only_Distance)
					{
						actionHelperComparator = (p1, p2) -> p1.sortOnlyDistance(p2);
					}
					else if (FilterConfig == ActionConfig.Only_LP)
					{
						actionHelperComparator = (p1, p2) -> p1.sortOnlyLeaguePoints(p2);
					}

					Stream<ActionHelper> actionStream = actions.values().stream();

					DisplayConfig FilterConfig2 = config.filterListBy2();


					if (FilterConfig2 == DisplayConfig.ALL_QUEST_STEPS)
					{
						actionStream = actionStream.filter(ActionHelper::isQuest);
					}
					else if (FilterConfig2 == DisplayConfig.ALL_ACHIEVEMENTS)
					{
						actionStream = actionStream.filter(ActionHelper::isAchievementDiary);
					}
					else if (FilterConfig2 == DisplayConfig.ALL_LEAGUES_TASKS)
					{
						actionStream = actionStream.filter(ActionHelper::isLeagueTask);
					}
					else if (FilterConfig2 != DisplayConfig.ALL_ACTIONS)
					{
						if (FilterConfig2 == DisplayConfig.Quests)
						{
							actionStream = actionStream.filter(ActionHelper::isQuest);
						}
						else if (FilterConfig2 == DisplayConfig.Achievements)
						{
							actionStream = actionStream.filter(ActionHelper::isAchievementDiary);
						}
						else if (FilterConfig2 == DisplayConfig.Tasks)
						{
							actionStream = actionStream.filter(ActionHelper::isLeagueTask);
						}
						else if (FilterConfig2 == DisplayConfig.Tasks_wQuests)
						{
							actionStream = actionStream.filter(ActionHelper::isLeagueTaskOrQuest);
						}
						else if (FilterConfig2 == DisplayConfig.Tasks_wAchievements)
						{
							actionStream = actionStream.filter(ActionHelper::isLeagueTaskOrAchievements);
						}
						else if (FilterConfig2 == DisplayConfig.Quests_wAchievements)
						{
							actionStream = actionStream.filter(ActionHelper::isQuestsOrAchievements);
						}

						actionStream = actionStream.filter(ActionHelper::isNotCompleted);

						if (!getConfig().getAllSkillsUnlocked())
						{
							actionStream = actionStream.filter(ActionHelper::canAcceptAllRewards);
						}
					}

					filteredActions = actionStream.sorted(actionHelperComparator).collect(Collectors.toList());

					// Go through all our filtered actions and remove duplicates
					Set<Integer> actionsToRemove = new HashSet<>();
					for (int i = 0; i < filteredActions.size(); ++i)
					{
						for (int j = i + 1; j < filteredActions.size(); ++j)
						{
							ActionHelper ActionHelperI = filteredActions.get(i);
							ActionHelper ActionHelperJ = filteredActions.get(j);
							if (ActionHelperI.getQuestStep() == ActionHelperJ.getQuestStep())
							{
								if (ActionHelperI.getQuestStepNumber() < ActionHelperJ.getQuestStepNumber())
								{
									actionsToRemove.add(j);
								}
								else
								{
									actionsToRemove.add(i);
								}
							}
						}
					}

					List<Integer> actionsToRemoveList = new ArrayList<>(actionsToRemove);
					Collections.sort(actionsToRemoveList, Collections.reverseOrder());
					for (Integer index : actionsToRemoveList)
					{
						filteredActions.remove(index.intValue());
					}

					Set<String> hiddenTasks = getConfig().gethiddenTaskSection();

					shortestPathPlugin.clearTaskMarkers();
					for (int i = 0; i < filteredActions.size(); ++i)
					{
						ActionHelper CurrentAction = filteredActions.get(i);
						if (hiddenTasks.contains(CurrentAction.getActionDescription()))
						{
							continue;
						}

						int ImageType = 0;
						if (CurrentAction.questHelper.getQuest().getQuestType() == Quest.Type.ACHIEVEMENT_DIARY)
						{
							int Difficulty =CurrentAction.getQuestHelper().getLPPointDifficultyModifier();

							// Easy
							if (Difficulty == 100)
							{
								ImageType = 9;
							}
							else if (Difficulty == 200)
							{
								ImageType = 10;
							}
							else if (Difficulty == 500)
							{
								ImageType = 11;
							}
							else if (Difficulty == 750)
							{
								ImageType = 12;
							}
							else
							{
								ImageType = 1;
							}

						}
						else if (CurrentAction.questHelper.getQuest().getQuestType() == Quest.Type.LEAGUES_TASK)
						{
							if (CurrentAction.getDirectLeaguePoints() == 5)
							{
								ImageType = 4;
							}
							else if (CurrentAction.getDirectLeaguePoints() == 25)
							{
								ImageType = 5;
							}
							else if (CurrentAction.getDirectLeaguePoints() == 50)
							{
								ImageType = 6;
							}
							else if (CurrentAction.getDirectLeaguePoints() == 125)
							{
								ImageType = 7;
							}
							else if (CurrentAction.getDirectLeaguePoints() == 250)
							{
								ImageType = 8;
							}
							else
							{
								ImageType = 2;
							}
						}
						else if (CurrentAction.questHelper.getQuest().getQuestType() == Quest.Type.MINIQUEST)
						{
							ImageType = 3;
						}

						shortestPathPlugin.addTaskMarker(CurrentAction.getActionDescription(), CurrentAction, CurrentAction.getQuestStep().getWorldLocation(), ImageType);
					}
				}

				SwingUtilities.invokeLater(() ->
				{
					panel.refresh(filteredActions, false);
				});
			}
			else
			{
				SwingUtilities.invokeLater(() ->
				{
					filteredActions.clear();
					panel.refresh(filteredActions, true);
				});
			}
			updateShortestPath();
		});
	}

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuAction() != MenuAction.RUNELITE)
		{
			return;
		}

		switch (event.getMenuOption())
		{
			case MENUOP_STARTGENERICHELPER:
				event.consume();
				String quest = Text.removeTags(event.getMenuTarget());
				startUpQuest(quests.get(quest));
				break;
			case MENUOP_STOPGENERICHELPER:
				event.consume();
				shutDownQuest(true);
				break;
		}
	}

	private MenuEntry[] addRightClickMenuOptions(String helperName, String entryName, String target,
												 MenuEntry[] menuEntries,
												 int widgetIndex, int widgetID)
	{
		QuestHelper questHelper = quests.get(helperName);
		if (questHelper != null && !questHelper.isCompleted())
		{
			if (selectedQuest != null && selectedQuest.getQuest().getName().equals(helperName))
			{
				return addNewEntry(menuEntries, "Stop " + entryName, target, widgetIndex, widgetID);
			}
			else
			{
				return addNewEntry(menuEntries, "Start " + entryName, target, widgetIndex, widgetID);
			}
		}

		return menuEntries;
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		int widgetIndex = event.getActionParam0();
		int widgetID = event.getActionParam1();
		MenuEntry[] menuEntries = client.getMenuEntries();
		String target = Text.removeTags(event.getTarget());

	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		/*
		if (config != null && chatMessage != null && config.autoStartQuests() && chatMessage.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (selectedQuest == null && chatMessage.getMessage().contains("You've started a new quest"))
			{
				String questName = chatMessage.getMessage().substring(chatMessage.getMessage().indexOf(">") + 1);
				questName = questName.substring(0, questName.indexOf("<"));

				// Prompt for starting Shield of Arrav is the same for both routes. Display actual route started
				if (questName.equals("Shield of Arrav"))
				{
					Player player = client.getLocalPlayer();
					if (player == null)
					{
						return;
					}
					WorldPoint location = player.getWorldLocation();

					if (PHOENIX_START_ZONE.contains(location))
					{
						startUpQuest(quests.get(QuestHelperQuest.SHIELD_OF_ARRAV_PHOENIX_GANG.getName()));
					}
					else
					{
						startUpQuest(quests.get(QuestHelperQuest.SHIELD_OF_ARRAV_BLACK_ARM_GANG.getName()));
					}
				}
				else if (questName.equals("Recipe for Disaster"))
				{
					startUpQuest(quests.get(QuestHelperQuest.RECIPE_FOR_DISASTER_START.getName()));
				}
				else
				{
					QuestHelper questHelper = quests.get(questName);
					if (questHelper != null)
					{
						startUpQuest(questHelper);
					}
				}
			}
		}*/
	}


	private void displayPanel()
	{
		SwingUtilities.invokeLater(() -> {
			if (!navButton.isSelected())
			{
				navButton.getOnSelect().run();
			}
		});
	}

	private MenuEntry[] addNewEntry(MenuEntry[] menuEntries, String newEntry, String target, int widgetIndex, int widgetID)
	{
		menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);

		client.createMenuEntry(menuEntries.length - 1)
				.setOption(newEntry)
				.setTarget(target)
				.setType(MenuAction.RUNELITE)
				.setParam0(widgetIndex)
				.setParam1(widgetID);

		return menuEntries;
	}

	public void updateShortestPath()
	{
		if (shortestPathPlugin != null)
		{
			if (selectedQuest != null)
			{
				shortestPathPlugin.setTarget(selectedQuest.getCurrentStep().getWorldLocation());
				shortestPathPlugin.transportStart = client.getLocalPlayer().getWorldLocation();
			}
			else
			{
				shortestPathPlugin.setTarget(null);
				shortestPathPlugin.transportStart = client.getLocalPlayer().getWorldLocation();
			}
		}
	}

	public void startUpQuest(QuestHelper questHelper)
	{
		clientThread.invokeLater(() ->
		{
			if (!(client.getGameState() == GameState.LOGGED_IN))
			{
				return;
			}

			eventBus.unregister(selectedQuest);
			selectedQuest = questHelper;
			if (questHelper != null)
			{
				questHelper.client = client;
				eventBus.register(questHelper);

			}
			updateShortestPath();
		});
	}

	public void shutDownQuestFromSidebar()
	{
		if (selectedQuest != null)
		{
			selectedQuest.shutDown();
			bankTagsMain.shutDown();
			SwingUtilities.invokeLater(() -> panel.removeQuest());
			eventBus.unregister(selectedQuest);
			selectedQuest = null;
		}
	}

	private void shutDownQuest(boolean shouldUpdateList)
	{
		if (selectedQuest != null)
		{
			selectedQuest.shutDown();
			if (bankTagsMain != null)
			{
				bankTagsMain.shutDown();
			}
			SwingUtilities.invokeLater(() -> panel.removeQuest());
			eventBus.unregister(selectedQuest);
			selectedQuest = null;
		}
	}

	private Map<String, QuestHelper> scanAndInstantiateQuests(ClassLoader classLoader) throws IOException
	{

		Map<String, QuestHelper> scannedQuests = new HashMap<>();
		ClassPath classPath = ClassPath.from(classLoader);

		scannedQuests.putAll(instantiate(classPath, QuestHelperPlugin.QUEST_PACKAGE));

		return scannedQuests;
	}

	private Map<String, QuestHelper> scanAndInstantiateAchievements(ClassLoader classLoader) throws IOException
	{

		Map<String, QuestHelper> scannedAchievements = new HashMap<>();
		ClassPath classPath = ClassPath.from(classLoader);

		scannedAchievements.putAll(instantiate(classPath, QuestHelperPlugin.ACHIEVEMENT_PACKAGE));

		return scannedAchievements;
	}

	public Map<String, ActionHelper> createAllLeaguesActions(Map<String, QuestHelper> QuestHelperTasks, Map<String, QuestHelper> AchievementHelperTasks, ClassLoader classLoader)
	{
		Map<String, ActionHelper> scannedActions = new HashMap<>();

		// Create all the actions required for each quest
		for (Map.Entry<String, QuestHelper> entry : QuestHelperTasks.entrySet())
		{
			entry.getValue().questHelperPlugin = this;
			entry.getValue().client = client;
			int ActionCounter[] = {0};

			Map<String, ActionHelper> newActions = new HashMap<>();
			entry.getValue().getActionList(newActions, ActionCounter);
			scannedActions.putAll(newActions);

			int HighestCount = -1;
			ActionHelper LastAction = null;
			for (Map.Entry<String, ActionHelper> actionEntry : newActions.entrySet())
			{
				int newCount = actionEntry.getValue().getQuestStepNumber();
				if (HighestCount < newCount)
				{
					HighestCount = newCount;
					LastAction = actionEntry.getValue();
				}
				actionEntry.getValue().questHelperPlugin = this;
			}

			if (LastAction != null)
			{
				LastAction.isLastStep = true;
			}
			entry.getValue().setNumTotalSteps(ActionCounter[0]);
		}

		// Create all actions required for each achievement diary
		for (Map.Entry<String, QuestHelper> entry : AchievementHelperTasks.entrySet())
		{
			entry.getValue().questHelperPlugin = this;
			entry.getValue().client = client;
			int ActionCounter[] = {0};
			Map<String, ActionHelper> newActions = new HashMap<>();
			entry.getValue().getActionList(newActions, ActionCounter);
			scannedActions.putAll(newActions);

			for (Map.Entry<String, ActionHelper> actionEntry : newActions.entrySet())
			{
				actionEntry.getValue().questHelperPlugin = this;
			}

			entry.getValue().setNumTotalSteps(ActionCounter[0]);
		}

		// Add leagues tasks
		int ActionCounter[] = {0};
		leaguesQuestHelper.questHelperPlugin = this;
		leaguesQuestHelper.client = client;
		leaguesQuestHelper.setupSteps();
		Map<String, ActionHelper> newActions = new HashMap<>();
		leaguesQuestHelper.getActionList(newActions, ActionCounter);
		scannedActions.putAll(newActions);
		leaguesQuestHelper.setNumTotalSteps(ActionCounter[0] + 1);

		for (Map.Entry<String, ActionHelper> actionEntry : newActions.entrySet())
		{
			actionEntry.getValue().questHelperPlugin = this;
		}

		return scannedActions;
	}

	private Map<String, QuestHelper> instantiate(ClassPath classPath, String packageName)
	{
		Map<String, QuestHelper> scannedQuests = new HashMap<>();
		Map<QuestHelperQuest, Class<? extends QuestHelper>> tmpQuests = new HashMap<>();

		ImmutableSet<ClassPath.ClassInfo> classes = classPath.getTopLevelClassesRecursive(packageName);
		for (ClassPath.ClassInfo classInfo : classes)
		{
			Class<?> clazz = classInfo.load();
			QuestDescriptor questDescriptor = clazz.getAnnotation(QuestDescriptor.class);

			if (questDescriptor == null)
			{
				if (clazz.getSuperclass() == QuestHelper.class)
				{
					log.warn("Class {} is a quest helper, but has no quest descriptor",
							clazz);
				}
				continue;
			}

			if (clazz.isAssignableFrom(QuestHelper.class))
			{
				log.warn("Class {} has quest descriptor, but is not a quest helper",
						clazz);
				continue;
			}

			Class<QuestHelper> questClass = (Class<QuestHelper>) clazz;
			tmpQuests.put(questDescriptor.quest(), questClass);
		}

		for (Map.Entry<QuestHelperQuest, Class<? extends QuestHelper>> questClazz : tmpQuests.entrySet())
		{
			QuestHelper questHelper;
			try
			{
				questHelper = instantiate((Class<QuestHelper>) questClazz.getValue(), questClazz.getKey());
			}
			catch (QuestInstantiationException ex)
			{
				log.warn("Error instantiating quest helper!", ex);
				continue;
			}

			scannedQuests.put(questClazz.getKey().getName(), questHelper);
		}

		return scannedQuests;
	}

	private QuestHelper instantiate(Class<QuestHelper> clazz, QuestHelperQuest quest) throws QuestInstantiationException
	{
		QuestHelper questHelper;
		try
		{
			questHelper = clazz.newInstance();
			Module questModule = (Binder binder) ->
			{
				binder.bind(clazz).toInstance(questHelper);
				binder.install(questHelper);
			};
			Injector questInjector = RuneLite.getInjector().createChildInjector(questModule);
			questInjector.injectMembers(questHelper);
			questHelper.setInjector(questInjector);
			questHelper.setQuest(quest);
			questHelper.setConfig(config);
		}
		catch (InstantiationException | IllegalAccessException | CreationException ex)
		{
			throw new QuestInstantiationException(ex);
		}

		log.debug("Loaded quest helper {}", clazz.getSimpleName());
		return questHelper;
	}
}
