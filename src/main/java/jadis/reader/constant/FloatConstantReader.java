package jadis.reader.constant;

import jadis.JadisInputStream;
import jadis.element.constant.FloatConstant;
import jadis.reader.ElementReader;

import java.io.IOException;

public class FloatConstantReader implements ElementReader<FloatConstant> {

	@Override
	public FloatConstant readElement(JadisInputStream jadis) throws IOException {
		return new FloatConstant(jadis.readFloat());
	}

}
