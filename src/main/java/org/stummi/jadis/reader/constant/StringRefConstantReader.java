package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.StringRefConstant;
import org.stummi.jadis.reader.ElementReader;

public class StringRefConstantReader implements
		ElementReader<StringRefConstant> {

	@Override
	public StringRefConstant readElement(JadisInputStream jadis)
			throws IOException {
		return new StringRefConstant(jadis.readShort());
	}

}
