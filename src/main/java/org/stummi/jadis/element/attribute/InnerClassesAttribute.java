package org.stummi.jadis.element.attribute;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.accessflags.AccessFlagContext;

@Data
@EqualsAndHashCode(callSuper = true)
public class InnerClassesAttribute extends AbstractAttribute {
	private List<InnerClassEntry> entries;

	@Override
	protected void readAttributeData(DataInputStream dis) throws IOException {
		int size = dis.readUnsignedShort();
		entries = new ArrayList<>();
		for (int idx = 0; idx < size; idx++) {
			int innerClassInfoIndex = dis.readUnsignedShort();
			int outerClassInfoIndex = dis.readUnsignedShort();
			int innerNameIndex = dis.readUnsignedShort();
			List<AccessFlag> innerClassAccessFlags = AccessFlagContext.NESTED
					.bitsToFlags(dis.readUnsignedShort());
			entries.add(new InnerClassEntry(innerClassInfoIndex,
					outerClassInfoIndex, innerNameIndex, innerClassAccessFlags));
		}
	}

}
