package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.InnerClassesEntry;
import org.stummi.jadis.element.attribute.InnerClassesAttribute;
import org.stummi.jadis.reader.ElementReader;

public class InnerClassesAttributeReader implements
		ElementReader<InnerClassesAttribute> {

	@Override
	public InnerClassesAttribute readElement(JadisInputStream jadis)
			throws IOException {
		return new InnerClassesAttribute(
				jadis.readElementList(InnerClassesEntry.class));
	}
}
