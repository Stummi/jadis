package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.NameAndTypeConstant;
import org.stummi.jadis.reader.ElementReader;

public class NameAndTypeConstantReader implements
		ElementReader<NameAndTypeConstant> {

	@Override
	public NameAndTypeConstant readElement(JadisInputStream jadis)
			throws IOException {
		short nameIndex = jadis.readShort();
		short descriptorIndex = jadis.readShort();
		return new NameAndTypeConstant(nameIndex, descriptorIndex);
	}

}
