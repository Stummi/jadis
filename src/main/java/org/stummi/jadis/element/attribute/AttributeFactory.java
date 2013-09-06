package org.stummi.jadis.element.attribute;

import java.util.HashMap;
import java.util.Map;

import lombok.SneakyThrows;

import org.stummi.jadis.element.AttributeInfo;

public final class AttributeFactory {
	private static Map<String, Class<? extends Attribute>> knownAttributes;

	static {
		knownAttributes = new HashMap<>();
		knownAttributes.put("ConstantValue", SimpleReferenceAttribute.class);
		knownAttributes.put("SourceFile", SimpleReferenceAttribute.class);
		knownAttributes.put("Exceptions", ExceptionsAttribute.class);
		knownAttributes.put("InnerClasses", InnerClassesAttribute.class);
	}

	@SneakyThrows
	public static Attribute createFromAttributeInfo(String attributeName,
			AttributeInfo ai) {
		if (knownAttributes.containsKey(attributeName)) {
			Class<? extends Attribute> c = knownAttributes.get(attributeName);
			Attribute a = c.newInstance();
			a.setNameRef(ai.getNameIndex());
			a.setAttributeData(ai.getData());
			return a;
		}
		return new UnknownAttribute(ai);
	}
}
