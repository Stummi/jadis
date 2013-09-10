package org.stummi.jadis.code.arg;

import java.io.DataInputStream;
import java.io.IOException;

import lombok.Data;

@Data
public class LookupSwitchInstructionArgument implements InstructionArgument {

	private int defaultOffset;
	private int npairs;
	private LookupPair[] lookupPairs;

	@Override
	public void readFromDataInputStream(int position, DataInputStream dis)
			throws IOException {
		defaultOffset = dis.readInt();
		npairs = dis.readInt();
		lookupPairs = new LookupPair[npairs];
		for (int idx = 0; idx < npairs; idx++) {
			int match = dis.readInt();
			int offset = dis.readInt();
			lookupPairs[idx] = new LookupPair(match, offset);
		}
	}

}
