/*
 * Copyright (c) 2021, Obasill <https://github.com/Obasill>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, shatteredClass
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    shatteredClass list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * shatteredClass SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF shatteredClass
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.questhelper.steps.overlay.leaguestasks;

import com.questhelper.QuestHelperQuest;
import com.questhelper.questhelpers.ComplexStateQuestHelper;
import com.questhelper.requirements.player.CombatLevelRequirement;
import com.questhelper.requirements.player.SkillOther;
import com.questhelper.requirements.player.SkillRequirement;
import com.questhelper.requirements.quest.QuestRequirement;
import com.questhelper.steps.*;

import java.util.*;

import net.runelite.api.ItemID;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.QuestDescriptor;
import com.questhelper.panel.PanelDetails;

@QuestDescriptor(
		quest = QuestHelperQuest.SHATTERED_RELICS
)

public class ShatteredRelicsLeagueTasks extends ComplexStateQuestHelper
{
	// All leagues tasks with their requirements
	List<PanelDetails> LeaguesTasks = new ArrayList<>();
	PreviousLeagueTasks previousTaskHelper;
	ShatteredRelicsLeagueTasks shatteredClass = this;

	@Override
	public QuestStep loadStep()
	{
		return null;
	}

	public void setupRequirements()
	{
	}

	public void addLeagueTask(DetailedQuestStep leagueStep, Integer LeaguePoints)
	{
		// Append league points to task name
		String Description = leagueStep.getText().get(0) + " LP: " + LeaguePoints;
		leagueStep.setText(Description);
		PanelDetails newStep = new PanelDetails(Description,
				leagueStep,
				leagueStep.getRequirements());
		leagueStep.DirectLeaguePointsFromStep = LeaguePoints;

		LeaguesTasks.add(newStep);
	}

	public void setupShatteredRelicsSteps()
	{
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3419, 3538, 0),
						"Defeat a Gargoyle in Morytania",
						new SkillRequirement(Skill.SLAYER, 75, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3419, 3538, 0),
						"Defeat an Abyssal Demon in Morytania",
						new SkillRequirement(Skill.SLAYER, 85, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3419, 3538, 0),
						"Defeat the Grotesque Guardians",
						new SkillRequirement(Skill.SLAYER, 75, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3429, 3538, 0),
						"Defeat the Grotesque Guardians 100 Times",
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"1 Alchemical Hydra Kill",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Brimstone Ring",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Level 99 Slayer",
						new SkillRequirement(Skill.SLAYER, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain 25 Million Slayer XP",
						new SkillRequirement(Skill.SLAYER, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Slay an Abyssal Demon",
						new SkillRequirement(Skill.SLAYER, 85, true)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete 200 Slayer Tasks",
						new SkillRequirement(Skill.SLAYER, 75, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Defeat 50 Superior Slayer Creatures",
						new SkillRequirement(Skill.SLAYER, 75, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3199, 3169, 0),
						"Offer an Unsired to the Font of Consumption",
						new QuestRequirement(QuestHelperQuest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED),
						new SkillRequirement(Skill.SLAYER, 85, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3199, 3169, 0),
						"Defeat the Abyssal Sire 100 Times",
						new QuestRequirement(QuestHelperQuest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED),
						new SkillRequirement(Skill.SLAYER, 85, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3199, 3169, 0),
						"Defeat the Abyssal Sire 250 Times",
						new QuestRequirement(QuestHelperQuest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED),
						new SkillRequirement(Skill.SLAYER, 85, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3199, 3169, 0),
						"Defeat the Abyssal Sire 500 Times",
						new QuestRequirement(QuestHelperQuest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED),
						new SkillRequirement(Skill.SLAYER, 85, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2413, 3059, 0),
						"Defeat a Smoke Devil",
						new SkillRequirement(Skill.SLAYER, 93, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2413, 3059, 0),
						"Defeat the Thermonuclear Smoke Devil",
						new SkillRequirement(Skill.SLAYER, 93, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2886, 3401, 0),
						"Defeat Cerberus",
						new CombatLevelRequirement(110),
						new SkillRequirement(Skill.SLAYER, 91, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2886, 3401, 0),
						"Defeat Cerberus Before She Summons Souls",
						new CombatLevelRequirement(110),
						new SkillRequirement(Skill.SLAYER, 91, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3429, 3538, 0),
						"Defeat the Grotesque Guardians 250 Times",
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2600, 3309, 0),
						"Smelt a bronze bar",
						new ItemRequirement("Copper", ItemID.COPPER_ORE).quantity(1),
						new ItemRequirement("Tin", ItemID.TIN_ORE).quantity(1)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Smelt an Iron Bar",
						new ItemRequirement("Iron Ore", ItemID.IRON_ORE).quantity(1),
						new SkillRequirement(Skill.SMITHING, 15, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Smith 150 Iron Arrowtips",
						new ItemRequirement("Iron Bar", ItemID.IRON_BAR).quantity(1),
						new SkillRequirement(Skill.SMITHING, 20, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Smith 1000 Mithril Dart Tips",
						new QuestRequirement(QuestHelperQuest.THE_TOURIST_TRAP, QuestState.FINISHED),
						new SkillRequirement(Skill.SMITHING, 54, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Smith a Steel Platebody",
						new SkillRequirement(Skill.SMITHING, 48, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Smelt a Steel Bar",
						new SkillRequirement(Skill.SMITHING, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2724, 3715, 0),
						"Unlock Free Use of the Blast Furnace",
						new SkillRequirement(Skill.SMITHING, 60, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Smith 1000 Adamant Dart Tips",
						new QuestRequirement(QuestHelperQuest.THE_TOURIST_TRAP, QuestState.FINISHED),
						new SkillRequirement(Skill.SMITHING, 74, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Smelt a Runite Bar",
						new SkillRequirement(Skill.MINING, 85, false),
						new SkillRequirement(Skill.SMITHING, 85, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3237, 6065, 0),
						"Craft a Piece of Crystal Armour",
						new SkillRequirement(Skill.SMITHING, 70, false),
						new SkillRequirement(Skill.CRAFTING, 50, false),
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3237, 6065, 0),
						"Craft an Eternal Teleport Crystal",
						new SkillRequirement(Skill.SMITHING, 80, false),
						new SkillRequirement(Skill.CRAFTING, 80, false),
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Level 99 Smithing",
						new SkillRequirement(Skill.SMITHING, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain 25 Million Smithing XP",
						new SkillRequirement(Skill.SMITHING, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Smith a Dragonfire Shield",
						new SkillRequirement(Skill.SMITHING, 90, true)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Smith 1000 Rune Dart Tips",
						new QuestRequirement(QuestHelperQuest.THE_TOURIST_TRAP, QuestState.FINISHED),
						new SkillRequirement(Skill.SMITHING, 89, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2853, 3164, 0),
						"Equip a Tzhaar-Ket-Om",
						new SkillRequirement(Skill.STRENGTH, 60, false),
						new ItemRequirement("Obby maul", ItemID.TZHAARKETOM).quantity(1)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Level 99 Strength",
						new SkillRequirement(Skill.STRENGTH, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain 25 Million Strength XP",
						new SkillRequirement(Skill.STRENGTH, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2805, 3431, 0),
						"Pickpocket a Citizen"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2805, 3431, 0),
						"Open 28 Coin Pouches At Once"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2666, 3310, 0),
						"Steal a Chocolate Slice",
						new SkillRequirement(Skill.THIEVING, 5, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3270, 3415, 0),
						"Steal From the Varrock Tea Stall",
						new SkillRequirement(Skill.THIEVING, 5, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1756, 3596, 0),
						"Steal a Golovanova Fruit Top",
						new SkillRequirement(Skill.THIEVING, 25, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1794, 3750, 0),
						"Steal 1 Artefact",
						new SkillRequirement(Skill.THIEVING, 49, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1794, 3750, 0),
						"Steal 10 Artefacts",
						new SkillRequirement(Skill.THIEVING, 49, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3166, 3251, 0),
						"Pickpocket a H.A.M. Member",
						new SkillRequirement(Skill.THIEVING, 15, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3288, 2802, 0),
						"Complete Room 1 of Pyramid Plunder",
						new SkillRequirement(Skill.THIEVING, 21, false),
						new QuestRequirement(QuestHelperQuest.GERTRUDES_CAT, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3288, 2802, 0),
						"Complete Room 2 of Pyramid Plunder",
						new SkillRequirement(Skill.THIEVING, 31, false),
						new QuestRequirement(QuestHelperQuest.GERTRUDES_CAT, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3320, 3143, 0),
						"Pick a Winter Sq'irk",
						new QuestRequirement(QuestHelperQuest.PRINCE_ALI_RESCUE, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3290, 3181, 0),
						"Turn in a Winter Sq'irkjuice to Osman",
						new QuestRequirement(QuestHelperQuest.PRINCE_ALI_RESCUE, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1758, 3597, 0),
						"Pickpocket a Master Farmer",
						new SkillRequirement(Skill.THIEVING, 38, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2635, 3340, 0),
						"Pickpocket a Guard",
						new SkillRequirement(Skill.THIEVING, 40, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2635, 3340, 0),
						"Obtain 800 Coins From Coin Pouches At Once",
						new SkillRequirement(Skill.THIEVING, 40, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2636, 3360, 0),
						"Pickpocket a Ranarr Seed",
						new SkillRequirement(Skill.THIEVING, 38, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3176, 3429, 0),
						"Pickpocket a Varrock Guard",
						new SkillRequirement(Skill.THIEVING, 40, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3318, 9115, 0),
						"Pickpocket a Bullseye Lantern From a Cave Goblin",
						new QuestRequirement(QuestHelperQuest.DEATH_TO_THE_DORGESHUUN, QuestState.FINISHED),
						new SkillRequirement(Skill.THIEVING, 36, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2651, 3307, 0),
						"Pickpocket a Knight of Ardougne 50 Times",
						new SkillRequirement(Skill.THIEVING, 55, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3288, 2802, 0),
						"Complete Room 3 of Pyramid Plunder",
						new SkillRequirement(Skill.THIEVING, 41, false),
						new QuestRequirement(QuestHelperQuest.GERTRUDES_CAT, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3288, 2802, 0),
						"Complete Room 4 of Pyramid Plunder",
						new SkillRequirement(Skill.THIEVING, 51, false),
						new QuestRequirement(QuestHelperQuest.GERTRUDES_CAT, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3288, 2802, 0),
						"Complete Room 5 of Pyramid Plunder",
						new SkillRequirement(Skill.THIEVING, 61, false),
						new QuestRequirement(QuestHelperQuest.GERTRUDES_CAT, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3320, 3143, 0),
						"Pick a Spring Sq'irk",
						new QuestRequirement(QuestHelperQuest.PRINCE_ALI_RESCUE, QuestState.FINISHED),
						new SkillRequirement(Skill.THIEVING, 25, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3290, 3181, 0),
						"Turn in 10 Spring Sq'irkjuices to Osman",
						new QuestRequirement(QuestHelperQuest.PRINCE_ALI_RESCUE, QuestState.FINISHED),
						new SkillRequirement(Skill.THIEVING, 25, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3172, 2980, 0),
						"Pickpocket a Bandit in the Bandit Camp",
						new SkillRequirement(Skill.THIEVING, 53, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2665, 3301, 0),
						"Steal From a Gem Stall",
						new SkillRequirement(Skill.THIEVING, 75, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2718, 5323, 0),
						"Steal a Diamond in Dorgesh-Kaan",
						new QuestRequirement(QuestHelperQuest.DEATH_TO_THE_DORGESHUUN, QuestState.FINISHED),
						new SkillRequirement(Skill.THIEVING, 78, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2345, 3163, 0),
						"Pickpocket an Elf 50 Times",
						new SkillRequirement(Skill.THIEVING, 85, false),
						new QuestRequirement(QuestHelperQuest.UNDERGROUND_PASS, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2647, 3306, 0),
						"Pickpocket a Hero",
						new SkillRequirement(Skill.THIEVING, 80, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2911, 3538, 0),
						"Equip a Full Rogue Outfit",
						new SkillRequirement(Skill.AGILITY, 50, false),
						new SkillRequirement(Skill.THIEVING, 50, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3288, 2802, 0),
						"Complete Room 6 of Pyramid Plunder",
						new SkillRequirement(Skill.THIEVING, 71, false),
						new QuestRequirement(QuestHelperQuest.GERTRUDES_CAT, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3288, 2802, 0),
						"Complete Room 7 of Pyramid Plunder",
						new SkillRequirement(Skill.THIEVING, 81, false),
						new QuestRequirement(QuestHelperQuest.GERTRUDES_CAT, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3320, 3143, 0),
						"Pick a Summer Sq'irk",
						new QuestRequirement(QuestHelperQuest.PRINCE_ALI_RESCUE, QuestState.FINISHED),
						new SkillRequirement(Skill.THIEVING, 65, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3290, 3181, 0),
						"Turn in 25 Autumn Sq'irkjuices to Osman",
						new QuestRequirement(QuestHelperQuest.PRINCE_ALI_RESCUE, QuestState.FINISHED),
						new SkillRequirement(Skill.THIEVING, 45, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3358, 2971, 0),
						"Pickpocket a Menaphite Thug 50 Times",
						new QuestRequirement(QuestHelperQuest.THE_FEUD, QuestState.FINISHED),
						new SkillRequirement(Skill.THIEVING, 65, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3596, 3362, 0),
						"Pickpocket a Vyre 50 Times",new SkillRequirement(Skill.THIEVING, 82, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Chop Some Logs",
						new ItemRequirement("Bronze axe", ItemID.BRONZE_AXE).quantity(1)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2807, 3460, 0),
						"Chop Some Logs With a Steel Axe",
						new SkillRequirement(Skill.WOODCUTTING, 6, false),
						new ItemRequirement("Steel Axe", ItemID.STEEL_AXE).quantity(1)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain a Bird Nest",
						new SkillRequirement(Skill.WOODCUTTING, 2, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1659, 3505, 0),
						"Enter the Woodcutting Guild",
						new SkillRequirement(Skill.WOODCUTTING, 60, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Chop 100 Willow Logs",
						new SkillRequirement(Skill.WOODCUTTING, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Chop Some Logs With a Rune Axe",
						new ItemRequirement("Rune Axe", ItemID.RUNE_AXE).quantity(1),
						new SkillRequirement(Skill.WOODCUTTING, 41, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Build a Waka Canoe",
						new SkillRequirement(Skill.WOODCUTTING, 57, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3668, 3815, 0),
						"Chop a Sulliuscep Cap",
						new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
						new SkillRequirement(Skill.WOODCUTTING, 65, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1382, 3811, 0),
						"Chop a Magic Log at the Forsaken Tower",
						new SkillRequirement(Skill.WOODCUTTING, 75, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2434, 3411, 0),
						"Chop 75 Magic Logs",
						new SkillRequirement(Skill.WOODCUTTING, 75, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Level 99 Woodcutting",
						new SkillRequirement(Skill.WOODCUTTING, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain 25 Million Woodcutting XP",
						new SkillRequirement(Skill.WOODCUTTING, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2625, 3390, 0),
						"Defeat a Goblin"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2404, 3366, 0),
						"Defeat a Moss Giant"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2635, 3341, 0),
						"Defeat a Guard"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3111, 3168, 0),
						"Defeat the Lesser Demon in the Wizards' Tower"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2697, 3724, 0),
						"Defeat a Rock Crab in the Fremennik Province"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2728, 3714, 0),
						"Defeat a Troll in the Fremennik Province"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2855, 3165, 0),
						"Defeat a TzHaar"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2855, 3165, 0),
						"Defeat a Greater Demon on Karamja"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2515, 3207, 0),
						"Defeat a Tortoise With Riders in Kandarin",
						new CombatLevelRequirement(30)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2869, 3598, 0),
						"Defeat a Troll in Asgarnia",
						new CombatLevelRequirement(50)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2887, 3397, 0),
						"Defeat a Blue Dragon in Asgarnia",
						new CombatLevelRequirement(60)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2887, 3397, 0),
						"Defeat a Black Demon in Asgarnia",
						new CombatLevelRequirement(60)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3494, 3485, 0),
						"Defeat a Werewolf in Morytania",
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3574, 3527, 0),
						"Defeat One of Fenkenstrain's Experiments",
						new QuestRequirement(QuestHelperQuest.CREATURE_OF_FENKENSTRAIN, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3432, 3448, 0),
						"Defeat a Ghast",
						new QuestRequirement(QuestHelperQuest.NATURE_SPIRIT, QuestState.FINISHED),
						new QuestRequirement(QuestHelperQuest.CREATURE_OF_FENKENSTRAIN, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3202, 3858, 0),
						"Defeat a Lava Dragon in the Wilderness"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3047, 3935, 0),
						"Defeat a Fire Giant in the Wilderness"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3047, 3935, 0),
						"Defeat a Chaos Dwarf in the Wilderness"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2981, 3613, 0),
						"Defeat a Green Dragon in the Wilderness"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2981, 3613, 0),
						"Defeat an Adult Chromatic Dragon"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3111, 3170, 0),
						"Defeat a Lesser Demon"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1509, 3566, 0),
						"100 Lizardmen Shaman Kills"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1509, 3566, 0),
						"500 Lizardmen Shaman Kills"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1509, 3566, 0),
						"1000 Lizardmen Shaman Kills"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3117, 9848, 0),
						"Defeat Obor",
						new CombatLevelRequirement(75),
						new ItemRequirement("Giant Key", ItemID.GIANT_KEY).quantity(1)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3173, 9897, 0),
						"Defeat Bryophyta",
						new CombatLevelRequirement(50),
						new ItemRequirement("Mossy Key", ItemID.MOSSY_KEY).quantity(1)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2338, 3171, 0),
						"Defeat an Elf in Tirannwn",
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2621, 3686, 0),
						"Defeat a Dagannoth in the Fremennik Province",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2745, 3153, 0),
						"Defeat a Steel Dragon on Karamja",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2512, 3512, 0),
						"Defeat a Mithril Dragon",
						new CombatLevelRequirement(70),
						new SkillRequirement(Skill.FIREMAKING, 35, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2532, 3571, 0),
						"Defeat the Penance Queen",
						new CombatLevelRequirement(70)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3000, 3376, 0),
						"Defeat the Giant Mole",
						new CombatLevelRequirement(60)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2884, 3402, 0),
						"Defeat 30 Black Dragons in Asgarnia",
						new CombatLevelRequirement(70)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2878, 3546, 0),
						"Defeat Some Animated Rune Armour",
						new SkillRequirement(Skill.ATTACK, 65, false),
						new SkillRequirement(Skill.STRENGTH, 65, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3312, 2800, 0),
						"Defeat a Scarab Mage",
						new QuestRequirement(QuestHelperQuest.ICTHLARINS_LITTLE_HELPER, QuestState.FINISHED),
						new SkillRequirement(Skill.MINING, 45, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3228, 3108, 0),
						"Defeat a Kalphite Guardian"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3487, 3286, 0),
						"Defeat a Fiyr Shade",
						new SkillRequirement(Skill.FIREMAKING, 65, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3600, 3362, 0),
						"Defeat a Vyrewatch Sentinel",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2971, 3707, 0),
						"Defeat the Crazy Archaeologist",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 3949, 0),
						"Defeat Scorpia",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2976, 3849, 0),
						"Defeat the Chaos Fanatic",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3248, 3921, 0),
						"Defeat the Chaos Elemental",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3301, 2909, 0),
						"Defeat a Crocodile"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"1 Sarachnis Kill"),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"1 Skotizo Kill"),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"1 Chambers of Xeric",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"1 Mimic Kill"),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3561, 4004, 0),
						"Defeat a Rune Dragon",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3199, 3169, 0),
						"Defeat the Abyssal Sire",
						new QuestRequirement(QuestHelperQuest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED),
						new SkillRequirement(Skill.SLAYER, 85, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3228, 6046, 0),
						"Defeat a Waterfiend in Tirannwn",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3228, 6046, 0),
						"Defeat a Moss Giant in Tirannwn",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Complete the Gauntlet",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3284, 6060, 0),
						"Defeat Zalcano",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2208, 3057, 0),
						"Defeat Zulrah",
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3284, 6060, 0),
						"Defeat Zulrah in 1:30",
						new CombatLevelRequirement(120),
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Complete the Gauntlet in 8:00",
						new CombatLevelRequirement(120),
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Defeat Vorkath",
						new CombatLevelRequirement(90),
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Defeat Vorkath in 2:00",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Defeat the Dagannoth Kings Without Leaving",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2435, 3519, 0),
						"Defeat a Demonic Gorilla",
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat K'ril Tsutsaroth",
						new CombatLevelRequirement(80),
						new SkillRequirement(Skill.HITPOINTS, 70, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat General Graardor",
						new CombatLevelRequirement(80),
						new SkillRequirement(Skill.STRENGTH, 70, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Kree'arra",
						new CombatLevelRequirement(80),
						new SkillRequirement(Skill.RANGED, 70, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Commander Zilyana",
						new CombatLevelRequirement(80),
						new SkillRequirement(Skill.AGILITY, 70, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3243, 3742, 0),
						"Defeat Venenatis",
						new CombatLevelRequirement(80)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3286, 3849, 0),
						"Defeat Callisto",
						new CombatLevelRequirement(80)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3218, 3794, 0),
						"Defeat Vet'ion",
						new CombatLevelRequirement(80)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3012, 3849, 0),
						"Defeat the King Black Dragon",
						new CombatLevelRequirement(80)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2208, 3057, 0),
						"Defeat Zulrah in 0:54",
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Complete the Gauntlet in 5:00",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Complete the Corrupted Gauntlet in 8:30",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Complete the Corrupted Gauntlet in 7:00",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Complete the Corrupted Gauntlet 100 Times",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Complete the Corrupted Gauntlet 250 Times",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3284, 6060, 0),
						"Defeat Zalcano 250 Times",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3284, 6060, 0),
						"Defeat Zalcano 500 Times",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3284, 6060, 0),
						"Defeat Zulrah 250 Times",
						new CombatLevelRequirement(120),
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3284, 6060, 0),
						"Defeat Zulrah 500 Times",
						new CombatLevelRequirement(120),
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Defeat Vorkath in 1:00",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Defeat Vorkath 5 Times Without Special Damage",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Defeat Vorkath 15 Times Without Leaving",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Defeat Vorkath 250 Times",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Defeat Vorkath 500 Times",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Defeat Vorkath 750 Times",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Defeat Each Dagannoth King 300 Times",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Defeat Each Dagannoth King 650 Times",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Defeat Each Dagannoth King 1000 Times",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Complete the Fight Caves in 35:00",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Complete the Fight Caves 5 Times",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Complete the Fight Caves 15 Times",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Complete the Fight Caves 30 Times",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Complete the Inferno 5 Times",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Complete the Inferno 10 Times",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Complete the Inferno 20 Times",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2282, 3612, 0),
						"Defeat the Kraken Boss 250 Times",
						new SkillRequirement(Skill.SLAYER, 87, false),
						new SkillRequirement(Skill.MAGIC, 50, false),
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2282, 3612, 0),
						"Defeat the Kraken Boss 500 Times",
						new SkillRequirement(Skill.SLAYER, 87, false),
						new SkillRequirement(Skill.MAGIC, 50, false),
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2282, 3612, 0),
						"Defeat the Kraken Boss 750 Times",
						new SkillRequirement(Skill.SLAYER, 87, false),
						new SkillRequirement(Skill.MAGIC, 50, false),
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2435, 3519, 0),
						"Defeat 300 Demonic Gorillas",
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2435, 3519, 0),
						"Defeat 750 Demonic Gorillas",
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2435, 3519, 0),
						"Defeat 1500 Demonic Gorillas",
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Any God Wars Dungeon Boss 100 Times",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Any God Wars Dungeon Boss 250 Times",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Any God Wars Dungeon Boss 500 Times",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3000, 3376, 0),
						"Defeat the Giant Mole 250 Times",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3000, 3376, 0),
						"Defeat the Giant Mole 500 Times",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3000, 3376, 0),
						"Defeat the Giant Mole 750 Times",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3230, 3108, 0),
						"Defeat the Kalphite Queen",
						new CombatLevelRequirement(80)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3728, 3306, 0),
						"Defeat the Kalphite Queen 100 Times",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3728, 3306, 0),
						"Defeat the Kalphite Queen 250 Times",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3728, 3306, 0),
						"Defeat the Kalphite Queen 500 Times",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare",
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Complete the Theatre of Blood in 20:00",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare in 3:00",
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Complete the Theatre of Blood 100 Times",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Complete the Theatre of Blood 200 Times",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Complete the Theatre of Blood 350 Times",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Complete the Theatre of Blood 500 Times",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3202, 3679, 0),
						"Defeat the Corporeal Beast",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3202, 3679, 0),
						"Defeat the Corporeal Beast 100 Times",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3202, 3679, 0),
						"Defeat the Corporeal Beast 250 Times",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3202, 3679, 0),
						"Defeat the Corporeal Beast 500 Times",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2208, 3057, 0),
						"Defeat Zulrah in 0:42",
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Complete the Corrupted Gauntlet in 5:00",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Defeat Vorkath in 0:45",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Complete the Fight Caves in 25:00",
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Complete the Inferno in 75:00",
						new CombatLevelRequirement(126)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Complete the Theatre of Blood in 16:00",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Rune Mysteries",
						new QuestRequirement(QuestHelperQuest.RUNE_MYSTERIES, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Sheep Shearer",
						new QuestRequirement(QuestHelperQuest.SHEEP_SHEARER, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Romeo & Juliet",
						new QuestRequirement(QuestHelperQuest.ROMEO__JULIET, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Gertrude's Cat",
						new QuestRequirement(QuestHelperQuest.GERTRUDES_CAT, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3256, 3447, 0),
						"Complete the Natural History Quiz"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Monk's Friend",
						new QuestRequirement(QuestHelperQuest.MONKS_FRIEND, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Vampyre Slayer",
						new QuestRequirement(QuestHelperQuest.VAMPYRE_SLAYER, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Tower of Life",
						new QuestRequirement(QuestHelperQuest.TOWER_OF_LIFE, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Sea Slug",
						new QuestRequirement(QuestHelperQuest.SEA_SLUG, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete The Golem",
						new QuestRequirement(QuestHelperQuest.THE_GOLEM, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete The Lost Tribe",
						new QuestRequirement(QuestHelperQuest.THE_LOST_TRIBE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Death to the Dorgeshuun",
						new QuestRequirement(QuestHelperQuest.DEATH_TO_THE_DORGESHUUN, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete a Soul's Bane",
						new QuestRequirement(QuestHelperQuest.A_SOULS_BANE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Throne of Miscellania",
						new QuestRequirement(QuestHelperQuest.THRONE_OF_MISCELLANIA, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Royal Trouble",
						new QuestRequirement(QuestHelperQuest.ROYAL_TROUBLE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Olaf's Quest",
						new QuestRequirement(QuestHelperQuest.OLAFS_QUEST, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Elemental Workshop II",
						new QuestRequirement(QuestHelperQuest.ELEMENTAL_WORKSHOP_II, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Observatory Quest",
						new QuestRequirement(QuestHelperQuest.OBSERVATORY_QUEST, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete A Porcine of Interest",
						new QuestRequirement(QuestHelperQuest.A_PORCINE_OF_INTEREST, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Spirits of the Elid",
						new QuestRequirement(QuestHelperQuest.SPIRITS_OF_THE_ELID, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Shadow of the Storm",
						new QuestRequirement(QuestHelperQuest.SHADOW_OF_THE_STORM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Haunted Mine",
						new QuestRequirement(QuestHelperQuest.HAUNTED_MINE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete A Taste of Hope",
						new QuestRequirement(QuestHelperQuest.A_TASTE_OF_HOPE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Sins of the Father",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Enakhra's Lament",
						new QuestRequirement(QuestHelperQuest.ENAKHRAS_LAMENT, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Trimmed Amulet",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 3 Elite Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 3 Hard Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 5 Medium Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 5 Easy Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 5 Beginner Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 5 Unique Items From Hard Clues",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 10 Unique Items From Medium Clues",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 10 Unique Items From Easy Clues",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 10 Unique Items From Beginner Clues",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain a Unique Item From a Hard Clue",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain a Unique Item From a Medium Clue",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete a Hard Clue Scroll",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete a Medium Clue Scroll",
						new CombatLevelRequirement(126)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Full Gilded or Trimmed Wizard Set",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Full Vestment Set",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 5 Master Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 10 Elite Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 15 Hard Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 20 Medium Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 20 Easy Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 10 Beginner Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 10 Unique Items From Master Clues",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 10 Unique Items From Elite Clues",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 20 Unique Items From Hard Clues",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 25 Unique Items From Medium Clues",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 35 Unique Items From Easy Clues",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 35 Unique Items From Beginner Clues",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain a Unique Item From a Master Clue",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain a Unique Item From an Elite Clue",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete a Master Clue Scroll",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete an Elite Clue Scroll",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 25 Elite Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 25 Master Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Use the Explore Emote",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Read a Clueless Scroll",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Heavy Casket",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Scroll Sack",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Transform into Uri",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 30 Hard Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 40 Medium Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill 50 Easy Clue Collection Log Slots",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill Every Beginner Clue Collection Log Slot",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 25 Unique Items From Master Clues",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 25 Unique Items From Elite Clues",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain 50 Unique Items From Hard Clues",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3150, 3631, 0),
						"Visit [[Ferox Enclave]]"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1629, 3801, 0),
						"Turn in 1 Library Book"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1629, 3801, 0),
						"Turn in 10 Library Books"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1504, 3417, 0),
						"Bank at Land's End"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1250, 3568, 0),
						"Bank at Mount Quidamortem"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1360, 3631, 0),
						"Travel to Molch Island"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Open the Leagues Menu"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Leagues Tutorial"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level Up",
						new SkillRequirement(SkillOther.ANY_SKILLS, 2, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 5",
						new SkillRequirement(SkillOther.ANY_SKILLS, 5, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 10",
						new SkillRequirement(SkillOther.ANY_SKILLS, 10, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 20",
						new SkillRequirement(SkillOther.ANY_SKILLS, 20, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Combat Level 10",
						new CombatLevelRequirement(10)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3181, 3430, 0),
						"Pet a Stray Dog in Varrock"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3109, 3348, 0),
						"Enter Draynor Manor"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2938, 3153, 0),
						"Fill a Crate With Bananas"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2519, 3168, 0),
						"Visit the Tree Gnome Village"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2462, 3382, 0),
						"Visit the Tree Gnome Stronghold"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3267, 3228, 0),
						"Go through the Al Kharid Gate"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3428, 2893, 0),
						"Use the Bank in Nardah"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3292, 3092, 0),
						"Cut a Cactus in the Kharidian Desert"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3228, 3108, 0),
						"Enter the Kalphite Lair"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3151, 3643, 0),
						"Order a Drink at the Old Nite"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2820, 3469, 0),
						"Pick Wheat in Catherby"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2764, 3444, 0),
						"Get Stung By Bees"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2581, 3483, 0),
						"Drink a poison chalice"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Open 1 Grubby Chest",
						new SkillRequirement(Skill.THIEVING, 57, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1629, 3801, 0),
						"Turn in 25 Library Books"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1629, 3801, 0),
						"Turn in 50 Library Books"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1629, 3801, 0),
						"Turn in 100 Library Books"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"Unlock All Catacombs Entrances"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 100",
						new SkillRequirement(Skill.OVERALL, 100, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 500",
						new SkillRequirement(Skill.OVERALL, 500, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Combat Level 25",
						new CombatLevelRequirement(25)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2708, 3462, 0),
						"Visit Death's Domain"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Lumbridge & Draynor Diary",
						new QuestRequirement(QuestHelperQuest.LUMBRIDGE_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3200, 3168, 0),
						"Enter Zanaris",
						new QuestRequirement(QuestHelperQuest.LOST_CITY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3211, 3213, 0),
						"Drink From the Tears of Guthix",
						new QuestRequirement(QuestHelperQuest.TEARS_OF_GUTHIX, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3079, 3423, 0),
						"Equip Some Fancy Boots or Fighting Boots"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3711, 3807, 0),
						"Fully Unlock the Mycelium Transportation System",
						new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3741, 3805, 0),
						"Build a Bank on Fossil Island",
						new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
						new SkillRequirement(Skill.CONSTRUCTION, 21, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Fremennik Diary",
						new QuestRequirement(QuestHelperQuest.FREMENNIK_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Karamja Diary",
						new QuestRequirement(QuestHelperQuest.KARAMJA_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2765, 3149, 0),
						"Pick a Pineapple on Karamja"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2746, 3151, 0),
						"Enter the Brimhaven Dungeon"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2679, 3325, 0),
						"Brimstail Rune Essence Mine teleport",
						new QuestRequirement(QuestHelperQuest.RUNE_MYSTERIES, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2627, 2989, 0),
						"Equip a Marksman Chompy Hat",
						new QuestRequirement(QuestHelperQuest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Kandarin Diary",
						new QuestRequirement(QuestHelperQuest.KANDARIN_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Falador Diary",
						new QuestRequirement(QuestHelperQuest.FALADOR_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2887, 3397, 0),
						"Unlock a Gate in Taverley Dungeon"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2658, 2658, 0),
						"Complete a Game of Novice Pest Control",
						new CombatLevelRequirement(40)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Desert Diary",
						new QuestRequirement(QuestHelperQuest.DESERT_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3276, 3192, 0),
						"Tan a Cow Hide in the Kharidian Desert"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Morytania Diary",
						new QuestRequirement(QuestHelperQuest.MORYTANIA_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3434, 3486, 0),
						"Complete an Easy Temple Trek",
						new QuestRequirement(QuestHelperQuest.IN_AID_OF_THE_MYREQUE, QuestState.FINISHED),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3660, 3509, 0),
						"Visit Port Phasmatys",
						new QuestRequirement(QuestHelperQuest.IN_AID_OF_THE_MYREQUE, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain a Rune Crossbow From a Lucky Impling",
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED),
						new SkillRequirement(Skill.HUNTER, 99, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3679, 2965, 0),
						"Visit Harmony Island",
						new QuestRequirement(QuestHelperQuest.CABIN_FEVER, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3703, 3497, 0),
						"Visit Mos Le'Harmless",
						new QuestRequirement(QuestHelperQuest.CABIN_FEVER, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Wilderness Diary",
						new QuestRequirement(QuestHelperQuest.WILDERNESS_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3092, 3476, 0),
						"Use a Lever to Teleport to Edgeville"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3240, 3611, 0),
						"Pray at the Southern Chaos Temple"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2949, 3821, 0),
						"Pray at the Western Chaos Temple"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3184, 3946, 0),
						"Enter the Wilderness Resource Area"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3011, 3739, 0),
						"Enter the Wilderness God Wars Dungeon"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3091, 3957, 0),
						"Use the Bank at the Mage Arena"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3346, 2945, 0),
						"Take a Carpet Ride from Pollnivneach to Sophanem"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Varrock Diary",
						new QuestRequirement(QuestHelperQuest.VARROCK_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Ardougne Diary",
						new QuestRequirement(QuestHelperQuest.ARDOUGNE_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1629, 3801, 0),
						"Turn in 250 Library Books"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1577, 3530, 0),
						"Equip Xeric's Talisman"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Obtain the Temple Key"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Purchase Gricoller's Can",
						new SkillRequirement(Skill.FARMING, 34, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Purchase a Seed Box",
						new SkillRequirement(Skill.FARMING, 34, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1360, 3631, 0),
						"Equip a Pearl Barbarian Rod"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 30",
						new SkillRequirement(SkillOther.ANY_SKILLS, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 40",
						new SkillRequirement(SkillOther.ANY_SKILLS, 40, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 50",
						new SkillRequirement(SkillOther.ANY_SKILLS, 50, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 750",
						new SkillRequirement(Skill.OVERALL, 750, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 1000",
						new SkillRequirement(Skill.OVERALL, 1000, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 1250",
						new SkillRequirement(Skill.OVERALL, 1250, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 5",
						new SkillRequirement(SkillOther.ALL_SKILLS, 5, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 10",
						new SkillRequirement(SkillOther.ALL_SKILLS, 10, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 20",
						new SkillRequirement(SkillOther.ALL_SKILLS, 20, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 30",
						new SkillRequirement(SkillOther.ALL_SKILLS, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 40",
						new SkillRequirement(SkillOther.ALL_SKILLS, 40, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 50",
						new SkillRequirement(SkillOther.ALL_SKILLS, 50, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Combat Level 50",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Combat Level 75",
						new CombatLevelRequirement(75)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Perform a Special Attack",
						new CombatLevelRequirement(60)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3320, 9607, 0),
						"Equip a Dorgeshuun Crossbow",
						new QuestRequirement(QuestHelperQuest.THE_LOST_TRIBE, QuestState.FINISHED),
						new SkillRequirement(Skill.RANGED, 28, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Lumbridge & Draynor Diary",
						new QuestRequirement(QuestHelperQuest.LUMBRIDGE_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3218, 9622, 0),
						"Equip Some Mithril Gloves",
						new QuestRequirement(QuestHelperQuest.RECIPE_FOR_DISASTER_LUMBRIDGE_GUIDE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3360, 3444, 0),
						"Travel to Fossil Island",
						new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Use a Fairy Ring",
						new QuestRequirement(QuestHelperQuest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3763, 3868, 0),
						"Use a Digsite Pendant to Teleport to Fossil Island",
						new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED),
						new SkillRequirement(Skill.CRAFTING, 40, false),
						new SkillRequirement(Skill.MAGIC, 49, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2343, 3166, 0),
						"Use the Bank in Lletya",
						new QuestRequirement(QuestHelperQuest.ROVING_ELVES, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2339, 3172, 0),
						"Use an Elven Teleport Crystal",
						new QuestRequirement(QuestHelperQuest.ROVING_ELVES, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2291, 3151, 0),
						"Talk to Ilfeen in Tirannwn",
						new SkillRequirement(Skill.FARMING, 57, false),
						new QuestRequirement(QuestHelperQuest.UNDERGROUND_PASS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Granite Shield",
						new ItemRequirement("Granite Shield", ItemID.GRANITE_SHIELD).quantity(1),
						new QuestRequirement(QuestHelperQuest.THE_FREMENNIK_TRIALS, QuestState.FINISHED),
						new SkillRequirement(Skill.STRENGTH, 50, false),
						new SkillRequirement(Skill.DEFENCE, 50, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Helm of Neitiznot",
						new QuestRequirement(QuestHelperQuest.THE_FREMENNIK_ISLES, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2792, 3616, 0),
						"Equip a Leaf-Bladed Sword",
						new ItemRequirement("Leaf-bladed Sword", ItemID.LEAFBLADED_SWORD).quantity(1),
						new SkillRequirement(Skill.ATTACK, 50, false),
						new SkillRequirement(Skill.SLAYER, 55, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Fremennik Diary",
						new QuestRequirement(QuestHelperQuest.FREMENNIK_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2633, 3671, 0),
						"Deposit an Item Using Peer the Seer",
						new QuestRequirement(QuestHelperQuest.THE_FREMENNIK_TRIALS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2642, 3710, 0),
						"Use the Bank on Jatizso",
						new QuestRequirement(QuestHelperQuest.THE_FREMENNIK_TRIALS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2642, 3710, 0),
						"Use the Bank on Neitiznot",
						new QuestRequirement(QuestHelperQuest.THE_FREMENNIK_TRIALS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2099, 3917, 0),
						"Use the Bank on Lunar Isle",
						new QuestRequirement(QuestHelperQuest.THE_FREMENNIK_TRIALS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Karamja Diary",
						new QuestRequirement(QuestHelperQuest.KARAMJA_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2815, 3082, 0),
						"Enter the Tai Bwo Wannai Hardwood Grove",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2815, 3082, 0),
						"Equip a Matching Tribal Mask and Broodoo Shield",
						new CombatLevelRequirement(50),
						new SkillRequirement(Skill.DEFENCE, 25, false),
						new SkillRequirement(Skill.CRAFTING, 35, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2815, 3082, 0),
						"Equip a Full Tai Bwo Wannai Villager Set",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Dragon Scimitar",
						new SkillRequirement(Skill.ATTACK, 60, false),
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_I, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3013, 3451, 0),
						"Set Up a Dwarf Cannon",
						new QuestRequirement(QuestHelperQuest.DWARF_CANNON, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2656, 3440, 0),
						"Enter the Ranging Guild",
						new SkillRequirement(Skill.RANGED, 40, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2598, 3088, 0),
						"Enter the Wizards' Guild",
						new SkillRequirement(Skill.MAGIC, 66, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Use the Chivalry Prayer",
						new SkillRequirement(Skill.PRAYER, 60, false),
						new SkillRequirement(Skill.DEFENCE, 65, false),
						new QuestRequirement(QuestHelperQuest.KNIGHT_WAVES_TRAINING_GROUNDS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2513, 3308, 0),
						"Equip an Iban's Staff (u)",
						new SkillRequirement(Skill.ATTACK, 50, false),
						new SkillRequirement(Skill.MAGIC, 50, false),
						new QuestRequirement(QuestHelperQuest.UNDERGROUND_PASS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2440, 3088, 0),
						"Win a Game of Castle Wars"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2627, 2989, 0),
						"Equip an Ogre Forester Chompy Hat",
						new ItemRequirement("lots of chomps", ItemID.CHOMPY_BIRD_HAT).quantity(10),
						new QuestRequirement(QuestHelperQuest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Kandarin Diary",
						new QuestRequirement(QuestHelperQuest.KANDARIN_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Western Provinces Diary",
						new QuestRequirement(QuestHelperQuest.WESTERN_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3010, 3157, 0),
						"Equip Some Granite Legs",
						new CombatLevelRequirement(90),
						new SkillRequirement(Skill.STRENGTH, 50, false),
						new SkillRequirement(Skill.DEFENCE, 50, false),
						new SkillRequirement(Skill.SLAYER, 72, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2898, 3511, 0),
						"Charge an Amulet of Glory in the Heroes' Guild",
						new QuestRequirement(QuestHelperQuest.HEROES_QUEST, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Falador Diary",
						new QuestRequirement(QuestHelperQuest.FALADOR_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2878, 3546, 0),
						"Enter the Warriors' Guild",
						new SkillRequirement(Skill.ATTACK, 65, false),
						new SkillRequirement(Skill.STRENGTH, 65, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2658, 2658, 0),
						"Complete a Game of Intermediate Pest Control",
						new CombatLevelRequirement(70)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2878, 3546, 0),
						"Open the Crystal Chest",
						new ItemRequirement("crystal key", ItemID.CRYSTAL_KEY).quantity(1),
						new CombatLevelRequirement(40)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Desert Diary",
						new QuestRequirement(QuestHelperQuest.DESERT_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3362, 3296, 0),
						"Cast Bones to Peaches",
						new SkillRequirement(Skill.MAGIC, 60, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Pray at the Elidinis Statuette",
						new QuestRequirement(QuestHelperQuest.SPIRITS_OF_THE_ELID, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3283, 2812, 0),
						"Enter Sophanem",
						new QuestRequirement(QuestHelperQuest.GERTRUDES_CAT, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3565, 3293, 0),
						"Equip a Piece of any Barrows Armour Set",
						new SkillRequirement(Skill.DEFENCE, 70, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3565, 3293, 0),
						"Loot a Barrows Chest",
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Morytania Diary",
						new QuestRequirement(QuestHelperQuest.MORYTANIA_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3435, 3485, 0),
						"Complete a Medium Temple Trek",
						new QuestRequirement(QuestHelperQuest.IN_AID_OF_THE_MYREQUE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3487, 3284, 0),
						"Achieve 100% Shades of Mort'Ton Sanctity",
						new QuestRequirement(QuestHelperQuest.SHADES_OF_MORTTON, QuestState.FINISHED),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3439, 3233, 0),
						"Equip a Salve Amulet (e)",
						new QuestRequirement(QuestHelperQuest.HAUNTED_MINE, QuestState.FINISHED),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3248, 3921, 0),
						"Equip a Fedora",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3011, 3739, 0),
						"Obtain an Ecumenical Key",
						new SkillRequirement(Skill.STRENGTH, 60, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Lava Battlestaff",
						new ItemRequirement("Lava Battlestaff", ItemID.LAVA_BATTLESTAFF).quantity(1),
						new CombatLevelRequirement(75),
						new SkillRequirement(Skill.ATTACK, 30, false),
						new SkillRequirement(Skill.SLAYER, 75, false),
						new SkillRequirement(Skill.MAGIC, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3075, 3654, 0),
						"Equip a Bracelet of Ethereum",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Wilderness Diary",
						new QuestRequirement(QuestHelperQuest.WILDERNESS_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3089, 3540, 0),
						"Open a Looting Bag",
						new CombatLevelRequirement(40)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3047, 3935, 0),
						"Enter the Deep Wilderness Dungeon"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3089, 3864, 0),
						"Open One of Larran's Chests"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Varrock Diary",
						new QuestRequirement(QuestHelperQuest.VARROCK_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Medium Ardougne Diary",
						new QuestRequirement(QuestHelperQuest.ARDOUGNE_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip an Ornament Kit Item",
						new CombatLevelRequirement(126)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1577, 3530, 0),
						"Teleport to Xeric's Honour"),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 60",
						new SkillRequirement(SkillOther.ANY_SKILLS, 60, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 70",
						new SkillRequirement(SkillOther.ANY_SKILLS, 70, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 80",
						new SkillRequirement(SkillOther.ANY_SKILLS, 80, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 1500",
						new SkillRequirement(Skill.OVERALL, 1500, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 1750",
						new SkillRequirement(Skill.OVERALL, 1750, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 60",
						new SkillRequirement(SkillOther.ALL_SKILLS, 60, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 70",
						new SkillRequirement(SkillOther.ALL_SKILLS, 70, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Combat Level 100",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Combat Level 110",
						new CombatLevelRequirement(110)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Lumbridge & Draynor Diary",
						new QuestRequirement(QuestHelperQuest.LUMBRIDGE_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2290, 3154, 0),
						"Equip a Crystal Bow",
						new SkillRequirement(Skill.RANGED, 70, false),
						new SkillRequirement(Skill.AGILITY, 50, false),
						new QuestRequirement(QuestHelperQuest.ROVING_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2290, 3154, 0),
						"Equip a Crystal Shield",
						new SkillRequirement(Skill.DEFENCE, 70, false),
						new SkillRequirement(Skill.AGILITY, 50, false),
						new QuestRequirement(QuestHelperQuest.ROVING_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2290, 3154, 0),
						"Equip a Crystal Halberd",
						new SkillRequirement(Skill.STRENGTH, 35, false),
						new SkillRequirement(Skill.ATTACK, 70, false),
						new SkillRequirement(Skill.AGILITY, 50, false),
						new QuestRequirement(QuestHelperQuest.ROVING_ELVES, QuestState.FINISHED),
						new QuestRequirement(QuestHelperQuest.WESTERN_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3228, 6046, 0),
						"Find Every Memoriam Crystal",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED),
						new SkillRequirement(Skill.AGILITY, 75, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3270, 6083, 0),
						"Open the Enhanced Crystal Chest",
						new SkillRequirement(Skill.SMITHING, 80, false),
						new SkillRequirement(Skill.CRAFTING, 80, false),
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2160, 3329, 0),
						"Charter a Ship From Prifddinas to Port Tyras",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Equip a Berserker Ring",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Equip a Warrior Ring",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Equip a Seers Ring",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Equip an Archers Ring",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Use the Special Attack of a Dragon Axe",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Equip a Seercull",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2792, 3616, 0),
						"Equip a Leaf-Bladed Battleaxe",
						new ItemRequirement("Leaf-bladed Battleaze", ItemID.LEAFBLADED_BATTLEAXE).quantity(1),
						new SkillRequirement(Skill.ATTACK, 65, false),
						new SkillRequirement(Skill.SLAYER, 55, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Equip a Full Skeletal Armour Set",
						new CombatLevelRequirement(70)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Equip a Full Spined Armour Set",
						new CombatLevelRequirement(70)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2620, 3686, 0),
						"Equip a Full Rockshell Armour Set",
						new CombatLevelRequirement(70)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Fremennik Diary",
						new QuestRequirement(QuestHelperQuest.FREMENNIK_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2526, 3860, 0),
						"Collect Miscellania Resources at Full Approval",
						new QuestRequirement(QuestHelperQuest.THRONE_OF_MISCELLANIA, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2853, 3164, 0),
						"Equip an Obsidian Cape",
						new ItemRequirement("Obby Cape", ItemID.OBSIDIAN_CAPE).quantity(1)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2853, 3164, 0),
						"Survive a Hit From TzTok-Jad Without Prayer",
						new CombatLevelRequirement(80)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Karamja Diary",
						new QuestRequirement(QuestHelperQuest.KARAMJA_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2789, 3083, 0),
						"Equip a Red Topaz Machete",
						new CombatLevelRequirement(50),
						new ItemRequirement("red topaz machete", ItemID.RED_TOPAZ_MACHETE).quantity(1)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2789, 3083, 0),
						"Find a Gout Tuber",
						new CombatLevelRequirement(50),
						new SkillRequirement(Skill.WOODCUTTING, 50, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2532, 3571, 0),
						"Equip a Fighter Torso",
						new CombatLevelRequirement(70)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2282, 3612, 0),
						"Equip a Trident of the Seas",
						new SkillRequirement(Skill.SLAYER, 87, false),
						new SkillRequirement(Skill.MAGIC, 75, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Use the Piety Prayer",
						new SkillRequirement(Skill.PRAYER, 70, false),
						new SkillRequirement(Skill.DEFENCE, 70, false),
						new QuestRequirement(QuestHelperQuest.KNIGHT_WAVES_TRAINING_GROUNDS, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Enter the Myths' Guild",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2532, 3571, 0),
						"Reach Level 5 in Any Barbarian Assault Role",
						new CombatLevelRequirement(70)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2627, 2989, 0),
						"Equip an Ogre Expert Chompy Hat",
						new ItemRequirement("lots of chomps", ItemID.CHOMPY_BIRD_HAT).quantity(30),
						new QuestRequirement(QuestHelperQuest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2435, 3519, 0),
						"Equip a Monkey Backpack",
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Kandarin Diary",
						new QuestRequirement(QuestHelperQuest.KANDARIN_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Western Provinces Diary",
						new QuestRequirement(QuestHelperQuest.WESTERN_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2878, 3546, 0),
						"Equip a Dragon Defender",
						new SkillRequirement(Skill.ATTACK, 65, false),
						new SkillRequirement(Skill.STRENGTH, 65, false),
						new SkillRequirement(Skill.DEFENCE, 60, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Falador Diary",
						new QuestRequirement(QuestHelperQuest.FALADOR_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2657, 2655, 0),
						"Equip a Full Void Knight Set",
						new CombatLevelRequirement(80)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3026, 3379, 0),
						"Turn in 100 Mole Claws to Wyson the Gardener",
						new CombatLevelRequirement(80)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2657, 2655, 0),
						"Keep the Veteran Void Knight Above 150 Hitpoints",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2657, 2655, 0),
						"Complete a Game of Veteran Pest Control",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Desert Diary",
						new QuestRequirement(QuestHelperQuest.DESERT_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Have Zahur Make 1,000 Unfinished Potions At Once",
						new QuestRequirement(QuestHelperQuest.DESERT_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3565, 3293, 0),
						"Equip any Full Barrows Armour Set",
						new SkillRequirement(Skill.DEFENCE, 70, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3419, 3538, 0),
						"Equip a Granite Hammer or Granite Ring",
						new SkillRequirement(Skill.SLAYER, 75, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Morytania Diary",
						new QuestRequirement(QuestHelperQuest.MORYTANIA_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3435, 3485, 0),
						"Complete a Hard Temple Trek",
						new QuestRequirement(QuestHelperQuest.IN_AID_OF_THE_MYREQUE, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3599, 3362, 0),
						"Pet Frank",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3218, 3794, 0),
						"Equip a Dragon Pickaxe",
						new CombatLevelRequirement(80)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip an Enchanted Slayer Staff",
						new SkillRequirement(Skill.MAGIC, 75, false),
						new SkillRequirement(Skill.SLAYER, 55, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3075, 3654, 0),
						"Trade With the Emblem Trader",
						new CombatLevelRequirement(50)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Wilderness Diary",
						new QuestRequirement(QuestHelperQuest.WILDERNESS_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Varrock Diary",
						new QuestRequirement(QuestHelperQuest.VARROCK_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Hard Ardougne Diary",
						new QuestRequirement(QuestHelperQuest.ARDOUGNE_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 90",
						new SkillRequirement(SkillOther.ANY_SKILLS, 90, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Achieve Your First Level 95",
						new SkillRequirement(SkillOther.ANY_SKILLS, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 2000",
						new SkillRequirement(Skill.OVERALL, 2000, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 2100",
						new SkillRequirement(Skill.OVERALL, 2100, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 2200",
						new SkillRequirement(Skill.OVERALL, 2200, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 80",
						new SkillRequirement(SkillOther.ALL_SKILLS, 80, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 90",
						new SkillRequirement(SkillOther.ALL_SKILLS, 90, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain a Skilling Pet",
						new ItemRequirement("A skilling pet", ItemID.COOKING_CAPET).quantity(10)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain a Boss Pet",
						new ItemRequirement("A boss pet", ItemID.VORKI).quantity(10)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Combat Level 120",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Combat Level 126",
						new CombatLevelRequirement(126)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Add a Jar to a Display Case",
						new SkillRequirement(Skill.CONSTRUCTION, 80, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3564, 4005, 0),
						"Equip a Dragon Crossbow",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new SkillRequirement(Skill.FLETCHING, 78, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Dragonfire Shield",
						new SkillRequirement(Skill.SMITHING, 90, false),
						new SkillRequirement(Skill.DEFENCE, 75, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3745, 3783, 0),
						"Equip an Ancient Wyvern Shield",
						new SkillRequirement(Skill.SMITHING, 66, false),
						new SkillRequirement(Skill.DEFENCE, 75, false),
						new SkillRequirement(Skill.MAGIC, 70, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3199, 3169, 0),
						"Equip an Abyssal Bludgeon",
						new QuestRequirement(QuestHelperQuest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED),
						new SkillRequirement(Skill.SLAYER, 85, false),
						new SkillRequirement(Skill.ATTACK, 70, false),
						new SkillRequirement(Skill.STRENGTH, 70, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3199, 3169, 0),
						"Equip an Abyssal Dagger",
						new QuestRequirement(QuestHelperQuest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED),
						new SkillRequirement(Skill.SLAYER, 85, false),
						new SkillRequirement(Skill.ATTACK, 70, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Lumbridge & Draynor Diary",
						new QuestRequirement(QuestHelperQuest.LUMBRIDGE_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3237, 6065, 0),
						"Equip a Full Crystal Armour Set",
						new SkillRequirement(Skill.SMITHING, 74, false),
						new SkillRequirement(Skill.CRAFTING, 74, false),
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Complete the Corrupted Gauntlet",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3284, 6060, 0),
						"Obtain a Crystal Tool Seed",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2208, 3057, 0),
						"Equip a Serpentine Helm",
						new SkillRequirement(Skill.DEFENCE, 75, false),
						new SkillRequirement(Skill.CRAFTING, 52, false),
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2208, 3057, 0),
						"Craft a Toxic Blowpipe",
						new SkillRequirement(Skill.FLETCHING, 53, false),
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2208, 3057, 0),
						"Craft a Toxic Trident",
						new SkillRequirement(Skill.CRAFTING, 59, false),
						new SkillRequirement(Skill.SLAYER, 87, false),
						new QuestRequirement(QuestHelperQuest.REGICIDE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3237, 6065, 0),
						"Equip a Piece of the Dragonstone Armour Set",
						new SkillRequirement(Skill.DEFENCE, 40, false),
						new SkillRequirement(Skill.SMITHING, 80, false),
						new SkillRequirement(Skill.CRAFTING, 80, false),
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Equip a Dragonfire Ward",
						new CombatLevelRequirement(120),
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Equip a Dragonbone Necklace",
						new CombatLevelRequirement(120),
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip Every Dagannoth King Ring"),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Equip a Neitiznot Faceguard",
						new CombatLevelRequirement(120),
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Fremennik Diary",
						new QuestRequirement(QuestHelperQuest.FREMENNIK_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Completed God Book",
						new CombatLevelRequirement(126),
						new QuestRequirement(QuestHelperQuest.HORROR_FROM_THE_DEEP, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Equip a fire cape",
						new CombatLevelRequirement(80)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Sacrifice a Fire Cape to Access the Inferno",
						new CombatLevelRequirement(80)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Karamja Diary",
						new QuestRequirement(QuestHelperQuest.KARAMJA_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Purchase an Onyx in Mor Ul Rek",
						new CombatLevelRequirement(80)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3075, 3654, 0),
						"Equip a Thammaron's Sceptre",
						new CombatLevelRequirement(90)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2435, 3519, 0),
						"Equip Some Zenyte Jewelry",
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED),
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2435, 3519, 0),
						"Equip a Heavy Ballista",
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED),
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2282, 3612, 0),
						"Equip an Abyssal Tentacle",
						new SkillRequirement(Skill.SLAYER, 87, false),
						new SkillRequirement(Skill.MAGIC, 75, false),
						new SkillRequirement(Skill.ATTACK, 75, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2413, 3059, 0),
						"Equip an Occult Necklace",
						new SkillRequirement(Skill.MAGIC, 70, false),
						new SkillRequirement(Skill.SLAYER, 93, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2503, 3519, 0),
						"Equip a Dragon Full Helm",
						new CombatLevelRequirement(124)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2532, 3571, 0),
						"Reach Level 5 in Every Barbarian Assault Role",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2627, 2989, 0),
						"Equip a Dragon Archer Chompy Hat",
						new ItemRequirement("lots of chomps", ItemID.CHOMPY_BIRD_HAT).quantity(60),
						new QuestRequirement(QuestHelperQuest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Kandarin Diary",
						new QuestRequirement(QuestHelperQuest.KANDARIN_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Western Provinces Diary",
						new QuestRequirement(QuestHelperQuest.WESTERN_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2886, 3401, 0),
						"Equip an Infernal Tool",
						new CombatLevelRequirement(110),
						new SkillRequirement(Skill.ATTACK, 60, false),
						new SkillRequirement(Skill.SLAYER, 91, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip a Staff of the Dead",
						new CombatLevelRequirement(90),
						new SkillRequirement(Skill.ATTACK, 75, false),
						new SkillRequirement(Skill.MAGIC, 75, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip a Zamorakian Spear",
						new CombatLevelRequirement(90),
						new SkillRequirement(Skill.ATTACK, 70, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip a Piece of the Armadyl Armour Set",
						new CombatLevelRequirement(90),
						new SkillRequirement(Skill.DEFENCE, 70, false),
						new SkillRequirement(Skill.RANGED, 70, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip a Saradomin Sword",
						new CombatLevelRequirement(90),
						new SkillRequirement(Skill.ATTACK, 70, false),
						new SkillRequirement(Skill.AGILITY, 70, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip a Piece of the Bandos Armour Set",
						new CombatLevelRequirement(90),
						new SkillRequirement(Skill.STRENGTH, 70, false),
						new SkillRequirement(Skill.DEFENCE, 70, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip an Armadyl Crossbow",
						new CombatLevelRequirement(90),
						new SkillRequirement(Skill.RANGED, 70, false),
						new SkillRequirement(Skill.AGILITY, 70, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2886, 3401, 0),
						"Equip Some Primordial, Pegasian or Eternal Boots",
						new CombatLevelRequirement(120),
						new SkillRequirement(Skill.SLAYER, 91, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip a Godsword",
						new CombatLevelRequirement(100),
						new SkillRequirement(Skill.ATTACK, 75, false),
						new SkillRequirement(Skill.SMITHING, 80, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Falador Diary",
						new QuestRequirement(QuestHelperQuest.FALADOR_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3230, 3108, 0),
						"Equip a Dragon Chainbody in the Kharidian Desert",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Desert Diary",
						new QuestRequirement(QuestHelperQuest.DESERT_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Complete the Theatre of Blood With No Deaths",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Equip Some Guardian Boots",
						new SkillRequirement(Skill.DEFENCE, 75, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3565, 3293, 0),
						"Equip Every Barrows Armour Set",
						new SkillRequirement(Skill.DEFENCE, 70, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED),
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Equip an Inquisitor's Mace",
						new SkillRequirement(Skill.ATTACK, 75, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Equip a Piece of the Inquisitor's Set",
						new SkillRequirement(Skill.STRENGTH, 70, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Equip a Nightmare Staff",
						new SkillRequirement(Skill.MAGIC, 65, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Create an Amulet of Blood Fury",
						new SkillRequirement(Skill.CRAFTING, 90, false),
						new SkillRequirement(Skill.MAGIC, 87, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Equip an Avernic Defender",
						new SkillRequirement(Skill.DEFENCE, 70, false),
						new SkillRequirement(Skill.ATTACK, 70, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Equip a Scythe of Vitur",
						new SkillRequirement(Skill.ATTACK, 75, false),
						new SkillRequirement(Skill.STRENGTH, 75, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Morytania Diary",
						new QuestRequirement(QuestHelperQuest.MORYTANIA_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3243, 3742, 0),
						"Equip a Treasonous Ring",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3243, 3742, 0),
						"Equip a Tyrannical Ring",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3243, 3742, 0),
						"Equip a Ring of the Gods",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3202, 3679, 0),
						"Equip a Blessed Spirit Shield",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3365, 3939, 0),
						"Equip a Malediction Ward",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3365, 3939, 0),
						"Equip an Odium Ward",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Wilderness Diary",
						new QuestRequirement(QuestHelperQuest.WILDERNESS_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Varrock Diary",
						new QuestRequirement(QuestHelperQuest.VARROCK_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3284, 6060, 0),
						"Obtain a Zalcano Shard",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Elite Ardougne Diary",
						new QuestRequirement(QuestHelperQuest.ARDOUGNE_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 2277",
						new SkillRequirement(Skill.OVERALL, 2277, false)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Base Level 95",
						new SkillRequirement(SkillOther.ALL_SKILLS, 95, false)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3564, 4002, 0),
						"Equip a Dragon Platebody or Dragon Kiteshield",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new SkillRequirement(Skill.SMITHING, 90, false),
						new SkillRequirement(Skill.DEFENCE, 75, false)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Equip a Corrupted Blade of Saeldor",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3231, 6116, 0),
						"Equip a Crystal Crown",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip Every Draconic Shield",
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED),
						new CombatLevelRequirement(126)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip Every Completed God Book"),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Equip an Infernal Cape",
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2435, 3519, 0),
						"Equip All Zenyte Jewelry",
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED),
						new CombatLevelRequirement(124)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2282, 3612, 0),
						"Enhance a Trident of the Seas",
						new CombatLevelRequirement(124),
						new SkillRequirement(Skill.SLAYER, 87, false),
						new SkillRequirement(Skill.MAGIC, 75, false)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2627, 2989, 0),
						"Equip an Expert Dragon Archer Chompy Hat",
						new ItemRequirement("lots of chomps", ItemID.CHOMPY_BIRD_HAT).quantity(120),
						new QuestRequirement(QuestHelperQuest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip Every Godsword",
						new CombatLevelRequirement(120),
						new SkillRequirement(Skill.ATTACK, 75, false),
						new SkillRequirement(Skill.SMITHING, 80, false)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip a Full Armadyl Armour Set",
						new CombatLevelRequirement(110),
						new SkillRequirement(Skill.RANGED, 90, false),
						new SkillRequirement(Skill.DEFENCE, 80, false)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2925, 3745, 0),
						"Equip a Full Bandos Armour Set",
						new CombatLevelRequirement(120),
						new SkillRequirement(Skill.DEFENCE, 80, false)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2886, 3401, 0),
						"Equip Some Primordial, Pegasian and Eternal Boots",
						new CombatLevelRequirement(120),
						new SkillRequirement(Skill.SLAYER, 91, false)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Equip a Full Inquisitor's Set",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Equip a Nightmare Staff With an Orb",
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED),
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3202, 3679, 0),
						"Equip a Spectral or Arcane Spirit Shield",
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3202, 3679, 0),
						"Equip an Elysian Spirit Shield",
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3075, 3650, 0),
						"Obtain Every Revenant Weapon",
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3371, 3892, 0),
						"Equip an Amulet of Eternal Glory",
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip an Adamant Weapon",
						new SkillRequirement(Skill.ATTACK, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Rune Weapon",
						new ItemRequirement("Rune dagger", ItemID.RUNE_DAGGER).quantity(1),
						new SkillRequirement(Skill.ATTACK, 40, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2792, 3615, 0),
						"Equip a Brine Sabre",
						new SkillRequirement(Skill.SLAYER, 47, false),
						new SkillRequirement(Skill.ATTACK, 40, false),
						new QuestRequirement(QuestHelperQuest.OLAFS_QUEST, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Dragon Weapon",
						new QuestRequirement(QuestHelperQuest.LOST_CITY, QuestState.FINISHED),
						new SkillRequirement(Skill.ATTACK, 60, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3117, 9848, 0),
						"Equip a Hill Giant Club",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2853, 3164, 0),
						"Equip a Toktz-Xil-Ak",
						new SkillRequirement(Skill.ATTACK, 60, false),
						new ItemRequirement("Obby sword", ItemID.TOKTZXILAK).quantity(1)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2853, 3164, 0),
						"Equip a Toktz-Xil-Ek",
						new SkillRequirement(Skill.ATTACK, 60, false),
						new ItemRequirement("Obby dagger", ItemID.TOKTZXILEK).quantity(1)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3230, 3108, 0),
						"Equip a Dragon 2H Sword",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3248, 3921, 0),
						"Equip a Dragon 2H Sword in the Wilderness",
						new CombatLevelRequirement(50)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Level 99 Attack",
						new SkillRequirement(Skill.ATTACK, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain 25 Million Attack XP",
						new SkillRequirement(Skill.ATTACK, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip an Abyssal Whip",
						new SkillRequirement(Skill.ATTACK, 70, false),
						new SkillRequirement(Skill.SLAYER, 85, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3075, 3654, 0),
						"Equip a Viggora's Chainmace",
						new CombatLevelRequirement(90)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Equip a Ghrazi Rapier",
						new SkillRequirement(Skill.ATTACK, 75, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3302, 3491, 0),
						"Turn a Log Into a Plank",
						new ItemRequirement("Log", ItemID.LOGS).quantity(1)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2637, 3295, 0),
						"Purchase a Player Owned House"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2953, 3223, 0),
						"Build a Room in Your Player Owned House"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2951, 3225, 0),
						"Enter your Player Owned House"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2982, 3369, 0),
						"Move Your House to Taverley",
						new SkillRequirement(Skill.CONSTRUCTION, 10, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2951, 3224, 0),
						"Build a Mahogany Portal",
						new SkillRequirement(Skill.CONSTRUCTION, 65, true)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2951, 3224, 0),
						"Build an Oak Larder",
						new SkillRequirement(Skill.CONSTRUCTION, 33, true)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill a Medium S.T.A.S.H. Unit",
						new SkillRequirement(Skill.CONSTRUCTION, 42, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2982, 3369, 0),
						"Move Your House to Prifddinas",
						new SkillRequirement(Skill.CONSTRUCTION, 70, false),
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2982, 3369, 0),
						"Move Your House to Rellekka",
						new SkillRequirement(Skill.CONSTRUCTION, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2982, 3369, 0),
						"Move Your House to Yanille",
						new SkillRequirement(Skill.CONSTRUCTION, 50, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2982, 3369, 0),
						"Move Your House to Pollnivneach",
						new SkillRequirement(Skill.CONSTRUCTION, 20, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Fill a Hard S.T.A.S.H. Unit",
						new SkillRequirement(Skill.CONSTRUCTION, 55, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Build an Achievement Gallery",
						new SkillRequirement(Skill.CONSTRUCTION, 80, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Build a Gilded Altar",
						new SkillRequirement(Skill.CONSTRUCTION, 75, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Level 99 Construction",
						new SkillRequirement(Skill.CONSTRUCTION, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain 25 Million Construction XP",
						new SkillRequirement(Skill.CONSTRUCTION, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Build a Gilded Portal Nexus",
						new SkillRequirement(Skill.CONSTRUCTION, 82, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3365, 3939, 0),
						"Build an Obelisk",
						new SkillRequirement(Skill.CONSTRUCTION, 80, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Build a Demonic Throne",
						new SkillRequirement(Skill.CONSTRUCTION, 99, false)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2816, 3443, 0),
						"Cook a Shrimp",
						new ItemRequirement("Raw Shrimp", ItemID.RAW_SHRIMPS).quantity(1)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2816, 3443, 0),
						"Burn Some Food",
						new ItemRequirement("Raw Shrimp", ItemID.RAW_SHRIMPS).quantity(1)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3211, 3216, 0),
						"Use the Range in Lumbridge Castle",
						new ItemRequirement("Raw Shrimps", ItemID.RAW_SHRIMPS).quantity(1),
						new QuestRequirement(QuestHelperQuest.COOKS_ASSISTANT, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2475, 3429, 0),
						"Complete the Gnome Stronghold Agility Course"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3104, 3269, 0),
						"Obtain a Mark of Grace",
						new SkillRequirement(Skill.AGILITY, 10, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3104, 3269, 0),
						"Complete a Rooftop Agility Course",
						new SkillRequirement(Skill.AGILITY, 10, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3105, 3279, 0),
						"Complete the Draynor Agility Course",
						new SkillRequirement(Skill.AGILITY, 10, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2808, 3193, 0),
						"Receive an Agility Arena Ticket"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3275, 3196, 0),
						"Complete the Al Kharid Agility Course",
						new SkillRequirement(Skill.AGILITY, 20, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3102, 3277, 0),
						"Complete 50 Laps of a Rooftop Agility Course",
						new SkillRequirement(Skill.AGILITY, 10, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3105, 3279, 0),
						"Complete 30 Laps of the Draynor Agility Course",
						new SkillRequirement(Skill.AGILITY, 10, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2295, 3206, 0),
						"Cross a Trap in Isafdar",
						new QuestRequirement(QuestHelperQuest.UNDERGROUND_PASS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2641, 4043, 0),
						"Complete the Penguin Agility Course",
						new SkillRequirement(Skill.AGILITY, 30, false),
						new QuestRequirement(QuestHelperQuest.COLD_WAR, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2809, 3190, 0),
						"Buy a Snapdragon From Pirate Jackie the Fruit"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2543, 3566, 0),
						"Complete the Barbarian Outpost Agility Course",
						new SkillRequirement(Skill.AGILITY, 35, false),
						new QuestRequirement(QuestHelperQuest.ALFRED_GRIMHANDS_BARCRAWL, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3034, 3340, 0),
						"Complete the Falador Agility Course",
						new SkillRequirement(Skill.AGILITY, 50, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3330, 2828, 0),
						"Turn in a Pyramid Top to Simon Templeton",
						new SkillRequirement(Skill.AGILITY, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3506, 3488, 0),
						"Complete the Canifis Agility Course",
						new SkillRequirement(Skill.AGILITY, 40, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3543, 3465, 0),
						"Complete the Werewolf Agility Course",
						new SkillRequirement(Skill.AGILITY, 60, false),
						new QuestRequirement(QuestHelperQuest.PRIEST_IN_PERIL, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2998, 3913, 0),
						"Complete the Wilderness Agility Course",
						new SkillRequirement(Skill.AGILITY, 52, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3102, 3277, 0),
						"Complete 250 Laps of a Rooftop Agility Course",
						new SkillRequirement(Skill.AGILITY, 10, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3200, 3170, 0),
						"Take the Advanced Shortcut to the Cosmic Altar",
						new QuestRequirement(QuestHelperQuest.LOST_CITY, QuestState.FINISHED),
						new SkillRequirement(Skill.AGILITY, 66, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3251, 6108, 0),
						"Complete the Prifddinas Agility Course",
						new SkillRequirement(Skill.AGILITY, 75, false),
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3251, 6108, 0),
						"Complete the Prifddinas Agility Course in 1:10",
						new SkillRequirement(Skill.AGILITY, 75, false),
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2624, 3679, 0),
						"Complete the Rellekka Agility Course",
						new SkillRequirement(Skill.AGILITY, 80, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2864, 2972, 0),
						"Take a Shortcut Across the Shilo Village River",
						new QuestRequirement(QuestHelperQuest.SHILO_VILLAGE, QuestState.FINISHED),
						new SkillRequirement(Skill.AGILITY, 77, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2728, 3486, 0),
						"Complete the Seers' Village Agility Course",
						new SkillRequirement(Skill.AGILITY, 60, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2762, 2750, 0),
						"Equip a Karamja Monkey Backpack",
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2762, 2750, 0),
						"Equip a Maniacal Monkey Backpack",
						new ItemRequirement("lots of laps", ItemID.EXPLORER_BACKPACK).quantity(10),
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Full Graceful Outfit",
						new SkillRequirement(Skill.AGILITY, 70, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Complete Floor 1 of the Hallowed Sepulchre",
						new SkillRequirement(Skill.AGILITY, 52, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Complete Floor 2 of the Hallowed Sepulchre",
						new SkillRequirement(Skill.AGILITY, 62, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Complete Floor 3 of the Hallowed Sepulchre",
						new SkillRequirement(Skill.AGILITY, 72, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Complete Floor 4 of the Hallowed Sepulchre",
						new SkillRequirement(Skill.AGILITY, 82, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Complete the Hallowed Sepulchre in 8:00",
						new SkillRequirement(Skill.AGILITY, 92, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Purchase a Reward From the Hallowed Sepulchre",
						new SkillRequirement(Skill.AGILITY, 52, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Obtain Every Hallowed Tool",
						new SkillRequirement(Skill.AGILITY, 52, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Level 99 Agility",
						new SkillRequirement(Skill.AGILITY, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Obtain 25 Million Agility XP",
						new SkillRequirement(Skill.AGILITY, 99, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2807, 3191, 0),
						"Receive 60 Agility Arena Tickets With No Mistakes",
						new SkillRequirement(Skill.AGILITY, 70, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2674, 3298, 0),
						"Complete the Ardougne Agility Course",
						new SkillRequirement(Skill.AGILITY, 90, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2762, 2750, 0),
						"Equip a Kruk Jr. Monkey Backpack",
						new ItemRequirement("lots of laps", ItemID.EXPLORER_BACKPACK).quantity(30),
						new QuestRequirement(QuestHelperQuest.MONKEY_MADNESS_II, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Complete Floor 5 of the Hallowed Sepulchre",
						new SkillRequirement(Skill.AGILITY, 92, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Complete the Hallowed Sepulchre in 6:30",
						new SkillRequirement(Skill.AGILITY, 92, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3653, 3381, 0),
						"Equip a Ring of Endurance",
						new SkillRequirement(Skill.AGILITY, 92, false),
						new QuestRequirement(QuestHelperQuest.SINS_OF_THE_FATHER, QuestState.FINISHED)),
				125
		);
// ----------------------------------------------------- NEWLY ADDED TASKS START HERE -----------------------------------------------------
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2816, 3443, 0),
						"Successfully Cook 5 Pieces of Food"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3237, 6065, 0),
						"Craft a Celestial Signet",
						new SkillRequirement(Skill.SMITHING, 70, false),
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip either a Steel Platebody, some Steel Platelegs or a Steel Full Helm",
						new SkillRequirement(Skill.DEFENCE, 5, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip either a Black Platebody, some Black Platelegs or a Black Full Helm",
						new SkillRequirement(Skill.DEFENCE, 10, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Equip a Willow Shield",
						new SkillRequirement(Skill.FLETCHING, 42, false),
						new SkillRequirement(Skill.DEFENCE, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Complete 25 Farming Contracts",
						new SkillRequirement(Skill.FARMING, 45, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Complete 50 Farming Contracts",
						new SkillRequirement(Skill.FARMING, 45, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Complete 75 Farming Contracts",
						new SkillRequirement(Skill.FARMING, 45, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Complete 100 Farming Contracts",
						new SkillRequirement(Skill.FARMING, 45, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Complete 200 Farming Contracts",
						new SkillRequirement(Skill.FARMING, 45, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Complete 300 Farming Contracts",
						new SkillRequirement(Skill.FARMING, 45, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Complete 400 Farming Contracts",
						new SkillRequirement(Skill.FARMING, 45, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Complete 500 Farming Contracts",
						new SkillRequirement(Skill.FARMING, 45, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Equip the Farmer's Outfit",
						new SkillRequirement(Skill.FARMING, 45, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Plant 100 Logavano Seeds",
						new SkillRequirement(Skill.FARMING, 74, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Enter the Farming Guild's High Tier",
						new SkillRequirement(Skill.FARMING, 85, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1628, 3504, 0),
						"Check a grown Redwood Tree",
						new SkillRequirement(Skill.FARMING, 90, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1630, 3959, 0),
						"25 Wintertodt Kills",
						new SkillRequirement(Skill.FIREMAKING, 50, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1630, 3959, 0),
						"50 Wintertodt Kills",
						new SkillRequirement(Skill.FIREMAKING, 50, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1630, 3959, 0),
						"75 Wintertodt Kills",
						new SkillRequirement(Skill.FIREMAKING, 50, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1630, 3959, 0),
						"100 Wintertodt Kills",
						new SkillRequirement(Skill.FIREMAKING, 50, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1630, 3959, 0),
						"150 Wintertodt Kills",
						new SkillRequirement(Skill.FIREMAKING, 50, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1630, 3959, 0),
						"250 Wintertodt Kills",
						new SkillRequirement(Skill.FIREMAKING, 50, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1630, 3959, 0),
						"750 Wintertodt Kills",
						new SkillRequirement(Skill.FIREMAKING, 50, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1630, 3959, 0),
						"1000 Wintertodt Kills",
						new SkillRequirement(Skill.FIREMAKING, 50, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1630, 3959, 0),
						"Equip the Pyromancer's Garb",
						new SkillRequirement(Skill.FIREMAKING, 50, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"1 Tempoross Kill",
						new SkillRequirement(Skill.FISHING, 35, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"25 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"50 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"75 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"100 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"150 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"200 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"250 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"500 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"750 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3146, 2839, 0),
						"1000 Tempoross Kills",
						new SkillRequirement(Skill.FISHING, 35, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1672, 3735, 0),
						"Cast Resurrect Superior Ghost",
						new SkillRequirement(Skill.MAGIC, 57, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1672, 3735, 0),
						"Inferior Demonbane Demon Kill",
						new SkillRequirement(Skill.MAGIC, 44, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2411, 3054, 0),
						"Equip a Dust Battlestaff",
						new SkillRequirement(Skill.SLAYER, 90, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2411, 3054, 0),
						"Equip a Mist Battlestaff",
						new SkillRequirement(Skill.SLAYER, 90, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1672, 3735, 0),
						"Cast Degrime Spell Full Clean",
						new SkillRequirement(Skill.MAGIC, 70, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1672, 3735, 0),
						"Cast Full Sinister Offering",
						new SkillRequirement(Skill.MAGIC, 92, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1502, 3844, 0),
						"Obtain Runite Ore at the Blast Mine",
						new SkillRequirement(Skill.MINING, 85, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Activate an Arcane or Dexterous Prayer Scroll",
						new CombatLevelRequirement(110)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2996, 3493, 0),
						"Craft a Chaos Rune using a Chaos Core",
						new SkillRequirement(Skill.RUNECRAFT, 35, false),
						new QuestRequirement(QuestHelperQuest.BELOW_ICE_MOUNTAIN, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"Receive a Konar Slayer Task",
						new CombatLevelRequirement(75)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2432, 3424, 0),
						"Receive a Slayer Task From Nieve or Steve",
						new CombatLevelRequirement(85)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"Defeat a Drake",
		new SkillRequirement(Skill.SLAYER, 84, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"25 Alchemical Hydra Kills",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"50 Alchemical Hydra Kills",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"75 Alchemical Hydra Kills",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"100 Alchemical Hydra Kills",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"250 Alchemical Hydra Kills",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"500 Alchemical Hydra Kills",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"Defeat a Hydra",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"750 Alchemical Hydra Kills",
						new SkillRequirement(Skill.SLAYER, 95, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1509, 3566, 0),
						"Equip a Dragon Warhammer",
						new CombatLevelRequirement(110)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2655, 3307, 0),
						"Steal Some Silk"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1794, 3750, 0),
						"Steal 25 Artefacts",
						new SkillRequirement(Skill.THIEVING, 49, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1794, 3750, 0),
						"Steal 50 Artefacts",
						new SkillRequirement(Skill.THIEVING, 49, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1794, 3750, 0),
						"Steal 100 Artefacts",
						new SkillRequirement(Skill.THIEVING, 49, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3320, 3143, 0),
						"Pick a Autumn Sq'irk",
						new QuestRequirement(QuestHelperQuest.PRINCE_ALI_RESCUE, QuestState.FINISHED),
						new SkillRequirement(Skill.THIEVING, 45, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1794, 3750, 0),
						"Steal 250 Artefacts",
						new SkillRequirement(Skill.THIEVING, 49, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3291, 3169, 0),
						"Defeat an Al Kharid Warrior"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1509, 3566, 0),
						"2500 Lizardmen Shaman Kills",
						new CombatLevelRequirement(90)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1509, 3566, 0),
						"5000 Lizardmen Shaman Kills",
						new CombatLevelRequirement(90)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"25 Sarachnis Kills",
						new CombatLevelRequirement(90)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"50 Sarachnis Kills",
						new CombatLevelRequirement(90)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"75 Sarachnis Kills",
						new CombatLevelRequirement(90)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"100 Sarachnis Kills",
						new CombatLevelRequirement(90)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"250 Sarachnis Kills",
						new CombatLevelRequirement(90)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"500 Sarachnis Kills",
						new CombatLevelRequirement(90)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"10 Skotizo Kills",
						new CombatLevelRequirement(90)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"25 Chambers of Xeric",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"50 Chambers of Xeric",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"75 Chambers of Xeric",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"100 Chambers of Xeric",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"1 Chambers of Xeric Challenge Mode",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"10 Chambers of Xeric Challenge Mode",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"5 Mimic Kills",
						new CombatLevelRequirement(80)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat Phosani's Nightmare",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare or Phosani's Nightmare 5 times",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare or Phosani's Nightmare 10 times",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare or Phosani's Nightmare 25 times",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Nex",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Nex 10 Times",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Nex 25 Times",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Nex 50 Times",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"25 Skotizo Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"50 Skotizo Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"75 Skotizo Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"100 Skotizo Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"150 Skotizo Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"200 Skotizo Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1631, 3672, 0),
						"250 Skotizo Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"250 Chambers of Xeric",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"25 Chambers of Xeric Challenge Mode",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"50 Chambers of Xeric Challenge Mode",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"100 Chambers of Xeric Challenge Mode",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"25 Mimic Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"50 Mimic Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Complete the Theatre of Blood 50 Times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Complete the Theatre of Blood 300 Times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"750 Sarachnis Kills",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare or Phosani's Nightmare 50 times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare or Phosani's Nightmare 100 times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare or Phosani's Nightmare 250 times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare or Phosani's Nightmare 500 times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3729, 3318, 0),
						"Defeat The Nightmare or Phosani's Nightmare 750 times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Defeat the Theatre of Blood Hardmode",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Defeat the Theatre of Blood Hardmode 25 times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Defeat the Theatre of Blood Hardmode 50 times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Defeat the Theatre of Blood Hardmode 100 times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Defeat the Theatre of Blood Hardmode 150 times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Nex 100 Times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Nex 200 Times",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"200 Chambers of Xeric Challenge Mode",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"CM Chambers of Xeric in Target Time",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Solo CM Chambers of Xeric in Target Time",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"30 Minutes Chambers of Xeric Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"26 Minute Chambers of Xeric Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"22 Minute Chambers of Xeric Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"18 Minute Chambers of Xeric Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"16 Minute Chambers of Xeric Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"55 Minute Chambers of Xeric Challenge Mode Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"50 Minute Chambers of Xeric Challenge Mode Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"46 Minute Chambers of Xeric Challenge Mode Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"42 Minute Chambers of Xeric Challenge Mode Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"38 Minute Chambers of Xeric Challenge Mode Solo",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"100 Mimic Kills",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Defeat Nex 500 Times",
						new CombatLevelRequirement(100)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Client of Kourend",
						new QuestRequirement(QuestHelperQuest.CLIENT_OF_KOUREND, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Queen of Thieves",
						new QuestRequirement(QuestHelperQuest.THE_QUEEN_OF_THIEVES, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Forsaken Tower",
						new QuestRequirement(QuestHelperQuest.THE_FORSAKEN_TOWER, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Ascent of Arceuus",
						new QuestRequirement(QuestHelperQuest.THE_ASCENT_OF_ARCEUUS, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete Fishing Contest",
						new QuestRequirement(QuestHelperQuest.FISHING_CONTEST, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Depths of Despair",
						new QuestRequirement(QuestHelperQuest.THE_DEPTHS_OF_DESPAIR, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Tale Of The Righteous",
						new QuestRequirement(QuestHelperQuest.TALE_OF_THE_RIGHTEOUS, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"In Search Of Knowledge",
						new QuestRequirement(QuestHelperQuest.IN_SEARCH_OF_KNOWLEDGE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Architectural Alliance",
						new QuestRequirement(QuestHelperQuest.ARCHITECTURAL_ALLIANCE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"The Frozen Door",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete a Beginner Clue Scroll",
						new CombatLevelRequirement(126)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Burn Some Coloured Logs",
						new CombatLevelRequirement(126)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Eat some Purple Sweets",
						new CombatLevelRequirement(126)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain a Unique Item From an Easy Clue",
						new CombatLevelRequirement(126)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Gain a Unique Item From a Beginner Clue",
						new CombatLevelRequirement(126)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete an Easy Clue Scroll",
						new CombatLevelRequirement(126)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"500 Elite Clue Scrolls",
						new CombatLevelRequirement(126)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2887, 3397, 0),
						"Enter the Taverly Dungeon"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2799, 3415, 0),
						"Buy Something From Trader Crewmembers"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2632, 3380, 0),
						"Make some Flour"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1761, 3559, 0),
						"Friend of House Hosidius"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1538, 3563, 0),
						"Friend of House Shayzien"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1663, 3759, 0),
						"Friend of House Arceuus"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1503, 3789, 0),
						"Friend of House Lovakengj"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1796, 3747, 0),
						"Friend of House piscarilius"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Kourend and Kebos Easy Diary Tasks",
						new QuestRequirement(QuestHelperQuest.KOUREND_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1509, 3566, 0),
						"Enter Level 3 of the Chasm of Fire"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Reach Total Level 250",
						new SkillRequirement(Skill.OVERALL, 250, false)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Complete the Easy Western Provinces Diary",
						new QuestRequirement(QuestHelperQuest.WESTERN_EASY, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2837, 3432, 0),
						"Obtain a Casket from Fishing"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2996, 3493, 0),
						"Equip an Imcando Hammer",
						new QuestRequirement(QuestHelperQuest.BELOW_ICE_MOUNTAIN, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2996, 3493, 0),
						"Open an Ornate Lockbox",
						new QuestRequirement(QuestHelperQuest.BELOW_ICE_MOUNTAIN, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"1 Easy Combat Achievement"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"5 Easy Combat Achievements"),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3481, 3320, 0),
						"Open a Bronze Chest",
						new QuestRequirement(QuestHelperQuest.SHADES_OF_MORTTON, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3737, 3806, 0),
						"Pet the Museum Camp dog",
						new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED)),
				5
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Kourend and Kebos Medium Diary Tasks",
						new QuestRequirement(QuestHelperQuest.KOUREND_MEDIUM, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Open 10 Grubby Chests",
						new SkillRequirement(Skill.THIEVING, 57, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Open 25 Grubby Chests",
						new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Open 50 Grubby Chests",
						new QuestRequirement(QuestHelperQuest.BONE_VOYAGE, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1360, 3631, 0),
						"Equip a Pearl Fishing Rod"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"10 Easy Combat Achievements",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"20 Easy Combat Achievements",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"1 Medium Combat Achievement",
						new CombatLevelRequirement(75)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"10 Medium Combat Achievement",
						new CombatLevelRequirement(75)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"20 Medium Combat Achievement",
						new CombatLevelRequirement(75)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3481, 3320, 0),
						"Open a Black Chest",
						new QuestRequirement(QuestHelperQuest.SHADES_OF_MORTTON, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3082, 3479, 0),
						"Win a Game of Soul Wars"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3082, 3479, 0),
						"Purchase an Ectoplasmator"),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3237, 6065, 0),
						"Purchase a Celestial ring",
						new QuestRequirement(QuestHelperQuest.SONG_OF_THE_ELVES, QuestState.FINISHED)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3059, 3379, 0),
						"Equip a Piece of the Golden Prospector set",
						new SkillRequirement(Skill.MINING, 30, false)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Max out 1 Fragment",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Activate 1 Set Effect",
						new CombatLevelRequirement(50)),
				25
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Receive 1 Chambers of Xeric Unique",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"Equip Boots of Brimstone",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Kourend and Kebos Hard Diary Tasks",
						new QuestRequirement(QuestHelperQuest.KOUREND_HARD, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Open 100 Grubby Chests",
						new SkillRequirement(Skill.THIEVING, 57, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1629, 3801, 0),
						"Turn in 500 Library Books"),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"All Easy Combat Achievements",
						new CombatLevelRequirement(50)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"30 Medium Combat Achievement",
						new CombatLevelRequirement(75)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"All Medium Combat Achievements",
						new CombatLevelRequirement(75)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"1 Hard Combat Achievement",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"10 Hard Combat Achievement",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"20 Hard Combat Achievement",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"30 Hard Combat Achievement",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"45 Hard Combat Achievement",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"1 Elite Combat Achievement",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"10 Elite Combat Achievement",
						new CombatLevelRequirement(120)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"20 Elite Combat Achievement",
						new CombatLevelRequirement(120)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"30 Elite Combat Achievement",
						new CombatLevelRequirement(120)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"1 Master Combat Achievement",
						new CombatLevelRequirement(120)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"10 Master Combat Achievement",
						new CombatLevelRequirement(120)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3481, 3320, 0),
						"Equip a Piece of Zealot's Robes",
						new QuestRequirement(QuestHelperQuest.SHADES_OF_MORTTON, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3481, 3320, 0),
						"Equip a Full Set of Zealot's Robes",
						new QuestRequirement(QuestHelperQuest.SHADES_OF_MORTTON, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3481, 3320, 0),
						"Open a Gold Chest",
						new QuestRequirement(QuestHelperQuest.SHADES_OF_MORTTON, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3059, 3379, 0),
						"Equip a Full set of Golden Prospector",
						new SkillRequirement(Skill.MINING, 30, false)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3481, 3320, 0),
						"Equip a Full set of Swampbark armour",
						new QuestRequirement(QuestHelperQuest.SHADES_OF_MORTTON, QuestState.FINISHED)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Max out 10 Fragments",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Activate 2 Set Effects",
						new CombatLevelRequirement(100)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Equip a Piece of Torva Armour",
						new CombatLevelRequirement(110)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Equip an Ancient godsword",
						new CombatLevelRequirement(110)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Equip a Zaryte Crossbow",
						new CombatLevelRequirement(110)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Equip some Zaryte Vambraces",
						new CombatLevelRequirement(110)),
				50
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Receive 5 Chambers of Xeric Uniques",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Receive 10 Chambers of Xeric Uniques",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Activate an Imbued Heart",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1311, 3817, 0),
						"Equip Ferocious Gloves",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip a Dragon Hunter Lance",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Kourend and Kebos Elite Diary Tasks",
						new QuestRequirement(QuestHelperQuest.KOUREND_ELITE, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Open 250 Grubby Chests",
						new SkillRequirement(Skill.THIEVING, 57, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Open 500 Grubby Chests",
						new SkillRequirement(Skill.THIEVING, 57, false)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1360, 3631, 0),
						"Equip a Fish Sack"),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip a Dragon Hunter Crossbow",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip a Twisted Buckler",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip a Dinh's Bulwark",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip any Ancestral piece",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip a pair of Dragon Claws",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Recolour a piece of Ancestral",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2640, 3699, 0),
						"Equip a Bonecrusher necklace",
						new CombatLevelRequirement(110),
						new QuestRequirement(QuestHelperQuest.DRAGON_SLAYER_II, QuestState.FINISHED)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"All Hard Combat Achievements",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"50 Elite Combat Achievement",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"75 Elite Combat Achievement",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"20 Master Combat Achievement",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"30 Master Combat Achievement",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"50 Master Combat Achievement",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"1 Grandmaster Combat Achievement",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"10 Grandmaster Combat Achievement",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"20 Grandmaster Combat Achievement",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"30 Grandmaster Combat Achievement",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Attach a Sanguine ornament kit to the Scythe of Vitur",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3650, 3219, 0),
						"Attach a Holy ornament kit to the Scythe of Vitur",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2852, 3163, 0),
						"Metamorph Lil' Zik",
						new CombatLevelRequirement(120)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(3481, 3320, 0),
						"Equip a Full set of Bloodbark armour",
						new QuestRequirement(QuestHelperQuest.SHADES_OF_MORTTON, QuestState.FINISHED),
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Activate 3 Set Effects",
						new CombatLevelRequirement(100)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(2921, 3742, 0),
						"Equip a Full Set of Torva Armour",
						new CombatLevelRequirement(110)),
				125
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip a Twisted Bow",
						new CombatLevelRequirement(110)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip an Elder Maul",
						new CombatLevelRequirement(110)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip a Kodai Wand",
						new CombatLevelRequirement(110)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Receive All Chambers of Xeric Uniques",
						new CombatLevelRequirement(110)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Metamorphise the Olmlet",
						new CombatLevelRequirement(110)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1360, 3631, 0),
						"Equip a Golden Tench"),
				250
		);
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1233, 3567, 0),
						"Equip a full set of Ancestral",
						new CombatLevelRequirement(110)),
				250
		);
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"All Elite Combat Achievements",
						new CombatLevelRequirement(120)),
				250
		);

		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"75 Master Combat Achievement",
						new CombatLevelRequirement(120)),
				250
		);
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"All Master Combat Achievements",
						new CombatLevelRequirement(120)),
				250
		);
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"50 Grandmaster Combat Achievement",
						new CombatLevelRequirement(120)),
				250
		);
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"75 Grandmaster Combat Achievement",
						new CombatLevelRequirement(120)),
				250
		);
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"All Grandmaster Combat Achievements",
						new CombatLevelRequirement(120)),
				250
		);
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						"Max out all Fragments",
						new CombatLevelRequirement(120)),
				250
		);
		addLeagueTask(
				new DetailedQuestStep(shatteredClass,
						new WorldPoint(1702, 3582, 0),
						"Equip a Sarachnis Cudgel",
						new CombatLevelRequirement(90)),
				50
		);
	}
	public void setupSteps()
	{
		// all tasks are setup
		if (LeaguesTasks.size() != 0)
		{
			return;
		}

		PreviousLeagueTasks previousTaskHelper = new PreviousLeagueTasks(shatteredClass);
		quest = QuestHelperQuest.SHATTERED_RELICS;

		setupShatteredRelicsSteps();
		previousTaskHelper.setupTrailblazerMissedSteps();

	}

	@Override
	public List<PanelDetails> getPanels()
	{
		return LeaguesTasks;
	}
}
