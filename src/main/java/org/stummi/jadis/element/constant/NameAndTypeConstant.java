package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class NameAndTypeConstant implements Constant {
	private final short nameRef;
	private final short typeRef;

	@Override
	public String toResolvedString(ConstantPool constants) {
		String name = constants.getStringConstantValue(nameRef);
		String type = constants.getStringConstantValue(typeRef);
		return String.format("NameAndType: %s %s [%d %d]", name, type, nameRef,
				typeRef);
	}
}
