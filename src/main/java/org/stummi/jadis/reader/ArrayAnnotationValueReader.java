package org.stummi.jadis.reader;

import java.io.IOException;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.AnnotationElementValue;
import org.stummi.jadis.element.attribute.ArrayAnnotationValue;

public class ArrayAnnotationValueReader implements
		ElementReader<ArrayAnnotationValue> {

	@Override
	public ArrayAnnotationValue readElement(JadisInputStream jadis)
			throws IOException {
		List<AnnotationElementValue> elements = jadis
				.readElementList(AnnotationElementValue.class);
		return new ArrayAnnotationValue(elements);
	}

}
