package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.IntegerConstant;
import org.stummi.jadis.reader.ElementReader;

public class IntegerConstantReader implements ElementReader<IntegerConstant> {
	@Override
	public IntegerConstant readElement(JadisInputStream jadis)
			throws IOException {
		return new IntegerConstant(jadis.readInt());
	}
}
