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

package com.questhelper.requirements.var;

import com.questhelper.requirements.var.VarbitRequirement;
import com.questhelper.requirements.util.Operation;
import java.math.BigInteger;
import java.util.Locale;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Varbits;

/**
 * Checks if a player's varbit value is meets the required value as determined by the
 * {@link Operation}
 */
@Getter
public class ImportantVarbitRequirement extends VarbitRequirement
{
	/**
	 * Check if the player's varbit value meets the required level using the given
	 * {@link Operation}.
	 *
	 * @param varbitID      the {@link Varbits} id to use
	 * @param operation     the {@link Operation} to check with
	 * @param requiredValue the required varbit value to pass this requirement
	 * @param displayText   the display text
	 */
	public ImportantVarbitRequirement(int varbitID, Operation operation, int requiredValue, String displayText)
	{
		super(varbitID, operation, requiredValue, displayText);
	}

	/**
	 * Check if the player's {@link Varbits} value meets the required level using the given
	 * {@link Operation}.
	 *
	 * @param varbit        the {@link Varbits} to check
	 * @param operation     the {@link Operation} to check with
	 * @param requiredValue the required varbit value to pass this requirement
	 * @param displayText   the display text
	 */
	public ImportantVarbitRequirement(Varbits varbit, Operation operation, int requiredValue, String displayText)
	{
		super(varbit, operation, requiredValue, displayText);
	}

	/**
	 * Check if a specified varbit value is exactly the supplied value.
	 *
	 * @param varbitID the varbit id
	 * @param value    the value the varbit should be
	 */
	public ImportantVarbitRequirement(int varbitID, int value)
	{
		super(varbitID, value);
	}

	/**
	 * Check the supplied varbit's value using the given {@link Operation}
	 *
	 * @param varbitID  the varbit id
	 * @param value     the value it should be
	 * @param operation the operation to check with
	 */
	public ImportantVarbitRequirement(int varbitID, int value, Operation operation)
	{
		super(varbitID, value, operation);
	}

	/**
	 * Checks if a specified varbit value has a specific bit position set.
	 *
	 * @param varbitID    the varbit id
	 * @param bitIsSet    if the bit should be set
	 * @param bitPosition the position of the bit in question
	 */
	public ImportantVarbitRequirement(int varbitID, boolean bitIsSet, int bitPosition)
	{
		super(varbitID, bitIsSet, bitPosition);
	}

	// ALWAYS require
	@Override
	public Integer GetRequiredID()
	{
		return 0;
	}
}
