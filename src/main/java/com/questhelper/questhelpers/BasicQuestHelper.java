/*
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
package com.questhelper.questhelpers;

import com.questhelper.QuestHelperConfig;
import com.questhelper.requirements.Requirement;
import com.questhelper.requirements.conditional.Conditions;
import com.questhelper.requirements.util.LogicType;

import java.util.*;

import com.questhelper.panel.PanelDetails;
import com.questhelper.steps.QuestStep;
import net.runelite.api.coords.WorldPoint;

public abstract class BasicQuestHelper extends QuestHelper
{
	protected Map<Integer, QuestStep> steps;
	protected int var;

	@Override
	public void startUp(QuestHelperConfig config)
	{
		this.config = config;
		if (steps == null || steps.size() == 0)
		{
			steps = loadSteps();
			instantiateSteps(steps.values());
			var = getVar();
			startUpStep(steps.get(var));
		}
	}

	@Override
	public QuestStep getStep(int StepNumber)
	{
		if(steps == null)
		{
			steps = loadSteps();
		}

		if(steps != null)
		{
			return steps.get(StepNumber);
		}

		return null;
	}

	@Override
	public void getActionList(Map<String, ActionHelper> scannedActions, int ActionCounter[])
	{
		if (steps == null || steps.size() == 0)
		{
			steps = loadSteps();
		}

		// achievement diary
		if (getLPPointDifficultyModifier() != 0.0f)
		{
			// Use steps instead of panel for our actions
			List<PanelDetails> panels = getPanels();
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
		else
		{
			if(steps != null)
			{
				// Go through all the steps
				for (Map.Entry<Integer, QuestStep> stepEntry : steps.entrySet())
				{
					stepEntry.getValue().client = client;
					stepEntry.getValue().getActionList(scannedActions, ActionCounter);
				}
			}

		}
	}

	@Override
	public void shutDown()
	{
		steps = null;
		shutDownStep();
	}

	@Override
	public boolean updateQuest()
	{
		if (steps.size() > 0 && (var < getVar() || getCurrentStep() != steps.get(var)))
		{
			// Go through all the steps
			for (Map.Entry<Integer, QuestStep> stepEntry : steps.entrySet())
			{
				stepEntry.getValue().client = client;
			}

			var = getVar();
			shutDownStep();
			startUpStep(steps.get(var));
			return true;
		}
		return false;
	}

	public List<PanelDetails> getPanels() {
		List<PanelDetails> panelSteps = new ArrayList<>();
		steps.forEach((id, step) -> panelSteps.add(new PanelDetails("", step)));
		return panelSteps;
	}

	public abstract Map<Integer, QuestStep> loadSteps();

	protected Requirement nor(Requirement... condition)
	{
		return new Conditions(LogicType.NOR, condition);
	}
}
