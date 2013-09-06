package org.stummi.jadis.reader;

import java.io.IOException;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.FieldInfo;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.accessflags.AccessFlagContext;
import org.stummi.jadis.element.attribute.Attribute;


public class FieldInfoReader implements ElementReader<FieldInfo> {
	@Override
	public FieldInfo readElement(JadisInputStream jadis) throws IOException {
		List<AccessFlag> af = jadis.readAccessFlags(AccessFlagContext.FIELD);
		short nameIndex = jadis.readShort();
		short descriptorIndex = jadis.readShort();
		List<Attribute> attributes = jadis.readElementList(Attribute.class);
		return new FieldInfo(af, nameIndex, descriptorIndex, attributes);
	}

}
