package org.stummi.jadis.output.dump.attribute;

import java.util.List;

import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.attribute.InnerClassesAttribute;
import org.stummi.jadis.element.attribute.InnerClassesEntry;
import org.stummi.jadis.element.constant.Constant;

public class InnerClassesAttributeDumper extends
		AbstractAttributeDumper<InnerClassesAttribute> {

	@Override
	protected void dumpAttribute(InnerClassesAttribute attribute) {
		ConstantPool cp = classFile.getConstantPool();
		for (InnerClassesEntry e : attribute.getEntries()) {
			List<AccessFlag> flags = e.getInnerClassAccessFlags();
			int innerClassInfoRef = e.getInnerClassInfoIndex();
			int outerClassInfoRef = e.getOuterClassInfoIndex();
			int innerClassNameRef = e.getInnerNameIndex();
			Constant innerClassName = cp.getConstant(innerClassNameRef);
			printfln("%s %s: %s in %s", flags,
					innerClassName == null ? "<NULL>" : innerClassName
							.toResolvedString(cp),
					cp.getClassConstantName(innerClassInfoRef),
					cp.getClassConstantName(outerClassInfoRef));
		}
	}

}
