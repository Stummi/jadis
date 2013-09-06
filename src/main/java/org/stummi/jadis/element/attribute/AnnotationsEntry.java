package org.stummi.jadis.element.attribute;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AnnotationsEntry implements AnnotationElementValue {
	private int typeRef;
	private List<AnnotationElement> elementValues;
}
