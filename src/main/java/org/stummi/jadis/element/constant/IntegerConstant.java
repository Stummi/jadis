package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class IntegerConstant implements Constant {

	private final int value;

	@Override
	public String toResolvedString(ConstantPool constants) {
		return String.format("Integer: %d", value);
	}

}
