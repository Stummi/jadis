package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class MethodRefConstant implements Constant {

	private final int classRef;
	private final int nameAndTypeRef;

	@Override
	public String toResolvedString(ConstantPool constants) {
		return String.format("Method: %s", StringUtilities
				.createResolvedClassNTRef(classRef, nameAndTypeRef, constants));
	}

}
