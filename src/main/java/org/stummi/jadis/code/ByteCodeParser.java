package org.stummi.jadis.code;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.stummi.jadis.PositionByteArrayInputStream;
import org.stummi.jadis.code.arg.InstructionArgument;

public class ByteCodeParser {
	public ByteCode parse(byte[] code) throws IOException {
		PositionByteArrayInputStream bais = new PositionByteArrayInputStream(
				code);
		DataInputStream dais = new DataInputStream(bais);
		int opCode;
		List<Instruction> instructions = new ArrayList<>();
		boolean wide = false;
		while ((opCode = bais.read()) >= 0) {
			int pos = bais.getPos() - 1;
			Mnemonic mn = Mnemonic.forOpCode(opCode, wide);
			if (mn == null) {
				throw new IOException(
						String.format("unknown %s opCode: 0x%02X",
								wide ? "wide" : "", opCode));
			}

			if (mn == Mnemonic.WIDE) {
				wide = true;
				continue;
			}
			wide = false;

			MnemonicParam[] mnparams = mn.getParams();
			int paramCount = mnparams.length;
			InstructionArgument[] params = new InstructionArgument[paramCount];
			for (int idx = 0; idx < params.length; idx++) {
				params[idx] = mnparams[idx].readFromDataInputStream(
						bais.getPos(), dais);
			}
			Instruction i = new Instruction(pos, mn, params);
			instructions.add(i);
		}
		return new ByteCode(instructions);
	}
}
