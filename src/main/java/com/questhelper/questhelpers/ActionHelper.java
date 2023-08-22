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

import com.google.inject.Binder;
import com.google.inject.Module;
import com.questhelper.ExternalQuestResources;
import com.questhelper.QuestHelperPlugin;
import com.questhelper.steps.QuestStep;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.Requirement;
import java.awt.Graphics;
import java.util.*;
import javax.inject.Inject;

import com.questhelper.rewards.ExperienceReward;
import com.questhelper.rewards.ItemReward;
import com.questhelper.rewards.QuestPointReward;
import com.questhelper.rewards.UnlockReward;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.Skill;

public class ActionHelper implements Module, QuestDebugRenderer
{
	@Getter
	public final QuestHelper questHelper;

	@Getter
	private final QuestStep questStep;

	@Inject
	protected Client client;

	@Getter
	private String actionDescription = "";

	@Getter
	private int QuestStepNumber = 0;

	private double DistanceFromPlayer = 0;

	public double LeaguePointsFromAction = 0;

	private double LP_PotentialNoReq = 0;

	private double LP_PotentialNoDist = 0;

	private double LP_Potential = 0;

	public List<Requirement> ExtraRequirements;

	public boolean isLastStep = false;

	public QuestHelperPlugin questHelperPlugin;

	public static boolean isLeagueTaskOrQuest(ActionHelper action)
	{
		return action.questHelper.getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY;
	}

	public static boolean isLeagueTaskOrAchievements(ActionHelper action)
	{
		return action.questHelper.getQuest().getQuestType() == Quest.Type.ACHIEVEMENT_DIARY ||
				action.questHelper.getQuest().getQuestType() == Quest.Type.LEAGUES_TASK;
	}

	public static boolean isQuestsOrAchievements(ActionHelper action)
	{
		return action.questHelper.getQuest().getQuestType() != Quest.Type.LEAGUES_TASK;
	}

	public static boolean isQuest(ActionHelper action)
	{
		return action.questHelper.getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY &&
				action.questHelper.getQuest().getQuestType() != Quest.Type.LEAGUES_TASK;
	}

	public static boolean isAchievementDiary(ActionHelper action)
	{
		return action.questHelper.getQuest().getQuestType() == Quest.Type.ACHIEVEMENT_DIARY;
	}

	public static boolean isLeagueTask(ActionHelper action)
	{
		return action.questHelper.getQuest().getQuestType() == Quest.Type.LEAGUES_TASK;
	}

	public static boolean canAcceptAllRewards(ActionHelper action)
	{
		// Only care about obtaining the reward
		if (action.isLastStep)
		{
			if (action.questHelper.getExperienceRewards() != null)
			{
				if (!action.questHelperPlugin.isCurrentStepSelection(action))
				{
					for (ExperienceReward expIter : action.questHelper.getExperienceRewards())
					{
						if (!action.questHelperPlugin.getConfig().getskillUnlocks().contains(expIter.skill)
							&& action.client.getSkillExperience(expIter.skill) == 0)
						{
								return false;
						}
					}
				}
			}
		}

		return true;
	}

	public static double determineRequirementLPCost(ActionHelper action, Client client, List<Requirement> requirementList, boolean bNoMarkedRequirements[])
	{
		double StepRequirementCost = 0;
		if (requirementList != null)
		{
			for (int i = 0; i < requirementList.size(); ++i)
			{
				Requirement currentReq = requirementList.get(i);
				if (currentReq != null)
				{
					if (currentReq.GetRequiredID() > 0)
					{
						boolean checkedReq = currentReq.check(client);
						if (!checkedReq)
						{
							Skill SkillAssociation = currentReq.GetSkillAssociation();
							if (SkillAssociation != null)
							{
								int AmountOfSkillsAway = currentReq.GetAmountOfSkillsAwayFromReq(client);

								if (SkillAssociation == Skill.OVERALL)
								{
									StepRequirementCost = StepRequirementCost + AmountOfSkillsAway * 2.5f + AmountOfSkillsAway * AmountOfSkillsAway * 0.25f;
								}
								else
								{
									StepRequirementCost = StepRequirementCost + AmountOfSkillsAway * 75.0f + AmountOfSkillsAway * AmountOfSkillsAway * 7.5f;
								}
							}
							else
							{
								// Combat req
								if (currentReq.GetRequiredID() == 4)
								{
									int AmountOfSkillsAway = currentReq.GetAmountOfSkillsAwayFromReq(client);
									StepRequirementCost = StepRequirementCost +  AmountOfSkillsAway * 150.0f + AmountOfSkillsAway * AmountOfSkillsAway * 15.0f;
								}
								else
								{
									// Item requirement
									if (action.LeaguePointsFromAction != 0.0f || action.getQuestHelper().getLPPointDifficultyModifier() != 0)
									{
										if (action.LeaguePointsFromAction == 5 || action.getQuestHelper().getLPPointDifficultyModifier() == 100)
										{
											StepRequirementCost = StepRequirementCost + 10.0;
										}
										else if (action.LeaguePointsFromAction == 25 || action.getQuestHelper().getLPPointDifficultyModifier() == 200)
										{
											StepRequirementCost = StepRequirementCost + 100.0;
										}
										else if (action.LeaguePointsFromAction == 50 || action.getQuestHelper().getLPPointDifficultyModifier() == 500)
										{
											StepRequirementCost = StepRequirementCost + 200.0;
										}
										else if (action.LeaguePointsFromAction == 125 || action.getQuestHelper().getLPPointDifficultyModifier() == 750)
										{
											StepRequirementCost = StepRequirementCost + 400.0;
										}
									}
									else
									{
										StepRequirementCost = StepRequirementCost + 200.0;
									}
								}
							}
						}
					}

					if (currentReq.GetRequiredID() > 1 || currentReq.GetSkillAssociation() != null)
					{
						bNoMarkedRequirements[0] = false;
					}
				}
			}
		}
		return StepRequirementCost;
	}

	public static boolean checkRequirementList(ActionHelper action, List<Requirement> requirementList)
	{
		if (requirementList != null)
		{
			for (int i = 0; i < requirementList.size(); ++i)
			{
				Requirement currentReq = requirementList.get(i);

				if (currentReq != null)
				{
					boolean bCheckCurrentReq = true;

					// Skill req, don't check if skill enabled
					Skill AssociatedSkill = currentReq.GetSkillAssociation();
					if (AssociatedSkill != null)
					{
						boolean allSkillsUnlocked = action.questHelperPlugin.getConfig().getAllSkillsUnlocked();
						if (allSkillsUnlocked ||
								AssociatedSkill == Skill.OVERALL ||
								action.questHelperPlugin.getConfig().getskillUnlocks().contains(AssociatedSkill))
						{
							bCheckCurrentReq = false;
						}
					}

					// Do not consider non-required items
					if (currentReq.GetRequiredID() == 2)
					{
						bCheckCurrentReq = false;
					}

					if (bCheckCurrentReq)
					{
						boolean checkedReq = currentReq.check(action.questHelperPlugin.getClient());
						if (!checkedReq)
						{
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	// Is not completed and completable
	public static boolean isNotCompleted(ActionHelper action)
	{
		if (action.questHelper != null)
		{
			if (action.questHelper.isCompleted())
			{
				return false;
			}

			if (action.questHelper.getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY &&
					action.questHelper.getQuest().getQuestType() != Quest.Type.LEAGUES_TASK)
			{
				List<Requirement> RequirementList = action.questHelper.getGeneralRequirements();
				if (!checkRequirementList(action, RequirementList))
				{
					return false;
				}
			}
		}

		if (!checkRequirementList(action, action.ExtraRequirements))
		{
			return false;
		}

		if (action.getQuestStep() != null)
		{
			List<Requirement> RequirementList = action.getQuestStep().getRequirements();
			if (!checkRequirementList(action, RequirementList))
			{
				return false;
			}
		}

		// See if we are on this step currently
		action.questHelper.updateQuest();

		// Still null so quest not started
		if (action.questHelper.getCurrentStep() == null &&
				action.questHelper.getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY &&
				action.questHelper.getQuest().getQuestType() != Quest.Type.LEAGUES_TASK)
		{
			QuestStep FirstStep = action.questHelper.getStep(0);

			// Max 1000 steps
			for (int i = 0; i < 1000; ++i)
			{
				FirstStep = action.questHelper.getStep(i);
				if (FirstStep != null)
				{
					// Max 1000 steps
					int SubstepSize = FirstStep.getSubsteps().size();
					boolean FoundSubstep = false;
					for (int j = 0; j < SubstepSize; ++j)
					{
						QuestStep Substep = FirstStep.getSubsteps().get(j);
						if (Substep != null)
						{
							FirstStep = Substep;
							FoundSubstep = true;
							break;
						}
					}

					// Conditional steps use this
					if (!FoundSubstep)
					{
						FirstStep.client = action.client;
						if (FirstStep.getCurrentStepOrFirstStep(action.questStep) != null)
						{
							FirstStep = FirstStep.getCurrentStepOrFirstStep(action.questStep);
							FoundSubstep = true;
						}
					}

					// If not, we have a null step
					if (SubstepSize == 0 || FoundSubstep)
					{
						break;
					}
				}
			}
			if (FirstStep != action.questStep)
			{
				return false;
			}
		}
		else
		{
			// Current step doesn't matter on achievement diaries
			if (action.questHelper.getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY &&
					action.questHelper.getQuest().getQuestType() != Quest.Type.LEAGUES_TASK)
			{
				action.questHelper.getCurrentStep().client = action.client;
				if (!action.questHelper.getCurrentStep().containsStep(action.questStep))
				{
					if (!action.questHelper.getCurrentStep().containsStep(action.questStep.getCurrentStep()))
					{
						return false;
					}
				}
			}
		}

		if (action.questStep.isLocked())
		{
			return false;
		}

		return true;
	}

	@Override
	public void configure(Binder binder)
	{
	}

	public void UpdateLeaguePointPotential()
	{
		// Calculate league point potential of an action

		if (client != null)
		{
			Player player = client.getLocalPlayer();
			if (player != null)
			{
				// Start with total amount of direct league points we can get from this
				// Add the rewards of this action

				// Experience rewards are worth more the lower level in that skill we are
				double ExperienceLPPotential = 0;
				if (questHelper.getExperienceRewards() != null)
				{
					for (ExperienceReward expIter : questHelper.getExperienceRewards())
					{
						int playerSkillLevel = client.getRealSkillLevel(expIter.skill);

						// Higher level, lower LP potential, can be improved by using a logrithmic scale
						ExperienceLPPotential = (ExperienceLPPotential + expIter.experience / playerSkillLevel);
					}
				}

				// Convert from Experience at level 1 to league point potential:
				// 1xp = (250 / 13,363) -> 0.0187LP ; AKA lvl 30 is around 1 Elite task worth
				ExperienceLPPotential = (ExperienceLPPotential * (250.0 / 13363.0));

				// Quest points are pretty much a linear LP potential
				double QP_LPPotential = 0;
				if (questHelper.getQuestPointReward() != null)
				{
					QP_LPPotential = questHelper.getQuestPointReward().points;
				}

				// Convert from quest point to LP
				// 1 QP = (1250.0 / 284) -> 2.64LP; AKA all quest points are worth ~1250LP)
				QP_LPPotential = QP_LPPotential * (1250.0 / 284.0);

				// Convert from item rewards to LP
				double Item_LPPotential = 0.0;
				double UnlockReward_LPPotential = 0.0;
				double CurrentItemLPPotential = 0.0;
				double CurrentGPPotential = 0;

				if (questHelper.getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY)
				{
					if (questHelper.getItemRewards() != null)
					{
						for (ItemReward expIter : questHelper.getItemRewards())
						{
							if (questStep.itemManager != null)
							{
								CurrentGPPotential = questStep.itemManager.getItemPrice(expIter.itemID) * expIter.quantity;

								// untradable item, so potentially uniquely useful
								if (CurrentGPPotential == 0)
								{
									// # of unique items
									CurrentItemLPPotential = expIter.quantity;
								}
							}
							else
							{
								// Assume worth ~5k
								CurrentGPPotential = CurrentGPPotential + 5000;
							}

							// Convert from GP to LP
							// 1GP = (250.0 / 250000.0 ) -> 0.0005LP ; AKA 250k is ~250LP
							Item_LPPotential = Item_LPPotential + CurrentGPPotential * (250.0 / 250000.0 );

							// Convert from unique quest item to LP
							// 1 quest item = (50.0f / 1.0f) -> 50LP ; AKA each quest item is about 50 league points
							Item_LPPotential = Item_LPPotential + CurrentItemLPPotential * 50.0f;
						}
					}

					if (questHelper.getUnlockRewards() != null)
					{
						for (UnlockReward expIter : questHelper.getUnlockRewards())
						{
							// Convert from unique rewards to LP
							// 1 quest unlock = (50.0f / 1.0f) -> 50LP ; AKA each quest item is about 50 league points
							UnlockReward_LPPotential = UnlockReward_LPPotential + 50.0f;
						}
					}
				}

				/* direct league points are worth 100 times more than potential points (since other rewards aren't considered at all) */
				double DirectLeaguePointsModified = LeaguePointsFromAction;

				if (LeaguePointsFromAction != 0.0f)
				{
					DirectLeaguePointsModified = (LeaguePointsFromAction + 200.0f);
				}

				double RewardPotential = questHelper.getLPPointDifficultyModifier() + DirectLeaguePointsModified + ExperienceLPPotential + QP_LPPotential + Item_LPPotential + UnlockReward_LPPotential;

				// Distance from us
				// 1 block of distance = (1000.0f / 250.0f) ->  4 ; AKA every 1000 blocks is about 250 LP
				double DistanceCost = 0;

				// Start at a negative number to prioritize really close things over unknown location
				double CloseTaskModifier = 0;
				if (DistanceFromPlayer != 0 && DistanceFromPlayer < 150.0f)
				{
					CloseTaskModifier = ((150.0f - DistanceFromPlayer) / 150.0f) * 1500.0f;
				}

				DistanceCost = (DistanceFromPlayer) * (4000.0f / 250.0f) - CloseTaskModifier;


				// Experience requirement
				// Item requirement

				// Item required not on us, inconvient to get it
				double ItemRequirementCost = 0;
				double ItemReccommendedCost = 0;
				double GeneralReccommendedCost = 0;
				double GeneralRequiredCost = 0;
				if (questHelper.getQuest().getQuestType() != Quest.Type.ACHIEVEMENT_DIARY)
				{
					if (questHelper.getItemRequirements() != null)
					{
						for (ItemRequirement expIter : questHelper.getItemRequirements())
						{
							// 1 item needed to get add = ~50LP worth of time
							if (!expIter.check(client))
							{
								ItemRequirementCost = ItemRequirementCost + 50.0;
							}
						}
					}

					if (questHelper.getItemRecommended() != null)
					{
						for (ItemRequirement expIter : questHelper.getItemRecommended())
						{
							// 1 item reccommended to get add = ~20LP worth of time
							if (!expIter.check(client))
							{
								ItemReccommendedCost = ItemReccommendedCost + 20.0;
							}
						}
					}

					if (questHelper.getGeneralRecommended() != null)
					{
						for (Requirement expIter : questHelper.getGeneralRecommended())
						{
							// 1 general reccommended to get add = ~50LP worth of time
							if (!expIter.check(client))
							{
								GeneralReccommendedCost = GeneralReccommendedCost + 50.0;
							}
						}
					}

					if (questHelper.getGeneralRequirements() != null)
					{
						for (Requirement expIter : questHelper.getGeneralRequirements())
						{
							// 1 general required to get add = ~200LP worth of time (need to stop what we are doing and train, which isn't great)
							if (!expIter.check(client))
							{
								if (expIter.GetRequiredID() > 0)
								{
									Skill SkillAssociation = expIter.GetSkillAssociation();
									if (SkillAssociation != null)
									{
										int AmountOfSkillsAway = expIter.GetAmountOfSkillsAwayFromReq(client);

										if (SkillAssociation == Skill.OVERALL)
										{
											GeneralRequiredCost = GeneralRequiredCost + AmountOfSkillsAway * 2.5f + AmountOfSkillsAway * AmountOfSkillsAway * 0.25f;
										}
										else
										{
											GeneralRequiredCost = GeneralRequiredCost + AmountOfSkillsAway * 40.0f + AmountOfSkillsAway * AmountOfSkillsAway * 4.0f;
										}
									}
									else
									{
										// Combat req
										if (expIter.GetRequiredID() == 4)
										{
											int AmountOfSkillsAway = expIter.GetAmountOfSkillsAwayFromReq(client);
											GeneralRequiredCost = GeneralRequiredCost +  AmountOfSkillsAway * 75.0f + AmountOfSkillsAway * AmountOfSkillsAway * 8.0f;
										}
										else
										{
											GeneralRequiredCost = GeneralRequiredCost + 200.0;
										}
									}
								}
							}
						}
					}
				}

				double StepRequirementCost = 0;
				List<Requirement> RequirementList = getQuestStep().getRequirements();
				boolean bNoMarkedRequirements[] = { true };
				StepRequirementCost = determineRequirementLPCost(this, client, RequirementList, bNoMarkedRequirements);
				StepRequirementCost = StepRequirementCost + determineRequirementLPCost(this, client, ExtraRequirements, bNoMarkedRequirements);

				if (questHelper.getQuest().getQuestType() == Quest.Type.LEAGUES_TASK)
				{
					// make requirements for tasks that we don't have worth more based on LP required
					StepRequirementCost = StepRequirementCost * (LeaguePointsFromAction + 200.0f) / 250.0f;
				}

				double LPCost = StepRequirementCost + DistanceCost + ItemRequirementCost + ItemReccommendedCost + GeneralReccommendedCost + GeneralRequiredCost;

				// Subtract the requirements we do not meet (and distance from player)
				LP_Potential = ((RewardPotential) - LPCost);
				LP_PotentialNoReq = ((RewardPotential) - DistanceCost);
				LP_PotentialNoDist = (((RewardPotential) - LPCost) + DistanceCost);

				String ActionName = getActionDescription();
				if (questHelper.questHelperPlugin != null && questHelper.questHelperPlugin.getConfig().gethiddenTaskSection() != null && questHelper.questHelperPlugin.getConfig().gethiddenTaskSection().contains(ActionName))
				{
					LP_Potential = -2147483000;
					LP_PotentialNoReq = -2147483000;
					LP_PotentialNoDist = -2147483000;
				}

				// Selected so move to top
				if (questHelper.questHelperPlugin.isCurrentStepSelection(this))
				{
					LP_Potential = 2147483000;
					LP_PotentialNoReq = 2147483000;
					LP_PotentialNoDist = 2147483000;
				}
			}
		}
	}

	public void UpdateDistanceFromPlayer(Client client)
	{
		this.client = client;
		if (client != null)
		{
			Player player = client.getLocalPlayer();
			if (questStep != null && player != null)
			{
				WorldPoint StepLocation = questStep.getWorldLocation();
				WorldPoint PlayerLocation = player.getWorldLocation();
				if (PlayerLocation != null && StepLocation != null)
				{
					DistanceFromPlayer = StepLocation.distanceTo2D(PlayerLocation);
				}
			}
		}
	}

	public ActionHelper(QuestHelper questHelper, QuestStep questStep, Client client, String actionDescription, int StepNumber)
	{
		this.questHelper = questHelper;
		this.questStep = questStep;
		this.actionDescription = actionDescription;
		this.client = client;
		this.QuestStepNumber = StepNumber;
		this.LeaguePointsFromAction = questStep.DirectLeaguePointsFromStep;

		UpdateDistanceFromPlayer(client);
		UpdateLeaguePointPotential();
	}

	public boolean clientMeetsRequirements()
	{
		if (getGeneralRequirements() == null)
		{
			return true;
		}

		return getGeneralRequirements().stream().filter(Objects::nonNull).allMatch(r ->
			!r.shouldConsiderForFilter() || r.check(client));
	}

	@Override
	public void renderDebugOverlay(Graphics graphics, QuestHelperPlugin plugin, PanelComponent panelComponent)
	{
		if (!plugin.isDeveloperMode()) return;
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Quest")
			.leftColor(ColorScheme.BRAND_ORANGE_TRANSPARENT)
			.right("Var")
			.rightColor(ColorScheme.BRAND_ORANGE_TRANSPARENT)
			.build()
		);
		/*panelComponent.getChildren().add(LineComponent.builder()
			.left(getQuest().getName())
			.leftColor(getConfig().debugColor())
			.right(getVar() + "")
			.rightColor(getConfig().debugColor())
			.build()
		);*/
	}

	public int getVar()
	{
		return 0;
		/*quest.getVar(client);*/
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return null;
	}

	public List<Requirement> getGeneralRequirements()
	{
		return null;
	}

	public List<ItemRequirement> getItemRecommended()
	{
		return null;
	}

	public List<Requirement> getGeneralRecommended()
	{
		return null;
	}

	public List<String> getCombatRequirements()
	{
		return null;
	}

	public QuestPointReward getQuestPointReward()
	{
		return null;
	}

	public List<ItemReward> getItemRewards()
	{
		return null;
	}

	public List<ExperienceReward> getExperienceRewards()
	{
		return null;
	}

	public List<UnlockReward> getUnlockRewards()
	{
		return null;
	}

	public List<String> getQuestRewards()
	{
		List<String> rewards = new ArrayList<>();

		QuestPointReward questPointReward = getQuestPointReward();
		if (questPointReward != null)
		{
			rewards.add(questPointReward.getDisplayText());
			rewards.add("</br>");
		}

		List<ItemReward> itemRewards = getItemRewards();
		if (itemRewards != null)
		{
			itemRewards.forEach((itemReward -> rewards.add(itemReward.getDisplayText())));
			rewards.add("</br>");
		}

		List<ExperienceReward> experienceReward = getExperienceRewards();
		if (experienceReward != null)
		{
			experienceReward.forEach((expReward -> rewards.add(expReward.getDisplayText())));
			rewards.add("</br>");
		}

		List<UnlockReward> unlockRewards = getUnlockRewards();
		if (unlockRewards != null)
		{
			unlockRewards.forEach((unlockReward -> rewards.add(unlockReward.getDisplayText())));
			rewards.add("</br>");
		}

		return rewards;
	}

	public List<ExternalQuestResources> getExternalResources(){ return null; }

	public double getLeaguePointPotential()
	{
		return LP_Potential;
	}

	public int sortLeaguePointPotential(ActionHelper p2)
	{
		// Add a million to avoid negative numbers
		return (int) (p2.getLeaguePointPotential() - getLeaguePointPotential());
	}

	public double getLeaguePointPotentialNoDistance()
	{
		return LP_PotentialNoDist;
	}

	public int sortLeaguePointPotentialNoDistance(ActionHelper p2)
	{
		// Add a million to avoid negative numbers
		return (int) (p2.getLeaguePointPotentialNoDistance() - getLeaguePointPotentialNoDistance());
	}

	public double getLeaguePointPotentialNoReq()
	{
		return LP_PotentialNoReq;
	}

	public int sortLeaguePointPotentialNoReq(ActionHelper p2)
	{
		// Add a million to avoid negative numbers
		return (int) (p2.getLeaguePointPotentialNoReq() - getLeaguePointPotentialNoReq());
	}

	public double getDistanceFromPlayer()
	{
		return DistanceFromPlayer;
	}

	public int sortOnlyDistance(ActionHelper p2)
	{
		// Add a million to avoid negative numbers
		return (int) ((getDistanceFromPlayer() - p2.getDistanceFromPlayer()));
	}

	public double getDirectLeaguePoints()
	{
		return LeaguePointsFromAction;
	}

	public int sortOnlyLeaguePoints(ActionHelper p2)
	{
		// Add a million to avoid negative numbers
		return (int) (p2.getDirectLeaguePoints() - getDirectLeaguePoints());
	}

}
