package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class SimpleReferenceAttribute extends AbstractAttribute {
	private int constantRef;
}
