package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.DoubleConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

public class DoubleConstantReader implements ElementReader<DoubleConstant> {

	@Override
	public DoubleConstant readElement(JadisInputStream jadis)
			throws IOException {
		return new DoubleConstant(jadis.readDouble());
	}

}
