package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class AbstractAttribute implements Attribute {
	private int nameRef;
}
