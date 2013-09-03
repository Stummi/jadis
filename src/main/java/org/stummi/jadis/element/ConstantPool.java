package org.stummi.jadis.element;

import org.stummi.jadis.element.constant.Constant;

import lombok.Value;

@Value
public class ConstantPool implements Element {
	private final Constant[] constants;

	public Constant getConstant(short id) {
		return constants[id];
	}
}
