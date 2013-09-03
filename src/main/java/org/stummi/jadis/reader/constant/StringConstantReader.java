package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.StringConstant;
import org.stummi.jadis.reader.ElementReader;

public class StringConstantReader implements ElementReader<StringConstant> {

	@Override
	public StringConstant readElement(JadisInputStream jadis)
			throws IOException {
		return new StringConstant(jadis.readUTF());
	}

}
