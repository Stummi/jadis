package jadis.reader;

import jadis.JadisInputStream;
import jadis.element.ClassVersion;

import java.io.IOException;

public class ClassVersionReader implements ElementReader<ClassVersion> {

	@Override
	public ClassVersion readElement(JadisInputStream jadis) throws IOException {
		int minor = jadis.readShort();
		int major = jadis.readShort();
		return new ClassVersion(major, minor);
	}

}
