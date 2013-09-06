package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.attribute.SimpleReferenceAttribute;
import org.stummi.jadis.element.constant.Constant;

public class SimpleReferenceAttributeDumper extends
		AbstractAttributeDumper<SimpleReferenceAttribute> {

	@Override
	protected void dumpAttribute(SimpleReferenceAttribute attribute) {
		ConstantPool cp = classFile.getConstantPool();
		int ref = attribute.getConstantRef();
		Constant c = cp.getConstant(ref);
		printfln("[%s] %s", ref, c.toResolvedString(cp.getConstants()));
	}

}
