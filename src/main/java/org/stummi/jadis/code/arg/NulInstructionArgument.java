package org.stummi.jadis.code.arg;

import java.io.DataInputStream;
import java.io.IOException;

public class NulInstructionArgument implements InstructionArgument {

	@Override
	public void readFromDataInputStream(int position, DataInputStream dis)
			throws IOException {
		if (dis.readByte() != 0) {
			throw new IOException("expected zero on this position");
		}

	}

}
