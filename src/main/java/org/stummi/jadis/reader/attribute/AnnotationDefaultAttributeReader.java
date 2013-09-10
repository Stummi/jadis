package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.AnnotationDefault;
import org.stummi.jadis.element.attribute.AnnotationElementValue;
import org.stummi.jadis.reader.ElementReader;

public class AnnotationDefaultAttributeReader implements
		ElementReader<AnnotationDefault> {

	@Override
	public AnnotationDefault readElement(JadisInputStream jadis)
			throws IOException {
		return new AnnotationDefault(
				jadis.readElement(AnnotationElementValue.class));
	}

}
