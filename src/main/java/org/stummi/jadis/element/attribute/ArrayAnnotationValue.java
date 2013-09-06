package org.stummi.jadis.element.attribute;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ArrayAnnotationValue implements AnnotationElementValue {
	List<AnnotationElementValue> elements;

}
