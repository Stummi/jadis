package org.stummi.jadis.element;

import java.util.List;

import lombok.Value;

import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.attribute.Attribute;

@Value
public class MethodInfo implements Element {
	final private List<AccessFlag> flags;
	final private short nameIndex;
	final private short descriptorIndex;
	final private List<Attribute> attributes;
	
}
