package org.stummi.jadis.element.constant;

final class StringUtilities {
	private StringUtilities() {
	}

	public static String createResolvedClassNTRef(short classRef, short ntRef,
			Constant[] constants) {
		ClassConstant classConstant = (ClassConstant) constants[classRef];
		int classNameRef = classConstant.getRefId();
		StringConstant className = (StringConstant) constants[classNameRef];
		NameAndTypeConstant ntConstant = (NameAndTypeConstant) constants[ntRef];
		short nameRef = ntConstant.getNameId();
		short typeRef = ntConstant.getTypeId();
		StringConstant name = (StringConstant) constants[nameRef];
		StringConstant type = (StringConstant) constants[typeRef];

		return String.format("%s %s %s [%d->%d %d->[%d %d]]",
				className.getValue(), name.getValue(), type.getValue(),
				classRef, classNameRef, ntRef, nameRef, typeRef);
	}
}
