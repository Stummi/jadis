package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.attribute.ExceptionsAttribute;
import org.stummi.jadis.element.constant.Constant;

public class ExceptionsAttributeDumper extends
		AbstractAttributeDumper<ExceptionsAttribute> {

	@Override
	protected void dumpAttribute(ExceptionsAttribute attribute) {
		ConstantPool cp = classFile.getConstantPool();
		for (Integer i : attribute.getExceptionRefs()) {
			Constant c = cp.getConstant(i);
			printfln("[%s] %s", i, c.toResolvedString(cp));
		}

	}

}
