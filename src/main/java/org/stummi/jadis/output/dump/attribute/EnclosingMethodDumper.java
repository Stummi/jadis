package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.attribute.EnclosingMethod;

public class EnclosingMethodDumper extends
		AbstractAttributeDumper<EnclosingMethod> {

	@Override
	protected void dumpAttribute(EnclosingMethod attribute) {
		ConstantPool cp = classFile.getConstantPool();
		printfln("Class: %s",
				cp.getConstantResolvedString(attribute.getClassRef()));
		printfln("Method: %s",
				cp.getConstantResolvedString(attribute.getMethodRef()));
	}

}
