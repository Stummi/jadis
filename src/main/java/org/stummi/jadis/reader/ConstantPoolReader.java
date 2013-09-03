package org.stummi.jadis.reader;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.constant.Constant;
import org.stummi.jadis.element.constant.ConstantType;

public class ConstantPoolReader implements ElementReader<ConstantPool> {

	@Override
	public ConstantPool readElement(JadisInputStream jadis) throws IOException {
		int poolsize = jadis.readShort();
		Constant[] constants = new Constant[poolsize];
		int poolidx = 1;
		while (poolidx < poolsize) {
			int tag = jadis.readUnsignedByte();
			ConstantType type = ConstantType.forId(tag);
			Constant c = jadis.readElement(type.getConstantClass());
			constants[poolidx] = c;
			poolidx += type.getSize();
		}

		return new ConstantPool(constants);
	}

}
