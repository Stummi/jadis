package org.stummi.jadis.element;

import lombok.Value;

@Value
public class AttributeInfo implements Element {
	final short nameIndex;
	final byte[] data;
}
