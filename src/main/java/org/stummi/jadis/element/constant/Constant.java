package org.stummi.jadis.element.constant;

import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.Element;

public interface Constant extends Element {
	public String toResolvedString(ConstantPool constants);
}
