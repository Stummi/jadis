package org.stummi.jadis.output.dump.attribute;

import java.util.List;

import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.attribute.InnerClassEntry;
import org.stummi.jadis.element.attribute.InnerClassesAttribute;
import org.stummi.jadis.element.constant.Constant;

public class InnerClassesAttributeDumper extends
		AbstractAttributeDumper<InnerClassesAttribute> {

	@Override
	protected void dumpAttribute(InnerClassesAttribute attribute) {
		ConstantPool cp = classFile.getConstantPool();
		Constant[] constants = cp.getConstants();
		for (InnerClassEntry e : attribute.getEntries()) {
			List<AccessFlag> flags = e.getInnerClassAccessFlags();
			int innerClassInfoRef = e.getInnerClassInfoIndex();
			int outerClassInfoRef = e.getOuterClassInfoIndex();
			int innerClassNameRef = e.getInnerNameIndex();
			Constant innerClassInfo = cp.getConstant(innerClassInfoRef);
			Constant outerClassInfo = cp.getConstant(outerClassInfoRef);
			Constant innerClassName = cp.getConstant(innerClassNameRef);
			printfln("%s %s: %s in %s", flags,
					innerClassName.toResolvedString(constants),
					innerClassInfo.toResolvedString(constants),
					outerClassInfo.toResolvedString(constants));
		}
	}

}
