package org.stummi.jadis.element.constant;


public enum ConstantType {
	STRING(1, StringConstant.class), //
	INTEGER(3, IntegerConstant.class), //
	FLOAT(4, FloatConstant.class), //
	LONG(5, 2, LongConstant.class), //
	DOUBLE(6, 2, DoubleConstant.class), //
	CLASS(7, ClassConstant.class), //
	STRINGREF(8, StringRefConstant.class), //
	FIELDREF(9, FieldRefConstant.class), //
	METHODREF(10, MethodRefConstant.class), //
	IMETHODREF(11, IMethodRefConstant.class), //
	NAME_AND_TYPE(12, NameAndTypeConstant.class);
	
	private int id;
	private int size;
	private Class<? extends Constant> clazz;

	private ConstantType(int id, Class<? extends Constant> clazz) {
		this(id, 1, clazz);
	}

	private ConstantType(int id, int size, Class<? extends Constant> clazz) {
		this.id = id;
		this.size = size;
		this.clazz = clazz;
	}

	public int getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public static ConstantType forId(int id) {
		for (ConstantType type : values()) {
			if (type.id == id) {
				return type;
			}
		}
		throw new IllegalArgumentException("unknown constant type: " + id);
	}

	public Class<? extends Constant> getConstantClass() {
		return clazz;
	}
}
