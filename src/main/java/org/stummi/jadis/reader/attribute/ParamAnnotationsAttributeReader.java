package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.AnnotationsAttribute;
import org.stummi.jadis.element.attribute.ParamAnnotationsAttribute;
import org.stummi.jadis.reader.ElementReader;

public class ParamAnnotationsAttributeReader implements
		ElementReader<ParamAnnotationsAttribute> {

	@Override
	public ParamAnnotationsAttribute readElement(JadisInputStream jadis)
			throws IOException {
		int count = jadis.readUnsignedByte();

		AnnotationsAttribute[] annotations = new AnnotationsAttribute[count];
		for (int idx = 0; idx < count; idx++) {
			annotations[idx] = jadis.readElement(AnnotationsAttribute.class);
		}
		return new ParamAnnotationsAttribute(annotations);

	}

}
