/*
 * Copyright (c) 2021, Zoinkwiz <https://github.com/Zoinkwiz>
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
package com.questhelper.questhelpers;

import com.questhelper.QuestHelperConfig;

import java.util.*;

import com.questhelper.panel.PanelDetails;
import com.questhelper.requirements.Requirement;
import com.questhelper.steps.QuestStep;
import net.runelite.api.coords.WorldPoint;

public abstract class ComplexStateQuestHelper extends QuestHelper
{
	protected QuestStep step;
	protected int var;

	@Override
	public QuestStep getStep(int StepNumber)
	{
		if(step == null)
		{
			step = loadStep();
		}

		if(step != null)
		{
			return step;
		}

		return null;
	}

	@Override
	public void startUp(QuestHelperConfig config)
	{
		this.config = config;
		if (step == null)
		{
			step = loadStep();
			instantiateSteps(Collections.singletonList(step));
			var = getVar();
			startUpStep(step);
		}
	}

	@Override
	public void getActionList(Map<String, ActionHelper> scannedActions, int ActionCounter[])
	{
		if (step == null)
		{
			step = loadStep();
		}

		// Use steps instead of panel for our actions
		List<PanelDetails> panels = getPanels();

		if ((getPanels().size() == 0) ||
				(getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY &&
						getQuest().getQuestType() != Quest.Type.LEAGUES_TASK))
		{
			if (step != null)
			{
				step.client = client;
				step.getActionList(scannedActions, ActionCounter);
			}
		}
		else
		{
			for (int i = 0; i < panels.size(); ++i)
			{
				// Construct actions with a given panel
				PanelDetails thisPanel = panels.get(i);

				List<QuestStep> allSteps = thisPanel.getSteps();

				Set<Requirement> AllRequirements = new HashSet<>();
				AllRequirements.addAll(thisPanel.getRequirements());
				if (thisPanel.getDisplayCondition() != null)
				{
					AllRequirements.add(thisPanel.getDisplayCondition());
				}

				QuestStep LastStep = null;
				WorldPoint LastLocation = null;
				for (int j = 0; j < allSteps.size(); ++j)
				{
					QuestStep currentStep = allSteps.get(j);
					if (currentStep != null)
					{
						AllRequirements.addAll(currentStep.getRequirements());
						LastStep = currentStep;
						if (currentStep.getWorldLocation() != null)
						{
							LastLocation = currentStep.getWorldLocation() ;
						}
					}
				}
				if (LastStep != null)
				{
					String FullText = "";
					if (LastStep.getText().size() != 0)
					{
						FullText = FullText + LastStep.getText().get(0);
					}
					LastStep.setWorldLocation(LastLocation);

					++ActionCounter[0];
					FullText = FullText + "  - " + getQuest().getName();
					if (getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY &&
							getQuest().getQuestType() != Quest.Type.LEAGUES_TASK)
					{
						FullText = FullText + " (Step: " + ActionCounter[0] + "/";
					}

					ActionHelper stepAction = new ActionHelper(this, LastStep, client, FullText, ActionCounter[0]);
					stepAction.ExtraRequirements = new ArrayList<>(AllRequirements);
					scannedActions.put(FullText, stepAction);
				}
			}
		}
	}

	@Override
	public void shutDown()
	{
		step = null;
		shutDownStep();
	}

	@Override
	public boolean updateQuest()
	{
		return true;
	}

	public List<PanelDetails> getPanels()
	{
		return new ArrayList<>();
	}

	public abstract QuestStep loadStep();
}
