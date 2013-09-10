package org.stummi.jadis.element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.element.attribute.CodeAttribute;

@Data
public class AttributePool implements Element {
	private ConstantPool constants;
	private List<Attribute> attributes;
	private Map<String, Attribute> attributeMap;

	public AttributePool(List<Attribute> attributes, ConstantPool constants) {
		this.attributes = attributes;
		this.constants = constants;
		initAttributeMap();
	}

	private void initAttributeMap() {
		attributeMap = new HashMap<>();
		for (Attribute a : attributes) {
			String attName = constants.getStringConstantValue(a.getNameRef());
			attributeMap.put(attName, a);
		}
	}

	public CodeAttribute getCodeAttribute() {
		return (CodeAttribute) getAttribute("Code");
	}

	public Attribute getAttribute(String attrName) {
		return attributeMap.get(attrName);
	}
}
