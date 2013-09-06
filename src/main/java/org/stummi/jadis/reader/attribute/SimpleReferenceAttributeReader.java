package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.SimpleReferenceAttribute;
import org.stummi.jadis.reader.ElementReader;

public class SimpleReferenceAttributeReader implements
		ElementReader<SimpleReferenceAttribute> {

	@Override
	public SimpleReferenceAttribute readElement(JadisInputStream jadis)
			throws IOException {
		return new SimpleReferenceAttribute(jadis.readUnsignedShort());
	}

}
