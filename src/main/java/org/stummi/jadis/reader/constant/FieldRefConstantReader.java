package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.FieldRefConstant;
import org.stummi.jadis.reader.ElementReader;

public class FieldRefConstantReader implements ElementReader<FieldRefConstant> {

	@Override
	public FieldRefConstant readElement(JadisInputStream jadis)
			throws IOException {
		short classIndex = jadis.readShort();
		short nameAndTypeIndex = jadis.readShort();
		return new FieldRefConstant(classIndex, nameAndTypeIndex);
	}

}
