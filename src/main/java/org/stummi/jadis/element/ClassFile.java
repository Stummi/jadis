package org.stummi.jadis.element;

import java.util.List;

import org.stummi.jadis.element.accessflags.AccessFlag;

import lombok.Value;

@Value
public class ClassFile implements Element {
	final private ClassVersion version;
	final private ConstantPool constantPool;
	final private List<AccessFlag> accessFlags;
	final short thisClassId;
	final short superClassId;
	final private List<Short> interfaces;
	final private List<FieldInfo> fields;
	final private List<MethodInfo> methods;
	final private List<AttributeInfo> attributes;
}
