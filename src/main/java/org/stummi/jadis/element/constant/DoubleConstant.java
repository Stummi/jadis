package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class DoubleConstant implements Constant {

	private final double value;

	@Override
	public String toResolvedString(ConstantPool constants) {
		return String.format("Double: %f", value);
	}

}
