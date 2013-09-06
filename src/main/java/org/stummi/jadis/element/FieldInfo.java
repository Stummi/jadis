package org.stummi.jadis.element;

import java.util.List;

import lombok.Value;

import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.attribute.Attribute;

@Value
public class FieldInfo implements Element {
	final List<AccessFlag> flags;
	final int nameRef;
	final int descriptorRef;
	final List<Attribute> attributes;
}
