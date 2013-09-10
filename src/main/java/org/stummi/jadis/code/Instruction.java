package org.stummi.jadis.code;

import lombok.Data;

import org.stummi.jadis.code.arg.InstructionArgument;

@Data
public class Instruction {
	private Mnemonic mnemonic;
	private InstructionArgument[] args;
	private int bytePos;

	public Instruction(int bytePos, Mnemonic mnemonic,
			InstructionArgument... args) {
		this.mnemonic = mnemonic;
		this.bytePos = bytePos;
		this.args = args;
	}
}
