/*
 *
 *  * Copyright (c) 2021, Zoinkwiz <https://github.com/Zoinkwiz>
 *  * All rights reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are permitted provided that the following conditions are met:
 *  *
 *  * 1. Redistributions of source code must retain the above copyright notice, this
 *  *    list of conditions and the following disclaimer.
 *  * 2. Redistributions in binary form must reproduce the above copyright notice,
 *  *    this list of conditions and the following disclaimer in the documentation
 *  *    and/or other materials provided with the distribution.
 *  *
 *  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package com.questhelper.requirements.player;

import com.questhelper.requirements.AbstractRequirement;
import com.questhelper.requirements.util.Operation;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;

import java.util.logging.Level;

/**
 * Requirement that checks if a player meets a certain skill level.
 */
@Getter
public class SkillRequirement extends AbstractRequirement
{
	private final SkillOther SkillOtherFlags;
	private final Skill skill;
	private final int requiredLevel;
	private final Operation operation;
	private boolean canBeBoosted;
	private String displayText;

	@Override
	public Skill GetSkillAssociation()
	{
		return skill;
	}

	/**
	 * Check if a player has a certain skill level
	 *
	 * @param skill the {@link Skill} to check
	 * @param requiredLevel the required level for this Requirement to pass
	 * @param operation what type of check we're making on the stat
	 */
	public SkillRequirement(Skill skill, int requiredLevel, Operation operation)
	{
		this.skill = skill;
		this.requiredLevel = requiredLevel;
		this.displayText = getDisplayText();
		this.operation = operation;
		shouldCountForFilter = true;
		SkillOtherFlags = SkillOther.NONE;
	}

	/**
	 * Check if a player has a certain skill level
	 *
	 * @param skill the {@link Skill} to check
	 * @param requiredLevel the required level for this Requirement to pass
	 */
	public SkillRequirement(Skill skill, int requiredLevel)
	{
		this(skill, requiredLevel, Operation.GREATER_EQUAL);
	}

	// Handle all/any skill reqs
	public SkillRequirement(SkillOther InskillOther, int requiredLevel, boolean canBeBoosted)
	{
		SkillOtherFlags = InskillOther;

		this.skill = Skill.DEFENCE; // Dummy
		this.requiredLevel = requiredLevel;
		this.displayText = getDisplayText();
		this.operation = Operation.GREATER_EQUAL;
		this.canBeBoosted = canBeBoosted;
		shouldCountForFilter = true;
	}

	/**
	 * Check if a player has a certain skill level
	 *
	 * @param skill the {@link Skill} to check
	 * @param requiredLevel the required level for this Requirement to pass
	 * @param canBeBoosted if the skill can be boosted to meet this requirement
	 */
	public SkillRequirement(Skill skill, int requiredLevel, boolean canBeBoosted)
	{
		this(skill, requiredLevel);
		this.canBeBoosted = canBeBoosted;
	}

	/**
	 * Check if a player has a certain skill level
	 *
	 * @param skill the {@link Skill} to check
	 * @param requiredLevel the required level for this Requirement to pass
	 * @param canBeBoosted if this skill check can be boosted to meet this requirement
	 * @param displayText the display text
	 */
	public SkillRequirement(Skill skill, int requiredLevel, boolean canBeBoosted, String displayText)
	{
		this(skill, requiredLevel, canBeBoosted);
		this.displayText = displayText;
	}


	private int GetAmountOfSkillsAwayFromReqSkill(Client client, Skill skillToCheck, int OutResult[])
	{
		int skillLevel = canBeBoosted ? Math.max(client.getBoostedSkillLevel(skillToCheck), client.getRealSkillLevel(skillToCheck)) :
				client.getRealSkillLevel(skillToCheck);

		int LevelDiff = 0;
		if (skillLevel < requiredLevel)
		{
			LevelDiff = requiredLevel - skillLevel;
		}

		if (LevelDiff < OutResult[0])
		{
			OutResult[0] = LevelDiff;
		}

		return LevelDiff;
	}

	private boolean checkSkill(Client client, Skill skillToCheck, boolean OutResult[])
	{
		int skillLevel = canBeBoosted ? Math.max(client.getBoostedSkillLevel(skillToCheck), client.getRealSkillLevel(skillToCheck)) :
				client.getRealSkillLevel(skillToCheck);
		if (OutResult[0] != false)
		{
			OutResult[0] = skillLevel >= requiredLevel;
		}

		return skillLevel >= requiredLevel;
	}

	// Returns the amount of skills we are away from the req
	@Override
	public int GetAmountOfSkillsAwayFromReq(Client client)
	{
		int LowestAmount[] = { 10000 };
		if (SkillOtherFlags == SkillOther.ANY_SKILLS)
		{
			// find lowest amount
			//GetAmountOfSkillsAwayFromReqSkill(client, Skill.HITPOINTS, LowestAmount);// do not include hitpoints
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.AGILITY, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.ATTACK, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.CONSTRUCTION, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.COOKING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.CRAFTING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.DEFENCE, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.FARMING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.FIREMAKING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.FISHING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.FLETCHING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.HERBLORE, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.HUNTER, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.MAGIC, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.MINING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.WOODCUTTING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.THIEVING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.STRENGTH, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.SMITHING, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.SLAYER, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.RANGED, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.PRAYER, LowestAmount);
			GetAmountOfSkillsAwayFromReqSkill(client, Skill.RUNECRAFT, LowestAmount);
		}
		else if (SkillOtherFlags == SkillOther.ALL_SKILLS)
		{
			// Count all the levels required
			int Accumulator = 0;
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.HITPOINTS, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.AGILITY, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.ATTACK, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.CONSTRUCTION, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.COOKING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.CRAFTING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.DEFENCE, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.FARMING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.FIREMAKING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.FISHING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.FLETCHING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.HERBLORE, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.HUNTER, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.MAGIC, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.MINING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.WOODCUTTING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.THIEVING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.STRENGTH, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.SMITHING, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.SLAYER, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.RANGED, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.PRAYER, LowestAmount);
			Accumulator = Accumulator + GetAmountOfSkillsAwayFromReqSkill(client, Skill.RUNECRAFT, LowestAmount);

			return Accumulator;
		}
		else
		{
			GetAmountOfSkillsAwayFromReqSkill(client, skill, LowestAmount);
		}

		return LowestAmount[0];
	}

	@Override
	public boolean check(Client client)
	{
		boolean bCheckResult[] = { true };
		if (SkillOtherFlags == SkillOther.ANY_SKILLS)
		{
			//checkSkill(client, Skill.HITPOINTS, bCheckResult);// do not include hitpoints
			boolean AccumulatorCheck = false;
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.AGILITY, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.ATTACK, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.CONSTRUCTION, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.COOKING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.CRAFTING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.DEFENCE, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.FARMING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.FIREMAKING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.FISHING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.FLETCHING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.HERBLORE, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.HUNTER, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.MAGIC, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.MINING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.WOODCUTTING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.THIEVING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.STRENGTH, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.SMITHING, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.SLAYER, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.RANGED, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.PRAYER, bCheckResult);
			AccumulatorCheck = AccumulatorCheck || checkSkill(client, Skill.RUNECRAFT, bCheckResult);
			bCheckResult[0] = AccumulatorCheck;
		}
		else if (SkillOtherFlags == SkillOther.ALL_SKILLS)
		{
			checkSkill(client, Skill.HITPOINTS, bCheckResult);// do not include hitpoints
			checkSkill(client, Skill.AGILITY, bCheckResult);
			checkSkill(client, Skill.ATTACK, bCheckResult);
			checkSkill(client, Skill.CONSTRUCTION, bCheckResult);
			checkSkill(client, Skill.COOKING, bCheckResult);
			checkSkill(client, Skill.CRAFTING, bCheckResult);
			checkSkill(client, Skill.DEFENCE, bCheckResult);
			checkSkill(client, Skill.FARMING, bCheckResult);
			checkSkill(client, Skill.FIREMAKING, bCheckResult);
			checkSkill(client, Skill.FISHING, bCheckResult);
			checkSkill(client, Skill.FLETCHING, bCheckResult);
			checkSkill(client, Skill.HERBLORE, bCheckResult);
			checkSkill(client, Skill.HUNTER, bCheckResult);
			checkSkill(client, Skill.MAGIC, bCheckResult);
			checkSkill(client, Skill.MINING, bCheckResult);
			checkSkill(client, Skill.WOODCUTTING, bCheckResult);
			checkSkill(client, Skill.THIEVING, bCheckResult);
			checkSkill(client, Skill.STRENGTH, bCheckResult);
			checkSkill(client, Skill.SMITHING, bCheckResult);
			checkSkill(client, Skill.SLAYER, bCheckResult);
			checkSkill(client, Skill.RANGED, bCheckResult);
			checkSkill(client, Skill.PRAYER, bCheckResult);
			checkSkill(client, Skill.RUNECRAFT, bCheckResult);

		}
		else
		{
			bCheckResult[0] = checkSkill(client, skill, bCheckResult);
		}

		return bCheckResult[0];
	}

	@Override
	public String getDisplayText()
	{
		String returnText;
		if (displayText != null)
		{
			returnText = displayText;
		}
		else
		{
			returnText = requiredLevel + " " + skill.getName();
		}

		if (canBeBoosted)
		{
			returnText += " (boostable)";
		}

		return returnText;
	}

	// Count a spellbook requirement as needing an item
	@Override
	public Integer GetRequiredID()
	{
		return 3;
	}

}
