package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class StringRefConstant implements Constant {

	private final int refId;

	@Override
	public String toResolvedString(ConstantPool constants) {
		String s = constants.getStringConstantValue(refId);
		return String.format("StringRef: %s [%d]", s, refId);
	}

}
