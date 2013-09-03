package jadis.reader;

import jadis.JadisInputStream;
import jadis.element.ConstantPool;
import jadis.element.constant.Constant;
import jadis.element.constant.ConstantType;

import java.io.IOException;

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
