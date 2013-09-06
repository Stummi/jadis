package org.stummi.jadis.element.attribute;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class CodeAttribute extends AbstractAttribute {
	private int maxStack;
	private int maxLocals;
	private byte[] code;
	private List<ExceptionEntry> exceptions;
	private List<Attribute> attributes;

}
