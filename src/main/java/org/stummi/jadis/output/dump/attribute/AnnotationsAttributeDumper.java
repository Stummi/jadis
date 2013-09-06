package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.attribute.AnnotationElement;
import org.stummi.jadis.element.attribute.AnnotationElementValue;
import org.stummi.jadis.element.attribute.AnnotationsAttribute;
import org.stummi.jadis.element.attribute.AnnotationsEntry;
import org.stummi.jadis.element.attribute.ArrayAnnotationValue;
import org.stummi.jadis.element.attribute.EnumConstAnnotationValue;
import org.stummi.jadis.element.attribute.ReferenceAnnotationValue;
import org.stummi.jadis.element.constant.Constant;

public class AnnotationsAttributeDumper extends
		AbstractAttributeDumper<AnnotationsAttribute> {

	@Override
	protected void dumpAttribute(AnnotationsAttribute attribute) {

		ConstantPool cp = classFile.getConstantPool();
		for (AnnotationsEntry av : attribute.getEntries()) {
			int typeRef = av.getTypeRef();
			printfln("%s", cp.getConstant(typeRef).toResolvedString(cp));
			for (AnnotationElement ae : av.getElementValues()) {
				dumpAnnotationElement(ae);
			}
		}

	}

	private void dumpAnnotationElement(AnnotationElement ae) {
		ConstantPool cp = classFile.getConstantPool();
		String name = cp.getStringConstantValue(ae.getElementNameRef());
		AnnotationElementValue value = ae.getValue();
		indent++;
		printfln("%s", name);
		indent++;
		dumpValue(value);
		indent--;
		indent--;
	}

	private void dumpValue(AnnotationElementValue value) {
		ConstantPool cp = classFile.getConstantPool();
		if (value instanceof ArrayAnnotationValue) {
			printfln("[array]");
			for (AnnotationElementValue aev : ((ArrayAnnotationValue) value)
					.getElements()) {
				dumpValue(aev);
			}
		} else if (value instanceof ReferenceAnnotationValue) {
			ReferenceAnnotationValue rav = (ReferenceAnnotationValue) value;
			Constant c = cp.getConstant(rav.getReference());
			printfln("reference: [%d] %s", rav.getReference(),
					c.toResolvedString(cp));
		} else if (value instanceof EnumConstAnnotationValue) {
			EnumConstAnnotationValue ecav = (EnumConstAnnotationValue) value;
			String typeName = cp.getStringConstantValue(ecav.getTypeNameRef());
			String constName = cp
					.getStringConstantValue(ecav.getConstNameRef());

			printfln("EnumConstant: [%d] %s -> [%d] %s", ecav.getTypeNameRef(),
					typeName, ecav.getConstNameRef(), constName);
		} else if (value instanceof AnnotationsEntry) {
			AnnotationsEntry ae = (AnnotationsEntry) value;
			printfln("Annotation: "
					+ cp.getConstant(ae.getTypeRef()).toResolvedString(cp));
			for (AnnotationElement elem : ae.getElementValues())
				dumpAnnotationElement(elem);
		} else {
			printfln("%s", value);
		}
	}
}
