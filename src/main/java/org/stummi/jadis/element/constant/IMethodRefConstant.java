package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class IMethodRefConstant implements Constant {
	private final short classId;
	private final short ntId;

	@Override
	public String toResolvedString(ConstantPool constants) {
		return String.format("IMethod: %d %d", classId, ntId);
	}
}
