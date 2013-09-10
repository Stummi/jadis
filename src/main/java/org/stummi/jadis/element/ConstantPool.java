package org.stummi.jadis.element;

import lombok.Value;

import org.stummi.jadis.element.constant.ClassConstant;
import org.stummi.jadis.element.constant.Constant;
import org.stummi.jadis.element.constant.StringConstant;

@Value
public class ConstantPool implements Element {
	private final Constant[] constants;

	public Constant getConstant(int ref) {
		return constants[ref];
	}

	public String getConstantResolvedString(int ref) {
		Constant c = constants[ref];
		if (c == null) {
			return String.format("[%d] <NULL>", ref);
		} else {
			return c.toResolvedString(this);
		}
	}

	public String getStringConstantValue(int ref) {
		return ((StringConstant) constants[ref]).getValue();
	}

	public String getClassConstantName(int ref) {
		ClassConstant cc = (ClassConstant) constants[ref];
		if (cc == null) {
			return "<CNULL>";
		}
		return getStringConstantValue(cc.getClassNameRef());
	}
}
