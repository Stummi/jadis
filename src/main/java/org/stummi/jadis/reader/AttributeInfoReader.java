package org.stummi.jadis.reader;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.AttributeInfo;

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
