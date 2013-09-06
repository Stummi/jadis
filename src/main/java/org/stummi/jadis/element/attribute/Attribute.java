package org.stummi.jadis.element.attribute;

import org.stummi.jadis.element.Element;

public interface Attribute extends Element {
	void setAttributeData(byte[] bytes);

	byte[] getAttributeData();

	void setNameRef(int nameRef);

	int getNameRef();
}
