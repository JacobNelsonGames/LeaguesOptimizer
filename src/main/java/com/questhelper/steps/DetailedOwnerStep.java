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
package com.questhelper.steps;

import com.google.inject.Inject;
import com.questhelper.QuestHelperPlugin;
import com.questhelper.questhelpers.QuestHelper;
import com.questhelper.requirements.Requirement;
import java.awt.Graphics2D;
import java.util.Collection;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import net.runelite.api.Client;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.ui.overlay.components.PanelComponent;
import org.apache.commons.lang3.ArrayUtils;

public class DetailedOwnerStep extends QuestStep implements OwnerStep
{
	protected QuestStep currentStep;

	protected Requirement[] requirements;

	@Inject
	protected EventBus eventBus;

	@Override
	public QuestStep getCurrentStep()
	{
		return currentStep;
	}

	@Override
	public boolean containsStep(QuestStep StepToCheck)
	{
		if (currentStep != null)
		{
			return currentStep.containsStep(StepToCheck);
		}

		return currentStep == StepToCheck;
	}

	public DetailedOwnerStep(QuestHelper questHelper, Requirement... requirements)
	{
		super(questHelper);
		this.requirements = requirements;
		setupSteps();
		addSubSteps(getSteps());
	}

	public DetailedOwnerStep(QuestHelper questHelper, String text, Requirement... requirements)
	{
		super(questHelper, text);
		this.requirements = requirements;
		setupSteps();
		addSubSteps(getSteps());
	}

	@Override
	public void startUp()
	{
		updateSteps();
	}

	@Override
	public void shutDown()
	{
		shutDownStep();
		currentStep = null;
	}

	protected void startUpStep(QuestStep step)
	{
		if (currentStep == null)
		{
			currentStep = step;
			if (eventBus != null)
			{
				eventBus.register(currentStep);
			}
			currentStep.client = client;
			currentStep.startUp();
			return;
		}

		if (!step.equals(currentStep))
		{
			shutDownStep();
			if (eventBus != null)
			{
				eventBus.register(step);
			}
			step.client = client;
			step.startUp();
			currentStep = step;
		}
	}

	protected void shutDownStep()
	{
		if (currentStep != null)
		{
			if (eventBus != null)
			{
				eventBus.unregister(currentStep);
			}
			currentStep.client = client;
			currentStep.shutDown();
			currentStep = null;
		}
	}

	public void updateSteps()
	{
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, QuestHelperPlugin plugin, Requirement... additionalRequirements)
	{
		Requirement[] allRequirements = ArrayUtils.addAll(additionalRequirements, requirements);

		if (currentStep != null)
		{
			if (text == null)
			{
				currentStep.makeOverlayHint(panelComponent, plugin, allRequirements);
			}
			else
			{
				currentStep.makeOverlayHint(panelComponent, plugin, text, allRequirements);
			}
		}
	}

	// This should only have been called from a parent ConditionalStep, so default the additional text to the passed in text
	@Override
	public void makeOverlayHint(PanelComponent panelComponent, QuestHelperPlugin plugin, List<String> additionalText, Requirement... additionalRequirements)
	{
		Requirement[] allRequirements = ArrayUtils.addAll(additionalRequirements, requirements);

		if (currentStep != null)
		{
			currentStep.makeOverlayHint(panelComponent, plugin, additionalText, allRequirements);
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, QuestHelperPlugin plugin)
	{
		if (currentStep != null)
		{
			currentStep.makeWorldOverlayHint(graphics, plugin);
		}
	}

	@Override
	public void makeWorldArrowOverlayHint(Graphics2D graphics, QuestHelperPlugin plugin)
	{
		if (currentStep != null)
		{
			client = plugin.getClient();
			currentStep.makeWorldArrowOverlayHint(graphics, plugin);
		}
	}

	@Override
	public void makeWorldLineOverlayHint(Graphics2D graphics, QuestHelperPlugin plugin)
	{
		if (currentStep != null)
		{
			currentStep.client = plugin.getClient();
			currentStep.makeWorldLineOverlayHint(graphics, plugin);
		}
	}

	@Override
	public QuestStep getActiveStep()
	{
		if (currentStep != null)
		{
			return currentStep.getActiveStep();
		}
		else
		{
			return this;
		}
	}


	protected void setupSteps()
	{
	}

	@Override
	public Collection<QuestStep> getSteps()
	{
		return null;
	}
}

