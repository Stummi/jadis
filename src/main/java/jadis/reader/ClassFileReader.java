package jadis.reader;

import jadis.JadisInputStream;
import jadis.element.AttributeInfo;
import jadis.element.ClassFile;
import jadis.element.ClassVersion;
import jadis.element.ConstantPool;
import jadis.element.FieldInfo;
import jadis.element.MethodInfo;
import jadis.element.accessflags.AccessFlag;
import jadis.element.accessflags.AccessFlagContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassFileReader implements ElementReader<ClassFile> {

	@Override
	public ClassFile readElement(JadisInputStream jadis) throws IOException {
		if (jadis.readInt() != 0xcafebabe) {
			throw new IOException("not a class file");
		}
		ClassVersion version = jadis.readElement(ClassVersion.class);
		ConstantPool cp = jadis.readElement(ConstantPool.class);
		List<AccessFlag> af = jadis.readAccessFlags(AccessFlagContext.CLASS);
		short thisClass = jadis.readShort();
		short superClass = jadis.readShort();
		int interfaceCount = jadis.readShort();
		List<Short> interfaceRefs = new ArrayList<>();
		for (int idx = 0; idx < interfaceCount; idx++) {
			interfaceRefs.add(jadis.readShort());
		}
		// Interfaces i = jadis.readElement(Interfaces.class);
		List<FieldInfo> fields = jadis.readElementList(FieldInfo.class);
		List<MethodInfo> methods = jadis.readElementList(MethodInfo.class);
		List<AttributeInfo> attributes = jadis
				.readElementList(AttributeInfo.class);
		return new ClassFile(version, cp, af, thisClass, superClass,
				interfaceRefs, fields, methods, attributes);
	}

}
