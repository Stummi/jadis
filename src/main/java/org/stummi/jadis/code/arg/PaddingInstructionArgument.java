package org.stummi.jadis.code.arg;

import java.io.DataInputStream;
import java.io.IOException;

public class PaddingInstructionArgument implements InstructionArgument {

	@Override
	public void readFromDataInputStream(int position, DataInputStream dis)
			throws IOException {
		int dif = position % 4;
		if (dif > 0) {
			dis.skip(4 - dif);
		}

	}

}
