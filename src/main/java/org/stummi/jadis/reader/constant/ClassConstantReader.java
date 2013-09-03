package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.ClassConstant;
import org.stummi.jadis.reader.ElementReader;

public class ClassConstantReader implements ElementReader<ClassConstant> {

	@Override
	public ClassConstant readElement(JadisInputStream jadis) throws IOException {
		return new ClassConstant(jadis.readShort());
	}

}
