package org.stummi.jadis.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.element.ClassVersion;
import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.FieldInfo;
import org.stummi.jadis.element.MethodInfo;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.accessflags.AccessFlagContext;
import org.stummi.jadis.element.attribute.Attribute;

public class ClassFileReader implements ElementReader<ClassFile> {

	@Override
	public ClassFile readElement(JadisInputStream jadis) throws IOException {
		if (jadis.readInt() != 0xcafebabe) {
			throw new IOException("not a class file");
		}
		ClassVersion version = jadis.readElement(ClassVersion.class);
		ConstantPool cp = jadis.readConstantPool();
		List<AccessFlag> af = jadis.readAccessFlags(AccessFlagContext.CLASS);
		int thisClass = jadis.readUnsignedShort();
		int superClass = jadis.readUnsignedShort();
		int interfaceCount = jadis.readUnsignedShort();
		List<Integer> interfaceRefs = new ArrayList<>();
		for (int idx = 0; idx < interfaceCount; idx++) {
			interfaceRefs.add(jadis.readUnsignedShort());
		}
		// Interfaces i = jadis.readElement(Interfaces.class);
		List<FieldInfo> fields = jadis.readElementList(FieldInfo.class);
		List<MethodInfo> methods = jadis.readElementList(MethodInfo.class);
		List<Attribute> attributes = jadis.readElementList(Attribute.class);
		return new ClassFile(version, cp, af, thisClass, superClass,
				interfaceRefs, fields, methods, attributes);
	}

}
