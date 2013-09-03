package org.stummi.jadis.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.AttributeInfo;
import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.element.ClassVersion;
import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.FieldInfo;
import org.stummi.jadis.element.MethodInfo;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.accessflags.AccessFlagContext;

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
