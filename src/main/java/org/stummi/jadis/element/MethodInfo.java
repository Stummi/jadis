package org.stummi.jadis.element;

import java.util.List;

import lombok.Value;

import org.stummi.jadis.element.accessflags.AccessFlag;

@Value
public class MethodInfo implements Element {
	final private List<AccessFlag> flags;
	final private int nameIndex;
	final private int descriptorIndex;
	final private AttributePool attributePool;

}
