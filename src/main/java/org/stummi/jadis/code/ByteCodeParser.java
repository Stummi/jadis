package org.stummi.jadis.code;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ByteCodeParser {
	public ByteCode parse(byte[] code) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(code);
		DataInputStream dais = new DataInputStream(bais);
		int opCode;
		List<Instruction> instructions = new ArrayList<>();
		while ((opCode = bais.read()) >= 0) {
			Mnemonic mn = Mnemonic.forOpCode(opCode);
			if (mn == null) {
				throw new IOException(String.format("unknown opCode: 0x%02X",
						opCode));
			}
			MnemonicParam[] mnparams = mn.getParams();
			int paramCount = mnparams.length;
			Integer[] params = new Integer[paramCount];
			for (int idx = 0; idx < params.length; idx++) {
				params[idx] = mnparams[idx].readFromDataInputStream(dais);
			}
			Instruction i = new Instruction(mn, params);
			instructions.add(i);
		}
		return new ByteCode(instructions);
	}
}
