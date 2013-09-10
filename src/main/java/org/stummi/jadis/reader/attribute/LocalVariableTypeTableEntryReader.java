package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.LocalVariableTypeTableEntry;
import org.stummi.jadis.reader.ElementReader;

public class LocalVariableTypeTableEntryReader implements
		ElementReader<LocalVariableTypeTableEntry> {

	@Override
	public LocalVariableTypeTableEntry readElement(JadisInputStream jadis)
			throws IOException {
		int startPosition = jadis.readUnsignedShort();
		int length = jadis.readUnsignedShort();
		int nameIndex = jadis.readUnsignedShort();
		int descriptorIndex = jadis.readUnsignedShort();
		int index = jadis.readUnsignedShort();
		return new LocalVariableTypeTableEntry(startPosition, length,
				nameIndex,
				descriptorIndex, index);
	}

}
