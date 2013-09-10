package org.stummi.jadis.code.arg;

import lombok.Data;

@Data
public abstract class NumericInstructionArgument implements InstructionArgument {
	private int value;
}
