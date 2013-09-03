package org.stummi.jadis.reader;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.ClassVersion;

public class ClassVersionReader implements ElementReader<ClassVersion> {

	@Override
	public ClassVersion readElement(JadisInputStream jadis) throws IOException {
		int minor = jadis.readShort();
		int major = jadis.readShort();
		return new ClassVersion(major, minor);
	}

}
