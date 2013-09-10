package org.stummi.jadis.code.arg;

import java.io.DataInputStream;
import java.io.IOException;

public interface InstructionArgument {
	void readFromDataInputStream(int position, DataInputStream dis)
			throws IOException;
}
