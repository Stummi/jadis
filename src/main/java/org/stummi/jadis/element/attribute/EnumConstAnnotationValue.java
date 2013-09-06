package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EnumConstAnnotationValue implements AnnotationElementValue {
	int typeNameRef;
	int constNameRef;
}
