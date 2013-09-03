package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.FieldRefConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

public class FieldRefConstantReader implements ElementReader<FieldRefConstant> {

	@Override
	public FieldRefConstant readElement(JadisInputStream jadis)
			throws IOException {
		short classIndex = jadis.readShort();
		short nameAndTypeIndex = jadis.readShort();
		return new FieldRefConstant(classIndex, nameAndTypeIndex);
	}

}
