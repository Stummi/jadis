package jadis.reader;

import jadis.JadisInputStream;
import jadis.element.AttributeInfo;
import jadis.element.FieldInfo;
import jadis.element.accessflags.AccessFlag;
import jadis.element.accessflags.AccessFlagContext;

import java.io.IOException;
import java.util.List;


public class FieldInfoReader implements ElementReader<FieldInfo> {
	@Override
	public FieldInfo readElement(JadisInputStream jadis) throws IOException {
		List<AccessFlag> af = jadis.readAccessFlags(AccessFlagContext.FIELD);
		short nameIndex = jadis.readShort();
		short descriptorIndex = jadis.readShort();
		List<AttributeInfo> attributes = jadis
				.readElementList(AttributeInfo.class);
		return new FieldInfo(af, nameIndex, descriptorIndex, attributes);
	}

}
