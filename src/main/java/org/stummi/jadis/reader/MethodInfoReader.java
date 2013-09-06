package org.stummi.jadis.reader;

import java.io.IOException;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.MethodInfo;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.accessflags.AccessFlagContext;
import org.stummi.jadis.element.attribute.Attribute;

public class MethodInfoReader implements ElementReader<MethodInfo> {
	
	@Override
	public MethodInfo readElement(JadisInputStream jadis) throws IOException {
		List<AccessFlag> accessFlags = jadis
				.readAccessFlags(AccessFlagContext.METHOD);
		short nameIndex = jadis.readShort();
		short descriptorIndex = jadis.readShort();
		List<Attribute> attributes = jadis.readElementList(Attribute.class);
		return new MethodInfo(accessFlags, nameIndex, descriptorIndex, attributes);
	}

}
