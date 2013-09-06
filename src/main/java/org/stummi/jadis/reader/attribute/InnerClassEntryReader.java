package org.stummi.jadis.reader.attribute;

import java.io.IOException;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.accessflags.AccessFlagContext;
import org.stummi.jadis.element.attribute.InnerClassesEntry;
import org.stummi.jadis.reader.ElementReader;

public class InnerClassEntryReader implements ElementReader<InnerClassesEntry> {

	@Override
	public InnerClassesEntry readElement(JadisInputStream jadis)
			throws IOException {
		int innerClassInfoIndex = jadis.readUnsignedShort();
		int outerClassInfoIndex = jadis.readUnsignedShort();
		int innerNameIndex = jadis.readUnsignedShort();
		List<AccessFlag> innerClassAccessFlags = jadis
				.readAccessFlags(AccessFlagContext.NESTED);

		return new InnerClassesEntry(innerClassInfoIndex, outerClassInfoIndex,
				innerNameIndex, innerClassAccessFlags);
	}

}
