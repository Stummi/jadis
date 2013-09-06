package org.stummi.jadis.element.attribute;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class AnnotationsAttribute extends AbstractAttribute {
	private List<AnnotationsEntry> entries;
}
