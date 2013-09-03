package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.NameAndTypeConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

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
