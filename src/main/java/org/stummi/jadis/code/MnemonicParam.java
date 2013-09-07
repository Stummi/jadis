package org.stummi.jadis.code;

import java.io.DataInputStream;
import java.io.IOException;

public enum MnemonicParam {
	U8 {
		@Override
		public int readFromDataInputStream(DataInputStream dis)
				throws IOException {
			return dis.readUnsignedByte();
		}
	},
	U16 {
		@Override
		public int readFromDataInputStream(DataInputStream dis)
				throws IOException {
			return dis.readUnsignedShort();
		}
	},
	S8 {
		@Override
		public int readFromDataInputStream(DataInputStream dis)
				throws IOException {
			return dis.readByte();
		}
	},
	S16 {

		@Override
		public int readFromDataInputStream(DataInputStream dis)
				throws IOException {
			return dis.readShort();
		}
	},
	S32 {
		@Override
		public int readFromDataInputStream(DataInputStream dis)
				throws IOException {
			return dis.readInt();
		}
	},
	CONST_REF {
		@Override
		public int readFromDataInputStream(DataInputStream dis)
				throws IOException {
			return dis.readUnsignedShort();
		}
	},
	NUL {
		@Override
		public int readFromDataInputStream(DataInputStream dis)
				throws IOException {
			byte b = dis.readByte();
			if (b != 0) {
				throw new IOException("read " + b + " instead of expected 0");
			}
			return 0;
		}
	};

	public abstract int readFromDataInputStream(DataInputStream dis)
			throws IOException;
}
