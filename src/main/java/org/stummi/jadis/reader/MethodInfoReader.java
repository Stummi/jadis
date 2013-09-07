package org.stummi.jadis.reader;

import java.io.IOException;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.AttributePool;
import org.stummi.jadis.element.MethodInfo;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.accessflags.AccessFlagContext;

public class MethodInfoReader implements ElementReader<MethodInfo> {

	@Override
	public MethodInfo readElement(JadisInputStream jadis) throws IOException {
		List<AccessFlag> accessFlags = jadis
				.readAccessFlags(AccessFlagContext.METHOD);
		int nameRef = jadis.readUnsignedShort();
		int descriptorRef = jadis.readUnsignedShort();
		AttributePool attributes = jadis.readElement(AttributePool.class);
		return new MethodInfo(accessFlags, nameRef, descriptorRef, attributes);
	}

}
