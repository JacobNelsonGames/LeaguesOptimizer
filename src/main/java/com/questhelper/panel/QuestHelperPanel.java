/*
 * Copyright (c) 2020, Zoinkwiz
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
package com.questhelper.panel;

import com.questhelper.Icon;
import com.questhelper.QuestHelperConfig;
import com.questhelper.QuestHelperPlugin;
import com.questhelper.QuestHelperQuest;
import com.questhelper.questhelpers.*;
import com.questhelper.steps.QuestStep;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.util.*;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicButtonUI;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.SwingUtil;
import net.runelite.client.util.Text;
import net.runelite.client.game.SkillIconManager;

@Slf4j
public class QuestHelperPanel extends PluginPanel
{
	private final QuestOverviewPanel questOverviewPanel;
	private final FixedWidthPanel questOverviewWrapper = new FixedWidthPanel();
	private static final ImageIcon START_ICON = Icon.START.getIcon();
	private static final ImageIcon UNCHECKED_ICON = Icon.UNCHECKED.getIcon();
	private static final ImageIcon CHECKED_ICON = Icon.CHECKED.getIcon();

	private Map<Skill, JButton> skillDisablePanelIconMap = new HashMap<>();
	private JPanel skillDisablePanel = new JPanel();

	private JPanel skillRow1 = new JPanel();
	private JPanel skillRow2 = new JPanel();
	private JPanel skillRow3 = new JPanel();
	private JPanel skillRow4 = new JPanel();
	private JPanel skillRow5 = new JPanel();
	private JPanel skillRow6 = new JPanel();
	private JPanel skillRow7 = new JPanel();
	private JPanel skillRow8 = new JPanel();
	JPanel skillRowWrapper1 = new JPanel();
	JPanel skillRowWrapper2 = new JPanel();
	JPanel skillRowWrapper3 = new JPanel();

	private JPanel OptimizedActionList = new JPanel();
	private JPanel searchQuestsPanel;

	private final JPanel allDropdownSections = new JPanel();
	private final JComboBox<Enum> filterDropdown;
	private final JComboBox<Enum> filterDropdown2;

	private final FixedWidthPanel questListPanel = new FixedWidthPanel();
	private final FixedWidthPanel questListWrapper = new FixedWidthPanel();
	private final JScrollPane scrollableContainer;
	private final int DROPDOWN_HEIGHT = 20;
//	private boolean settingsPanelActive = false;
	private boolean questActive = false;

	@Inject
	private SkillIconManager iconManager;

	private final ArrayList<ActionSelectPanel> actionSelectPanels = new ArrayList<>();

	QuestHelperPlugin questHelperPlugin;

	JButton autostartButton = new JButton();
	private static final ImageIcon DISCORD_ICON;
	private static final ImageIcon GITHUB_ICON;
	private static final ImageIcon PATREON_ICON;
	private static final ImageIcon SETTINGS_ICON;

	static
	{
		DISCORD_ICON = Icon.DISCORD.getIcon(img -> ImageUtil.resizeImage(img, 16, 16));
		GITHUB_ICON = Icon.GITHUB.getIcon(img -> ImageUtil.resizeImage(img, 16, 16));
		PATREON_ICON = Icon.PATREON.getIcon(img -> ImageUtil.resizeImage(img, 16, 16));
		SETTINGS_ICON = Icon.SETTINGS.getIcon(img -> ImageUtil.resizeImage(img, 16, 16));
	}

	public ImageIcon GetSkillIcon(Skill RelatedSkill)
	{
		if (RelatedSkill == Skill.ATTACK)
		{
			return Icon.ATTACK.getIcon();
		}
		else if (RelatedSkill == Skill.HITPOINTS)
		{
			return Icon.HITPOINTS.getIcon();
		}
		else if (RelatedSkill == Skill.MINING)
		{
			return Icon.MINING.getIcon();
		}
		else if (RelatedSkill == Skill.STRENGTH)
		{
			return Icon.STRENGTH.getIcon();
		}
		else if (RelatedSkill == Skill.AGILITY)
		{
			return Icon.AGILITY.getIcon();
		}
		else if (RelatedSkill == Skill.SMITHING)
		{
			return Icon.SMITHING.getIcon();
		}
		else if (RelatedSkill == Skill.DEFENCE)
		{
			return Icon.DEFENCE.getIcon();
		}
		else if (RelatedSkill == Skill.HERBLORE)
		{
			return Icon.HERBLORE.getIcon();
		}
		else if (RelatedSkill == Skill.FISHING)
		{
			return Icon.FISHING.getIcon();
		}
		else if (RelatedSkill == Skill.RANGED)
		{
			return Icon.RANGED.getIcon();
		}
		else if (RelatedSkill == Skill.THIEVING)
		{
			return Icon.THIEVING.getIcon();
		}
		else if (RelatedSkill == Skill.COOKING)
		{
			return Icon.COOKING.getIcon();
		}
		else if (RelatedSkill == Skill.PRAYER)
		{
			return Icon.PRAYER.getIcon();
		}
		else if (RelatedSkill == Skill.CRAFTING)
		{
			return Icon.CRAFTING.getIcon();
		}
		else if (RelatedSkill == Skill.FIREMAKING)
		{
			return Icon.FIREMAKING.getIcon();
		}
		else if (RelatedSkill == Skill.MAGIC)
		{
			return Icon.MAGIC.getIcon();
		}
		else if (RelatedSkill == Skill.FLETCHING)
		{
			return Icon.FLETCHING.getIcon();
		}
		else if (RelatedSkill == Skill.WOODCUTTING)
		{
			return Icon.WOODCUTTING.getIcon();
		}
		else if (RelatedSkill == Skill.RUNECRAFT)
		{
			return Icon.RUNECRAFT.getIcon();
		}
		else if (RelatedSkill == Skill.SLAYER)
		{
			return Icon.SLAYER.getIcon();
		}
		else if (RelatedSkill == Skill.FARMING)
		{
			return Icon.FARMING.getIcon();
		}
		else if (RelatedSkill == Skill.CONSTRUCTION)
		{
			return Icon.CONSTRUCTION.getIcon();
		}
		else if (RelatedSkill == Skill.HUNTER)
		{
			return Icon.HUNTER.getIcon();
		}

		return null;
	}
	public JButton CreateSkillJButton(Skill RelatedSkill)
	{
		JButton skillButton = skillDisablePanelIconMap.get(RelatedSkill);

		if (skillButton == null)
		{
			skillButton = new JButton();
			skillDisablePanelIconMap.put(RelatedSkill, skillButton);
			skillButton.setBorder(new EmptyBorder(0, PANEL_WIDTH / 6 - 7, 0, PANEL_WIDTH / 6 - 7));
			skillButton.setLayout(new BorderLayout(0, BORDER_OFFSET));
			if (RelatedSkill == null)
			{
				skillButton.setIcon(Icon.ALLSKILLS.getIcon());
				skillButton.addActionListener(e ->
				{
					boolean allSkillsUnlocked2 = questHelperPlugin.getConfig().getAllSkillsUnlocked();
					questHelperPlugin.getConfigManager().setConfiguration("leaguesOptimizer", "getAllSkillsUnlocked", !allSkillsUnlocked2);

					questHelperPlugin.MarkUIAndActionRefresh(true, true);
				});
			}
			else
			{
				skillButton.setIcon(GetSkillIcon(RelatedSkill));
				skillButton.addActionListener(e ->
				{
					Set<Skill> SkillEnableMap = questHelperPlugin.getConfig().getskillUnlocks();
					if (SkillEnableMap.contains(RelatedSkill))
					{
						SkillEnableMap.remove(RelatedSkill);
						questHelperPlugin.getConfigManager().setConfiguration("leaguesOptimizer", "getskillUnlocks", SkillEnableMap);
					}
					else
					{
						SkillEnableMap.add(RelatedSkill);
						questHelperPlugin.getConfigManager().setConfiguration("leaguesOptimizer", "getskillUnlocks", SkillEnableMap);
					}

					questHelperPlugin.MarkUIAndActionRefresh(true, true);
				});
			}
		}
		if (RelatedSkill != null)
		{
			if (questHelperPlugin.getConfig().getskillUnlocks().contains(RelatedSkill))
			{
				skillButton.setForeground(Color.GREEN);
				skillButton.setBackground(Color.GREEN);
			}
			else
			{
				skillButton.setForeground(Color.RED);
				skillButton.setBackground(Color.RED);
			}
		}
		else
		{
			boolean allSkillsUnlocked = questHelperPlugin.getConfig().getAllSkillsUnlocked();
			if (allSkillsUnlocked)
			{
				skillButton.setForeground(Color.GREEN);
				skillButton.setBackground(Color.GREEN);
			}
			else
			{
				skillButton.setForeground(Color.RED);
				skillButton.setBackground(Color.RED);
			}
		}

		skillButton.setVisible(true);
		skillButton.repaint();
		skillButton.revalidate();

		return skillButton;
	}
	public void CreateDisableSkillsPanel()
	{
		skillDisablePanel.removeAll();
		skillDisablePanel.setBorder(new EmptyBorder(5, 10, 5, 10));
		skillDisablePanel.setLayout(new BorderLayout());

		JButton attackButton = CreateSkillJButton(Skill.ATTACK);
		JButton hitpointsButton = CreateSkillJButton(Skill.HITPOINTS);
		JButton miningButton = CreateSkillJButton(Skill.MINING);

		JButton strengthButton = CreateSkillJButton(Skill.STRENGTH);
		JButton agilityButton = CreateSkillJButton(Skill.AGILITY);
		JButton smithingButton = CreateSkillJButton(Skill.SMITHING);

		JButton defenceButton = CreateSkillJButton(Skill.DEFENCE);
		JButton herbloreButton = CreateSkillJButton(Skill.HERBLORE);
		JButton fishingButton = CreateSkillJButton(Skill.FISHING);

		JButton rangedButton = CreateSkillJButton(Skill.RANGED);
		JButton thievingButton = CreateSkillJButton(Skill.THIEVING);
		JButton cookingButton = CreateSkillJButton(Skill.COOKING);

		JButton prayerButton = CreateSkillJButton(Skill.PRAYER);
		JButton craftingButton = CreateSkillJButton(Skill.CRAFTING);
		JButton firemakingButton = CreateSkillJButton(Skill.FIREMAKING);

		JButton magicButton = CreateSkillJButton(Skill.MAGIC);
		JButton fletchingButton = CreateSkillJButton(Skill.FLETCHING);
		JButton woodcuttingButton = CreateSkillJButton(Skill.WOODCUTTING);

		JButton runecraftingButton = CreateSkillJButton(Skill.RUNECRAFT);
		JButton slayerButton = CreateSkillJButton(Skill.SLAYER);
		JButton farmingButton = CreateSkillJButton(Skill.FARMING);

		JButton constructionButton = CreateSkillJButton(Skill.CONSTRUCTION);
		JButton hunterButton = CreateSkillJButton(Skill.HUNTER);
		JButton blankButton = CreateSkillJButton(null);

		skillRow1.removeAll();
		skillRow1.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRow1.setLayout(new BorderLayout());

		skillRow2.removeAll();
		skillRow2.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRow2.setLayout(new BorderLayout());

		skillRow3.removeAll();
		skillRow3.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRow3.setLayout(new BorderLayout());

		skillRow4.removeAll();
		skillRow4.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRow4.setLayout(new BorderLayout());

		skillRow5.removeAll();
		skillRow5.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRow5.setLayout(new BorderLayout());

		skillRow6.removeAll();
		skillRow6.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRow6.setLayout(new BorderLayout());

		skillRow7.removeAll();
		skillRow7.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRow7.setLayout(new BorderLayout());

		skillRow8.removeAll();
		skillRow8.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRow8.setLayout(new BorderLayout());

		skillRow1.add(attackButton, BorderLayout.WEST);
		skillRow1.add(hitpointsButton, BorderLayout.CENTER);
		skillRow1.add(miningButton, BorderLayout.EAST);

		skillRow2.add(strengthButton, BorderLayout.WEST);
		skillRow2.add(agilityButton, BorderLayout.CENTER);
		skillRow2.add(smithingButton, BorderLayout.EAST);

		skillRow3.add(defenceButton, BorderLayout.WEST);
		skillRow3.add(herbloreButton, BorderLayout.CENTER);
		skillRow3.add(fishingButton, BorderLayout.EAST);

		skillRow4.add(rangedButton, BorderLayout.WEST);
		skillRow4.add(thievingButton, BorderLayout.CENTER);
		skillRow4.add(cookingButton, BorderLayout.EAST);

		skillRow5.add(prayerButton, BorderLayout.WEST);
		skillRow5.add(craftingButton, BorderLayout.CENTER);
		skillRow5.add(firemakingButton, BorderLayout.EAST);

		skillRow6.add(magicButton, BorderLayout.WEST);
		skillRow6.add(fletchingButton, BorderLayout.CENTER);
		skillRow6.add(woodcuttingButton, BorderLayout.EAST);

		skillRow7.add(runecraftingButton, BorderLayout.WEST);
		skillRow7.add(slayerButton, BorderLayout.CENTER);
		skillRow7.add(farmingButton , BorderLayout.EAST);

		skillRow8.add(constructionButton, BorderLayout.WEST);
		skillRow8.add(hunterButton, BorderLayout.CENTER);
		skillRow8.add(blankButton, BorderLayout.EAST);

		skillRowWrapper1.removeAll();
		skillRowWrapper1.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRowWrapper1.setLayout(new BorderLayout());

		skillRowWrapper2.removeAll();
		skillRowWrapper2.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRowWrapper2.setLayout(new BorderLayout());

		skillRowWrapper3.removeAll();
		skillRowWrapper3.setBorder(new EmptyBorder(0, 0, 0, 0));
		skillRowWrapper3.setLayout(new BorderLayout());

		skillRowWrapper1.add(skillRow1, BorderLayout.NORTH);
		skillRowWrapper1.add(skillRow2, BorderLayout.CENTER);
		skillRowWrapper1.add(skillRow3, BorderLayout.SOUTH);

		skillRowWrapper2.add(skillRow4, BorderLayout.NORTH);
		skillRowWrapper2.add(skillRow5, BorderLayout.CENTER);
		skillRowWrapper2.add(skillRow6, BorderLayout.SOUTH);

		skillRowWrapper3.add(skillRow7, BorderLayout.NORTH);
		skillRowWrapper3.add(skillRow8, BorderLayout.CENTER);

		skillDisablePanel.add(skillRowWrapper1, BorderLayout.NORTH);
		skillDisablePanel.add(skillRowWrapper2, BorderLayout.CENTER);
		skillDisablePanel.add(skillRowWrapper3, BorderLayout.SOUTH);
	}

	public QuestHelperPanel(QuestHelperPlugin questHelperPlugin)
	{
		super(false);

		this.questHelperPlugin = questHelperPlugin;

		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		/* Setup overview panel */
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new EmptyBorder(10, 10, 5, 10));
		titlePanel.setLayout(new BorderLayout());

		JLabel title = new JLabel();
		title.setText("Leagues Optimizer");
		title.setForeground(Color.WHITE);
		titlePanel.add(title, BorderLayout.WEST);

		// Options
		final JPanel viewControls = new JPanel(new GridLayout(1, 3, 5, 0));
		viewControls.setBackground(ColorScheme.DARK_GRAY_COLOR);

		titlePanel.add(viewControls, BorderLayout.EAST);

		JLabel pleaseLoginLabel = new JLabel();
		pleaseLoginLabel.setForeground(Color.GRAY);
		pleaseLoginLabel.setText("<html><body style='text-align:left'>Please log in to use the leagues optimizer" +
			".</body></html>");

		OptimizedActionList.setLayout(new BorderLayout());
		OptimizedActionList.setBorder(new EmptyBorder(5, 10, 5, 10));
		OptimizedActionList.add(pleaseLoginLabel);
		OptimizedActionList.setVisible(false);

		JPanel reloadActionsPanel = new JPanel();
		reloadActionsPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
		reloadActionsPanel.setLayout(new BorderLayout());

		JLabel reloadallActions = new JLabel();
		reloadallActions.setText("Reload all Actions -> ");
		reloadallActions.setForeground(Color.WHITE);
		reloadallActions.setBorder(new EmptyBorder(5, 10, 5, 10));
		reloadallActions.setLayout(new BorderLayout(0, BORDER_OFFSET));
		reloadActionsPanel.add(reloadallActions, BorderLayout.WEST);

		JButton reloadbutton = new JButton();
		reloadbutton.setIcon(START_ICON);
		reloadbutton.setBorder(new EmptyBorder(5, 10, 5, 10));
		reloadbutton.setLayout(new BorderLayout(0, BORDER_OFFSET));
		reloadbutton.addActionListener(e ->
		{
			questHelperPlugin.CurrentStepSelected = null;
			if (questHelperPlugin.getSelectedQuest() != null)
			{
				questHelperPlugin.getSelectedQuest().setCurrentStep(questHelperPlugin.OldStepSelected);
			}

			questHelperPlugin.startUpQuest(null);
			questHelperPlugin.recreateActions();
			questHelperPlugin.loadQuestList = true;
			questHelperPlugin.MarkUIAndActionRefresh(true, true);
		});
		reloadActionsPanel.add(reloadbutton, BorderLayout.EAST);

		JPanel recalculatePanel = new JPanel();
		recalculatePanel.setBorder(new EmptyBorder(5, 10, 5, 10));
		recalculatePanel.setLayout(new BorderLayout());

		JLabel RecaculateLabel = new JLabel();
		RecaculateLabel.setText("Recalculate Order -> ");
		RecaculateLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
		RecaculateLabel.setLayout(new BorderLayout(0, BORDER_OFFSET));
		RecaculateLabel.setForeground(Color.WHITE);
		recalculatePanel.add(RecaculateLabel, BorderLayout.WEST);

		JButton startButton = new JButton();
		startButton.setIcon(START_ICON);
		startButton.setBorder(new EmptyBorder(5, 10, 5, 10));
		startButton.setLayout(new BorderLayout(0, BORDER_OFFSET));
		startButton.addActionListener(e ->
		{
			questHelperPlugin.loadQuestList = true;
			questHelperPlugin.updateShortestPath();
			questHelperPlugin.MarkUIAndActionRefresh(true, true);
		});
		recalculatePanel.add(startButton, BorderLayout.EAST);

		JPanel autoRecalculatePanel = new JPanel();
		autoRecalculatePanel.setBorder(new EmptyBorder(5, 10, 5, 10));
		autoRecalculatePanel.setLayout(new BorderLayout());

		JLabel autoRecaculateLabel = new JLabel();
		autoRecaculateLabel.setText("Enable Auto Recalculate -> ");
		autoRecaculateLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
		autoRecaculateLabel.setLayout(new BorderLayout(0, BORDER_OFFSET));
		autoRecaculateLabel.setForeground(Color.WHITE);
		autoRecalculatePanel.add(autoRecaculateLabel, BorderLayout.WEST);

		if (questHelperPlugin.enableAutoRecalculate)
		{
			autostartButton.setIcon(CHECKED_ICON);
		}
		else
		{
			autostartButton.setIcon(UNCHECKED_ICON);
		}

		autostartButton.setBorder(new EmptyBorder(5, 10, 5, 10));
		autostartButton.setLayout(new BorderLayout(0, BORDER_OFFSET));
		autostartButton.addActionListener(e ->
		{
			questHelperPlugin.enableAutoRecalculate = !questHelperPlugin.enableAutoRecalculate;
			questHelperPlugin.MarkUIAndActionRefresh(false, true);
			questHelperPlugin.refreshPanels = true;

			if (questHelperPlugin.enableAutoRecalculate)
			{
				autostartButton.setIcon(CHECKED_ICON);
			}
			else
			{
				autostartButton.setIcon(UNCHECKED_ICON);
			}

		});
		autoRecalculatePanel.add(autostartButton, BorderLayout.EAST);

		CreateDisableSkillsPanel();
		searchQuestsPanel = new JPanel();
		searchQuestsPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
		searchQuestsPanel.setLayout(new BorderLayout(0, BORDER_OFFSET));
		searchQuestsPanel.add(OptimizedActionList, BorderLayout.SOUTH);

		questListPanel.setBorder(new EmptyBorder(8, 10, 0, 10));
		questListPanel.setLayout(new DynamicGridLayout(0, 1, 0, 5));
		questListPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		showMatchingQuests("");

		// Filters
		filterDropdown = makeNewDropdown(ActionConfig.values(), "filterListBy");
		JPanel filtersPanel = makeDropdownPanel(filterDropdown, "Filters");
		filtersPanel.setPreferredSize(new Dimension(PANEL_WIDTH, DROPDOWN_HEIGHT));

		filterDropdown2 = makeNewDropdown(DisplayConfig.values(), "filterListBy2");
		JPanel filtersPanel2 = makeDropdownPanel(filterDropdown2, "Type Filters");
		filtersPanel2.setPreferredSize(new Dimension(PANEL_WIDTH, DROPDOWN_HEIGHT));

		allDropdownSections.setBorder(new EmptyBorder(0, 0, 10, 0));
		allDropdownSections.setLayout(new BorderLayout(0, 0));
		allDropdownSections.add(filtersPanel, BorderLayout.NORTH);
		allDropdownSections.add(filtersPanel2, BorderLayout.SOUTH);

		searchQuestsPanel.add(allDropdownSections, BorderLayout.NORTH);

		// Wrapper
		questListWrapper.setLayout(new BorderLayout());
		questListWrapper.add(questListPanel, BorderLayout.NORTH);

		scrollableContainer = new JScrollPane(questListWrapper);
		scrollableContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


		JPanel OptionsPanel = new JPanel();
		OptionsPanel.setLayout(new BorderLayout());

		JPanel introOptionsPanel = new JPanel();
		introOptionsPanel.setLayout(new BorderLayout());
		introOptionsPanel.add(titlePanel, BorderLayout.NORTH);
		introOptionsPanel.add(reloadActionsPanel, BorderLayout.CENTER);
		introOptionsPanel.add(recalculatePanel, BorderLayout.SOUTH);

		OptionsPanel.add(introOptionsPanel, BorderLayout.NORTH);
		OptionsPanel.add(autoRecalculatePanel, BorderLayout.SOUTH);

		JPanel introDetailsPanel = new JPanel();
		introDetailsPanel.setLayout(new BorderLayout());
		introDetailsPanel.add(OptionsPanel, BorderLayout.NORTH);
		introDetailsPanel.add(skillDisablePanel, BorderLayout.CENTER);
		introDetailsPanel.add(searchQuestsPanel, BorderLayout.SOUTH);

		add(introDetailsPanel, BorderLayout.NORTH);
		add(scrollableContainer, BorderLayout.CENTER);

		/* Layout */
		questOverviewPanel = new QuestOverviewPanel(questHelperPlugin);

		questOverviewWrapper.setLayout(new BorderLayout());
		questOverviewWrapper.add(questOverviewPanel, BorderLayout.NORTH);
	}

	private JComboBox<Enum> makeNewDropdown(Enum[] values, String key)
	{
		JComboBox<Enum> dropdown = new JComboBox<>(values);
		dropdown.setFocusable(false);
		dropdown.setForeground(Color.WHITE);
		dropdown.setRenderer(new DropdownRenderer());
		dropdown.addItemListener(e ->
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				Enum source = (Enum) e.getItem();
				questHelperPlugin.getConfigManager().setConfiguration("leaguesOptimizer", key,
					source);
			}
		});

		return dropdown;
	}

	private JPanel makeDropdownPanel(JComboBox dropdown, String name)
	{
		// Filters
		JLabel filterName = new JLabel(name);
		filterName.setForeground(Color.WHITE);

		JPanel filtersPanel = new JPanel();
		filtersPanel.setLayout(new BorderLayout());
		filtersPanel.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
		filtersPanel.add(filterName, BorderLayout.CENTER);
		filtersPanel.add(dropdown, BorderLayout.EAST);

		return filtersPanel;
	}

	private void showMatchingQuests(String text)
	{
		if (text.isEmpty())
		{
			actionSelectPanels.forEach(questListPanel::add);
			return;
		}

		final String[] searchTerms = text.toLowerCase().split(" ");

		actionSelectPanels.forEach(listItem ->
		{
			if (Text.matchesSearchTerms(Arrays.asList(searchTerms), listItem.getKeywords()))
			{
				questListPanel.add(listItem);
			}
		});
	}

	public void refresh(List<ActionHelper> actionHelpers, boolean loggedOut)
	{
		actionSelectPanels.forEach(questListPanel::remove);
		actionSelectPanels.clear();

		filterDropdown2.setSelectedItem(questHelperPlugin.getConfig().filterListBy2());
		filterDropdown.setSelectedItem(questHelperPlugin.getConfig().filterListBy());
		for (ActionHelper actionHelper : actionHelpers)
		{
			actionSelectPanels.add(new ActionSelectPanel(questHelperPlugin, actionHelper));
		}

		if (!loggedOut && actionSelectPanels.isEmpty())
		{
			OptimizedActionList.removeAll();
			JLabel noMatch = new JLabel();
			noMatch.setForeground(Color.GRAY);
			noMatch.setText("<html><body style='text-align:left'>No actions are available that match your current filters</body></html>");
			OptimizedActionList.add(noMatch);
		}

		if (actionSelectPanels.isEmpty())
		{
			questHelperPlugin.CurrentStepSelected = null;
			if (questHelperPlugin.getSelectedQuest() != null)
			{
				questHelperPlugin.getSelectedQuest().setCurrentStep(questHelperPlugin.OldStepSelected);
			}

			questHelperPlugin.startUpQuest(null);
		}
		OptimizedActionList.setVisible(actionSelectPanels.isEmpty());
		CreateDisableSkillsPanel();

		autostartButton.repaint();
		autostartButton.revalidate();

		repaint();
		revalidate();
		showMatchingQuests("");
	}

	public void addQuest(QuestHelper quest, boolean isActive)
	{
		questActive = true;
		//allDropdownSections.setVisible(false);
		scrollableContainer.setViewportView(questOverviewWrapper);

		questOverviewPanel.addQuest(quest, isActive);

		repaint();
		revalidate();
	}

	public void updateSteps()
	{
		questOverviewPanel.updateSteps();
	}

	public void updateHighlight(Client client, QuestStep newStep)
	{
		questOverviewPanel.updateHighlight(client, newStep);

		repaint();
		revalidate();
	}

	public void updateLocks()
	{
		questOverviewPanel.updateLocks();

		repaint();
		revalidate();
	}

	public void removeQuest()
	{
		questActive = false;
		//allDropdownSections.setVisible(true);
		scrollableContainer.setViewportView(questListWrapper);
		questOverviewPanel.removeQuest();

		repaint();
		revalidate();
	}

	private void activateSettings()
	{
//		settingsPanelActive = true;

//		scrollableContainer.setViewportView(configPanel);
		//searchQuestsPanel.setVisible(false);

		repaint();
		revalidate();
	}

	private void deactivateSettings()
	{
//		settingsPanelActive = false;
		if (questActive)
		{
			scrollableContainer.setViewportView(questOverviewWrapper);
		}
		else
		{
			scrollableContainer.setViewportView(questListWrapper);
		}
		//searchQuestsPanel.setVisible(true);

		repaint();
		revalidate();
	}

	public void emptyBar()
	{
	}

	public void updateItemRequirements(Client client, List<Item> bankItems)
	{
		questOverviewPanel.updateRequirements(client, bankItems);
	}
}
