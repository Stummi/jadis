package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ParamAnnotationsAttribute extends AbstractAttribute {
	private AnnotationsAttribute[] annotations;
}
