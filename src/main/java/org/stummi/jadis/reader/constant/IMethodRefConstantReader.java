package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.IMethodRefConstant;
import org.stummi.jadis.reader.ElementReader;

public class IMethodRefConstantReader implements
		ElementReader<IMethodRefConstant> {

	@Override
	public IMethodRefConstant readElement(JadisInputStream jadis)
			throws IOException {
		int classRef = jadis.readUnsignedShort();
		int nameAndType = jadis.readUnsignedShort();
		return new IMethodRefConstant(classRef, nameAndType);
	}

}
