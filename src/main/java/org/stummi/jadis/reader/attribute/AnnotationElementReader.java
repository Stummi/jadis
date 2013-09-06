package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.AnnotationElement;
import org.stummi.jadis.element.attribute.AnnotationElementValue;
import org.stummi.jadis.reader.ElementReader;

public class AnnotationElementReader implements
		ElementReader<AnnotationElement> {

	@Override
	public AnnotationElement readElement(JadisInputStream jadis)
			throws IOException {
		int elementNameRef = jadis.readUnsignedShort();
		AnnotationElementValue value = jadis
				.readElement(AnnotationElementValue.class);
		return new AnnotationElement(elementNameRef, value);
	}

}
