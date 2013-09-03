package jadis.reader;

import jadis.JadisInputStream;
import jadis.element.AttributeInfo;
import jadis.element.MethodInfo;
import jadis.element.accessflags.AccessFlag;
import jadis.element.accessflags.AccessFlagContext;

import java.io.IOException;
import java.util.List;

public class MethodInfoReader implements ElementReader<MethodInfo> {
	
	@Override
	public MethodInfo readElement(JadisInputStream jadis) throws IOException {
		List<AccessFlag> accessFlags = jadis
				.readAccessFlags(AccessFlagContext.METHOD);
		short nameIndex = jadis.readShort();
		short descriptorIndex = jadis.readShort();
		List<AttributeInfo> attributes = jadis
				.readElementList(AttributeInfo.class);
		return new MethodInfo(accessFlags, nameIndex, descriptorIndex, attributes);
	}

}
