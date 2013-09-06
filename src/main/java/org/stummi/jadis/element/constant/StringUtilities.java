package org.stummi.jadis.element.constant;

import org.stummi.jadis.element.ConstantPool;

final class StringUtilities {
	private StringUtilities() {
	}

	public static String createResolvedClassNTRef(int classRef, int ntRef,
			ConstantPool constants) {
		ClassConstant classConstant = (ClassConstant) constants
				.getConstant(classRef);
		int classNameRef = classConstant.getClassNameRef();
		StringConstant className = (StringConstant) constants
				.getConstant(classNameRef);
		NameAndTypeConstant ntConstant = (NameAndTypeConstant) constants
				.getConstant(ntRef);
		int nameRef = ntConstant.getNameRef();
		int typeRef = ntConstant.getTypeRef();
		String name = constants.getStringConstantValue(nameRef);
		String type = constants.getStringConstantValue(typeRef);

		return String.format("%s %s %s [%d->%d %d->[%d %d]]",
				className.getValue(), name, type, classRef, classNameRef,
				ntRef, nameRef, typeRef);
	}
}
