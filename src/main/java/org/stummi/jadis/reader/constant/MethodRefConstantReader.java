package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.MethodRefConstant;
import org.stummi.jadis.reader.ElementReader;

public class MethodRefConstantReader implements
		ElementReader<MethodRefConstant> {

	@Override
	public MethodRefConstant readElement(JadisInputStream jadis)
			throws IOException {
		short classIndex = jadis.readShort();
		short nameAndType = jadis.readShort();
		return new MethodRefConstant(classIndex, nameAndType);
	}

}
