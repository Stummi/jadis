package org.stummi.jadis.element;

import lombok.Value;

import org.stummi.jadis.element.constant.Constant;

@Value
public class ConstantPool implements Element {
	private final Constant[] constants;

	public Constant getConstant(int id) {
		return constants[id];
	}
}
