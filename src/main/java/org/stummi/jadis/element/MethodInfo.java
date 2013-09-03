package org.stummi.jadis.element;

import java.util.List;

import org.stummi.jadis.element.accessflags.AccessFlag;

import lombok.Value;

@Value
public class MethodInfo implements Element {
	final private List<AccessFlag> flags;
	final private short nameIndex;
	final private short descriptorIndex;
	final private List<AttributeInfo> attributes;
	
}
