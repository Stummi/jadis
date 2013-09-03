package org.stummi.jadis.element.constant;

import lombok.Value;

@Value
public class StringRefConstant implements Constant {

	private final int refId;

	@Override
	public String toResolvedString(Constant[] constants) {
		String s = ((StringConstant) constants[refId]).getValue();
		return String.format("StringRef: %s [%d]", s, refId);
	}

}
