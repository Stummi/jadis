package org.stummi.jadis.element.attribute;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.stummi.jadis.element.AttributeInfo;

@Data
@NoArgsConstructor
public class UnknownAttribute implements Attribute {
	private byte[] attributeData;
	private int nameRef;

	public UnknownAttribute(AttributeInfo ai) {
		setNameRef(ai.getNameIndex());
		setAttributeData(ai.getData());
	}

	public UnknownAttribute(int nameRef, byte[] attributeData) {
		setNameRef(nameRef);
		setAttributeData(attributeData);
	}

}
