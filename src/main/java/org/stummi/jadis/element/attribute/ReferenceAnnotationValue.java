package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReferenceAnnotationValue implements AnnotationElementValue {
	int reference;
}
