package org.stummi.jadis.element;

import java.util.List;

import lombok.Value;

import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.attribute.Attribute;

@Value
public class ClassFile implements Element {
	final private ClassVersion version;
	final private ConstantPool constantPool;
	final private List<AccessFlag> accessFlags;
	final int thisClassId;
	final int superClassId;
	final private List<Integer> interfaces;
	final private List<FieldInfo> fields;
	final private List<MethodInfo> methods;
	final private List<Attribute> attributes;
}
