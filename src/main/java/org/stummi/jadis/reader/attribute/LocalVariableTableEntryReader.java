package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.LocalVariableTableEntry;
import org.stummi.jadis.reader.ElementReader;

public class LocalVariableTableEntryReader implements
		ElementReader<LocalVariableTableEntry> {

	@Override
	public LocalVariableTableEntry readElement(JadisInputStream jadis)
			throws IOException {
		int startPosition = jadis.readUnsignedShort();
		int length = jadis.readUnsignedShort();
		int nameIndex = jadis.readUnsignedShort();
		int descriptorIndex = jadis.readUnsignedShort();
		int index = jadis.readUnsignedShort();
		return new LocalVariableTableEntry(startPosition, length, nameIndex,
				descriptorIndex, index);
	}

}
