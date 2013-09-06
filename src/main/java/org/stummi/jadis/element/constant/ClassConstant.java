package org.stummi.jadis.element.constant;

import lombok.Value;

import org.stummi.jadis.element.ConstantPool;

@Value
public class ClassConstant implements Constant {
	private final short classNameRef;

	@Override
	public String toResolvedString(ConstantPool constants) {
		String className = constants.getStringConstantValue(classNameRef);
		return String.format("Class: %s [%d]", className, classNameRef);
	}
}
