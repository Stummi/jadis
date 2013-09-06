package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class IMethodRefConstant implements Constant {
	private final int classRef;
	private final int ntRef;

	@Override
	public String toResolvedString(ConstantPool constants) {
		return String.format("IMethod: %d %d", classRef, ntRef);
	}
}
