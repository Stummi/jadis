package org.stummi.jadis.element.attribute;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.stummi.jadis.element.AttributeInfo;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UnknownAttribute extends AbstractAttribute {
	private byte[] attributeData;

	public UnknownAttribute(AttributeInfo ai) {
		super(ai.getNameIndex());
		setAttributeData(ai.getData());
	}

	public UnknownAttribute(short nameRef, byte[] attributeData) {
		super(nameRef);
		setAttributeData(attributeData);
	}

}
