package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.IntegerConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

public class IntegerConstantReader implements ElementReader<IntegerConstant> {
	@Override
	public IntegerConstant readElement(JadisInputStream jadis)
			throws IOException {
		return new IntegerConstant(jadis.readInt());
	}
}
