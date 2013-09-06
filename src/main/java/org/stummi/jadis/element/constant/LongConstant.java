package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class LongConstant implements Constant {
	private long value;

	@Override
	public String toResolvedString(ConstantPool constants) {
		return String.format("Long: %d", value);
	}
}
