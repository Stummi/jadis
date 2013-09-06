package org.stummi.jadis.reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.AnnotationsAttribute;
import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.element.attribute.CodeAttribute;
import org.stummi.jadis.element.attribute.ExceptionsAttribute;
import org.stummi.jadis.element.attribute.InnerClassesAttribute;
import org.stummi.jadis.element.attribute.SimpleReferenceAttribute;
import org.stummi.jadis.element.attribute.UnknownAttribute;

public class AttributeReader implements ElementReader<Attribute> {

	Map<String, Class<? extends Attribute>> knownAttributes;

	public AttributeReader() {
		knownAttributes = new HashMap<>();
		knownAttributes.put("RuntimeVisibleAnnotations",
				AnnotationsAttribute.class);
		knownAttributes.put("RuntimeInvisibleAnnotations",
				AnnotationsAttribute.class);
		knownAttributes.put("ConstantValue", SimpleReferenceAttribute.class);
		knownAttributes.put("SourceFile", SimpleReferenceAttribute.class);
		knownAttributes.put("Exceptions", ExceptionsAttribute.class);
		knownAttributes.put("InnerClasses", InnerClassesAttribute.class);
		knownAttributes.put("Code", CodeAttribute.class);
	}

	@Override
	public Attribute readElement(JadisInputStream jadis) throws IOException {
		int attrNameRef = jadis.readUnsignedShort();
		int attrLen = jadis.readInt();
		String attributeName = jadis.getConstantPool().getStringConstantValue(
				attrNameRef);
		// jadis.readInt()
		Attribute a;
		if (knownAttributes.containsKey(attributeName)) {
			Class<? extends Attribute> targetClass = knownAttributes
					.get(attributeName);
			a = jadis.readElement(targetClass);
			a.setNameRef(attrNameRef);
		} else {
			byte[] attr = new byte[attrLen];
			jadis.read(attr);
			a = new UnknownAttribute(attrNameRef, attr);
		}

		return a;
	}

}
