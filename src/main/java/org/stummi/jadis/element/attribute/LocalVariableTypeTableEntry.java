package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.stummi.jadis.element.Element;

@Data
@AllArgsConstructor
public class LocalVariableTypeTableEntry implements Element {
	private int startPos;
	private int length;
	private int nameIndex;
	private int signatureIndex;
	private int index;
}
