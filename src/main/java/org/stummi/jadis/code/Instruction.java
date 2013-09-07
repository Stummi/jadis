package org.stummi.jadis.code;

import lombok.Data;

@Data
public class Instruction {
	private Integer[] args;
	private Mnemonic mnemonic;

	public Instruction(Mnemonic mnemonic, Integer... args) {
		this.mnemonic = mnemonic;
		this.args = args;
	}
}
