package org.stummi.jadis.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.stummi.jadis.element.Element;

@Data
@AllArgsConstructor
public class ExceptionEntry implements Element {
	private int startPc;
	private int endPc;
	private int handlerPc;
	private int catchType;
}
