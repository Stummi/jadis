package org.stummi.jadis.element.constant;

import lombok.Value;

@Value
public class FloatConstant implements Constant {
	private float value;

	@Override
	public String toResolvedString(Constant[] constants) {
		return String.format("Float: %f", value);
	}
}
