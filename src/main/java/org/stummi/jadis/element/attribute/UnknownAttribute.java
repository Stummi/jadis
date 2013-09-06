package org.stummi.jadis.element.attribute;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnknownAttribute implements Attribute {
	private byte[] attributeData;
	private int nameRef;

	public UnknownAttribute(int nameRef, byte[] attributeData) {
		setNameRef(nameRef);
		setAttributeData(attributeData);
	}

}
