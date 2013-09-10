package org.stummi.jadis.code.arg;

import java.io.DataInputStream;
import java.io.IOException;

import lombok.Data;

@Data
public class TableSwitchInstructionArgument implements InstructionArgument {

	private int defaultOffset;
	private int low;
	private int high;
	private int[] offsets;

	@Override
	public void readFromDataInputStream(int position, DataInputStream dis)
			throws IOException {
		defaultOffset = dis.readInt();
		low = dis.readInt();
		high = dis.readInt();

		int c = high - low + 1;
		offsets = new int[c];
		for (int idx = 0; idx < c; idx++) {
			offsets[idx] = dis.readInt();
		}

	}

}
