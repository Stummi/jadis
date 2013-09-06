package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class StringConstant implements Constant {

	private final String value;

	@Override
	public String toResolvedString(ConstantPool constants) {
		return String.format("String: %s", value);
	}

}
