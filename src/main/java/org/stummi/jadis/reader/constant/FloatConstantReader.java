package org.stummi.jadis.reader.constant;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.FloatConstant;
import org.stummi.jadis.reader.ElementReader;

public class FloatConstantReader implements ElementReader<FloatConstant> {

	@Override
	public FloatConstant readElement(JadisInputStream jadis) throws IOException {
		return new FloatConstant(jadis.readFloat());
	}

}
