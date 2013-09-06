package org.stummi.jadis.element.constant;

import org.stummi.jadis.element.ConstantPool;

final class StringUtilities {
	private StringUtilities() {
	}

	public static String createResolvedClassNTRef(short classRef, short ntRef,
			ConstantPool constants) {
		ClassConstant classConstant = (ClassConstant) constants
				.getConstant(classRef);
		int classNameRef = classConstant.getClassNameRef();
		StringConstant className = (StringConstant) constants
				.getConstant(classNameRef);
		NameAndTypeConstant ntConstant = (NameAndTypeConstant) constants
				.getConstant(ntRef);
		short nameRef = ntConstant.getNameRef();
		short typeRef = ntConstant.getTypeRef();
		String name = constants.getStringConstantValue(nameRef);
		String type = constants.getStringConstantValue(typeRef);

		return String.format("%s %s %s [%d->%d %d->[%d %d]]",
				className.getValue(), name, type, classRef, classNameRef,
				ntRef, nameRef, typeRef);
	}
}
