package org.stummi.jadis;

import java.io.ByteArrayInputStream;

public class PositionByteArrayInputStream extends ByteArrayInputStream {

	public PositionByteArrayInputStream(byte[] buf, int offset, int length) {
		super(buf, offset, length);
	}

	public PositionByteArrayInputStream(byte[] buf) {
		super(buf);
	}

	public int getPos() {
		return pos;
	}
}
