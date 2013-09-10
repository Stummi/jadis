package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.LineNumberTableEntry;
import org.stummi.jadis.reader.ElementReader;

public class LineNumberTableEntryReader implements
		ElementReader<LineNumberTableEntry> {

	@Override
	public LineNumberTableEntry readElement(JadisInputStream jadis)
			throws IOException {
		int byteIndex = jadis.readUnsignedShort();
		int lineNumber = jadis.readUnsignedShort();
		return new LineNumberTableEntry(byteIndex, lineNumber);
	}

}
