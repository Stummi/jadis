package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class FieldRefConstant implements Constant {

	private final short classRef;
	private final short ntRef;

	@Override
	public String toResolvedString(ConstantPool constants) {
		String s = StringUtilities.createResolvedClassNTRef(classRef, ntRef,
				constants);
		return String.format("Field: %s", s);
	}

}
