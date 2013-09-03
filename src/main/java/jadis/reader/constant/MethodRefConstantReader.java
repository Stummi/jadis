package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.MethodRefConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

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
