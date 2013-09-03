package jadis.reader;

import jadis.JadisInputStream;
import jadis.element.AttributeInfo;

import java.io.IOException;

public class AttributeInfoReader implements ElementReader<AttributeInfo> {

	@Override
	public AttributeInfo readElement(JadisInputStream jadis) throws IOException {
		short attrNameIndex = jadis.readShort();
		int attrLen = jadis.readInt();
		byte[] attr = new byte[attrLen];
		jadis.read(attr);
		return new AttributeInfo(attrNameIndex, attr);
	}

}
