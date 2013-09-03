package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.ClassConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

public class ClassConstantReader implements ElementReader<ClassConstant> {

	@Override
	public ClassConstant readElement(JadisInputStream jadis) throws IOException {
		return new ClassConstant(jadis.readShort());
	}

}
