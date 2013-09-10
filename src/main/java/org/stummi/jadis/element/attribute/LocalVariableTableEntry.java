package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.stummi.jadis.element.Element;

@Data
@AllArgsConstructor
public class LocalVariableTableEntry implements Element {
	private int startPos;
	private int length;
	private int nameIndex;
	private int descriptorIndex;
	private int index;
}
