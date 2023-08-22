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
import com.questhelper.QuestHelperPlugin;
import com.questhelper.questhelpers.ActionConfig;
import com.questhelper.questhelpers.Quest;
import com.questhelper.questhelpers.QuestHelper;
import com.questhelper.questhelpers.ActionHelper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.questhelper.rewards.ExperienceReward;
import lombok.Getter;
import net.runelite.api.QuestState;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

public class ActionSelectPanel extends JPanel
{
	@Getter
	private final List<String> keywords = new ArrayList<>();

	@Getter
	private final ActionHelper actionHelper;

	private static final ImageIcon START_ICON = Icon.START.getIcon();
	private static final ImageIcon SHOWN_ICON = Icon.SHOWN.getIcon();
	private static final ImageIcon HIDDEN_ICON = Icon.HIDDEN.getIcon();

	public ActionSelectPanel(QuestHelperPlugin questHelperPlugin, ActionHelper actionHelper)
	{
		this.actionHelper = actionHelper;

		keywords.addAll(actionHelper.getQuestHelper().getQuest().getKeywords());

		setLayout(new BorderLayout(3, 0));
		setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH, 70));

		double DistanceFromPlayer = actionHelper.getDistanceFromPlayer();
		String DistanceText;
		if (DistanceFromPlayer > 900000)
		{
			DistanceFromPlayer = 0;
		}

		if (DistanceFromPlayer == 0)
		{
			DistanceText = "Unknown";
		}
		else
		{
			DistanceText = String.valueOf(DistanceFromPlayer);
		}

		boolean DebugSortEnabled = false;

		double DebugSortValue = 0;
		if (DebugSortEnabled)
		{
			ActionConfig FilterConfig = questHelperPlugin.getConfig().filterListBy();

			if (FilterConfig == ActionConfig.LP_Potential_NoDist)
			{
				DebugSortValue = actionHelper.getLeaguePointPotentialNoDistance();
			}
			else if (FilterConfig == ActionConfig.LP_Potential_NoReq)
			{
				DebugSortValue = actionHelper.getLeaguePointPotentialNoReq();
			}
			else if (FilterConfig == ActionConfig.Only_Distance)
			{
				DebugSortValue = actionHelper.getDistanceFromPlayer();
			}
			else if (FilterConfig == ActionConfig.Only_LP)
			{
				DebugSortValue = actionHelper.LeaguePointsFromAction;
			}
			else
			{
				DebugSortValue = actionHelper.getLeaguePointPotential();
			}
		}

		String LabelString = "Dist: " + DistanceText + " " + actionHelper.getActionDescription();
		if (actionHelper.questHelper.getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY &&
				actionHelper.questHelper.getQuest().getQuestType() != Quest.Type.LEAGUES_TASK)
		{
			LabelString = LabelString + actionHelper.getQuestHelper().getNumTotalSteps() + ")";
		}

		if (DebugSortEnabled)
		{
			LabelString = LabelString + " DebugSort: " + DebugSortValue;
		}

		JLabel nameLabel = new JLabel("<html>"+ LabelString +"</html>");

		Color color = Color.LIGHT_GRAY;

		if (actionHelper.getQuestHelper().getQuest().getQuestType() == Quest.Type.ACHIEVEMENT_DIARY)
		{
			color = Color.PINK;
		}

		if (actionHelper.getQuestHelper().getQuest().getQuestType() == Quest.Type.LEAGUES_TASK)
		{
			color = Color.WHITE;
		}

		if (questHelperPlugin.isCurrentStepSelection(actionHelper))
		{
			if (actionHelper.isLastStep)
			{
				color = Color.YELLOW;
			}
			else
			{
				color = Color.GREEN;
			}
		}
		else
		{
			if (actionHelper.isLastStep)
			{
				color = Color.ORANGE;
			}
		}

		// Last step but doesn't have requirements
		if (actionHelper.isLastStep)
		{
			if (actionHelper.getQuestHelper().getExperienceRewards() != null)
			{
				for (ExperienceReward expIter : actionHelper.getQuestHelper().getExperienceRewards())
				{
					if (!actionHelper.questHelperPlugin.getConfig().getskillUnlocks().contains(expIter.skill)
							&& questHelperPlugin.getClient().getSkillExperience(expIter.skill) == 0)
					{
						color = Color.RED;
					}
				}
			}
		}

		JButton markHiddenButton = new JButton();
		markHiddenButton.setBorder(new EmptyBorder(10, 0, 10, 0));
		String ActionName = actionHelper.getActionDescription();
		if (questHelperPlugin.getConfig().gethiddenTaskSection().contains(ActionName))
		{
			markHiddenButton.setIcon(HIDDEN_ICON);
			color = Color.BLACK;
		}
		else
		{
			markHiddenButton.setIcon(SHOWN_ICON);
		}

		nameLabel.setForeground(color);
		add(nameLabel, BorderLayout.CENTER);

		JPanel ButtonCombo = new JPanel();
		ButtonCombo.setBorder(new EmptyBorder(0, 0, 0, 0));
		ButtonCombo.setLayout(new BorderLayout());

		markHiddenButton.addActionListener(e ->
		{
			Set<String> HiddenActions = questHelperPlugin.getConfig().gethiddenTaskSection();
			if (HiddenActions.contains(ActionName))
			{
				HiddenActions.remove(ActionName);
				questHelperPlugin.getConfigManager().setConfiguration("leaguesOptimizer", "gethiddenTaskSection", HiddenActions);
			}
			else
			{
				HiddenActions.add(ActionName);
				questHelperPlugin.getConfigManager().setConfiguration("leaguesOptimizer", "gethiddenTaskSection", HiddenActions);
			}
		});
		ButtonCombo.add(markHiddenButton, BorderLayout.NORTH);

		JButton startButton = new JButton();
		startButton.setBorder(new EmptyBorder(10, 0, 10, 0));
		startButton.setIcon(START_ICON);
		startButton.addActionListener(e ->
		{
			questHelperPlugin.nextSelectedAction = actionHelper;
		});
		ButtonCombo.add(startButton, BorderLayout.SOUTH);
		add(ButtonCombo, BorderLayout.LINE_END);
	}

	public ActionSelectPanel(String text)
	{
		this.actionHelper = null;

		setLayout(new BorderLayout(3, 3));
		setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH, 70));
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JLabel nameLabel = new JLabel(text);
		Color color = Color.WHITE;
		nameLabel.setForeground(color);
		add(nameLabel, BorderLayout.CENTER);
	}
}
