package org.stummi.jadis.element.attribute;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class LocalVariableTable extends AbstractAttribute {
	private List<LocalVariableTableEntry> table;
}
