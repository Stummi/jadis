package org.stummi.jadis.code.arg;

import java.io.DataInputStream;
import java.io.IOException;

public class S32InstructionArgument extends NumericInstructionArgument {
	@Override
	public void readFromDataInputStream(int position, DataInputStream dis)
			throws IOException {
		setValue(dis.readInt());
	}
}
