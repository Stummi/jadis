package org.stummi.jadis.element;

import java.util.List;

import lombok.Value;

import org.stummi.jadis.element.accessflags.AccessFlag;

@Value
public class FieldInfo implements Element {
	final List<AccessFlag> flags;
	final int nameRef;
	final int descriptorRef;
	final AttributePool attributePool;
}
