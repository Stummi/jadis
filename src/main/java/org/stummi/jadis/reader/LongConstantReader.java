package org.stummi.jadis.reader;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.constant.LongConstant;

public class LongConstantReader implements ElementReader<LongConstant> {

	@Override
	public LongConstant readElement(JadisInputStream jadis) throws IOException {
		return new LongConstant(jadis.readLong());
	}

}
