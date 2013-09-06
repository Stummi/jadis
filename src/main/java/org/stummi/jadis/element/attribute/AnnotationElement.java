package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.stummi.jadis.element.Element;

@Data
@AllArgsConstructor
public class AnnotationElement implements Element {
	int elementNameRef;
	AnnotationElementValue value;
}
