package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.IMethodRefConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

public class IMethodRefConstantReader implements
		ElementReader<IMethodRefConstant> {

	@Override
	public IMethodRefConstant readElement(JadisInputStream jadis)
			throws IOException {
		short classIndex = jadis.readShort();
		short nameAndType = jadis.readShort();
		return new IMethodRefConstant(classIndex, nameAndType);
	}

}
