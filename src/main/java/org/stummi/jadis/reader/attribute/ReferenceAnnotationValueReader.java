package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.ReferenceAnnotationValue;
import org.stummi.jadis.reader.ElementReader;

public class ReferenceAnnotationValueReader implements
		ElementReader<ReferenceAnnotationValue> {

	@Override
	public ReferenceAnnotationValue readElement(JadisInputStream jadis)
			throws IOException {
		int reference = jadis.readUnsignedShort();
		return new ReferenceAnnotationValue(reference);
	}

}
