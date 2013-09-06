package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.EnumConstAnnotationValue;
import org.stummi.jadis.reader.ElementReader;

public class EnumConstantAnnotationValueReader implements
		ElementReader<EnumConstAnnotationValue> {

	@Override
	public EnumConstAnnotationValue readElement(JadisInputStream jadis)
			throws IOException {
		int typeNameRef = jadis.readUnsignedShort();
		int valueNameRef = jadis.readUnsignedShort();
		return new EnumConstAnnotationValue(typeNameRef, valueNameRef);
	}

}
