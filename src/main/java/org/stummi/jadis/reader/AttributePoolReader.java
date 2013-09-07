package org.stummi.jadis.reader;

import java.io.IOException;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.AttributePool;
import org.stummi.jadis.element.attribute.Attribute;

public class AttributePoolReader implements ElementReader<AttributePool> {

	@Override
	public AttributePool readElement(JadisInputStream jadis) throws IOException {
		List<Attribute> attributes = jadis.readElementList(Attribute.class);
		return new AttributePool(attributes, jadis.getConstantPool());
	}
}