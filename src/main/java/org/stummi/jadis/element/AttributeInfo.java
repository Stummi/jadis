package org.stummi.jadis.element;

import lombok.Value;

@Value
public class AttributeInfo implements Element {
	final int nameIndex;
	final byte[] data;
}
