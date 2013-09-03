package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.DoubleConstant;
import org.stummi.jadis.reader.ElementReader;

public class DoubleConstantReader implements ElementReader<DoubleConstant> {

	@Override
	public DoubleConstant readElement(JadisInputStream jadis)
			throws IOException {
		return new DoubleConstant(jadis.readDouble());
	}

}
