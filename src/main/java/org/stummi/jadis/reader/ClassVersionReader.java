package org.stummi.jadis.reader;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.ClassVersion;

public class ClassVersionReader implements ElementReader<ClassVersion> {

	@Override
	public ClassVersion readElement(JadisInputStream jadis) throws IOException {
		int minor = jadis.readUnsignedShort();
		int major = jadis.readUnsignedShort();
		return new ClassVersion(major, minor);
	}

}
