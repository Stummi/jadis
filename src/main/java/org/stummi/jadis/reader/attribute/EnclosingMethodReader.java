package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.EnclosingMethod;
import org.stummi.jadis.reader.ElementReader;

public class EnclosingMethodReader implements ElementReader<EnclosingMethod> {

	@Override
	public EnclosingMethod readElement(JadisInputStream jadis)
			throws IOException {
		int classRef = jadis.readUnsignedShort();
		int methodRef = jadis.readUnsignedShort();
		return new EnclosingMethod(classRef, methodRef);
	}

}
