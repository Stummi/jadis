package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.AnnotationsEntry;
import org.stummi.jadis.element.attribute.AnnotationsAttribute;
import org.stummi.jadis.reader.ElementReader;

public class AnnotationsAttributeReader implements
		ElementReader<AnnotationsAttribute> {

	@Override
	public AnnotationsAttribute readElement(JadisInputStream jadis)
			throws IOException {
		return new AnnotationsAttribute(
				jadis.readElementList(AnnotationsEntry.class));

	}

}
