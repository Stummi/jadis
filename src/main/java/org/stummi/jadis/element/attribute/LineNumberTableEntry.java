package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.stummi.jadis.element.Element;

@Data
@AllArgsConstructor
public class LineNumberTableEntry implements Element {
	private final int byteIndex;
	private final int lineNumber;
}
