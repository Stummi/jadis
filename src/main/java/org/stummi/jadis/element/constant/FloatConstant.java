package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class FloatConstant implements Constant {
	private float value;

	@Override
	public String toResolvedString(ConstantPool constants) {
		return String.format("Float: %f", value);
	}
}
