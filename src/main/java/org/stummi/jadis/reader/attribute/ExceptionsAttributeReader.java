package org.stummi.jadis.reader.attribute;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.ExceptionsAttribute;
import org.stummi.jadis.reader.ElementReader;

public class ExceptionsAttributeReader implements
		ElementReader<ExceptionsAttribute> {

	@Override
	public ExceptionsAttribute readElement(JadisInputStream jadis)
			throws IOException {
		int len = jadis.readShort();
		List<Integer> exceptionRefs = new LinkedList<>();
		for (int idx = 0; idx < len; idx++) {
			exceptionRefs.add(jadis.readUnsignedShort());
		}
		return new ExceptionsAttribute(exceptionRefs);
	}

}
