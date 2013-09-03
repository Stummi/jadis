package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.StringConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

public class StringConstantReader implements ElementReader<StringConstant> {

	@Override
	public StringConstant readElement(JadisInputStream jadis)
			throws IOException {
		return new StringConstant(jadis.readUTF());
	}

}
