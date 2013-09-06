package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class MethodRefConstant implements Constant {

	private final short classId;
	private final short nameAndTypeId;

	@Override
	public String toResolvedString(ConstantPool constants) {
		return String.format("Method: %s", StringUtilities
				.createResolvedClassNTRef(classId, nameAndTypeId, constants));
	}

}
