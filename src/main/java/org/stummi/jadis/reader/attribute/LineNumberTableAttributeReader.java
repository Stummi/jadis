package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.LineNumberTableAttribute;
import org.stummi.jadis.element.attribute.LineNumberTableEntry;
import org.stummi.jadis.reader.ElementReader;

public class LineNumberTableAttributeReader implements
		ElementReader<LineNumberTableAttribute> {

	@Override
	public LineNumberTableAttribute readElement(JadisInputStream jadis)
			throws IOException {
		return new LineNumberTableAttribute(
				jadis.readElementList(LineNumberTableEntry.class));
	}

}
