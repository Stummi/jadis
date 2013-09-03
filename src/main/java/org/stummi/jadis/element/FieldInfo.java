package org.stummi.jadis.element;

import java.util.List;

import org.stummi.jadis.element.accessflags.AccessFlag;

import lombok.Value;

@Value
public class FieldInfo implements Element {
	final List<AccessFlag> flags;
	final short nameIndex;
	final short descriptorIndex;
	final List<AttributeInfo> attributes;
}
