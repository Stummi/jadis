package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.StringRefConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

public class StringRefConstantReader implements
		ElementReader<StringRefConstant> {

	@Override
	public StringRefConstant readElement(JadisInputStream jadis)
			throws IOException {
		return new StringRefConstant(jadis.readShort());
	}

}
