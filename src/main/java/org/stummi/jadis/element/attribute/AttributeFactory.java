package org.stummi.jadis.element.attribute;

import org.stummi.jadis.element.AttributeInfo;

public final class AttributeFactory {
	public static Attribute createFromAttributeInfo(AttributeInfo ai) {
		return new UnknownAttribute(ai);
	}
}
