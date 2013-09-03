package jadis.reader;

import jadis.JadisInputStream;
import jadis.element.constant.LongConstant;

import java.io.IOException;

public class LongConstantReader implements ElementReader<LongConstant> {

	@Override
	public LongConstant readElement(JadisInputStream jadis) throws IOException {
		return new LongConstant(jadis.readLong());
	}

}
