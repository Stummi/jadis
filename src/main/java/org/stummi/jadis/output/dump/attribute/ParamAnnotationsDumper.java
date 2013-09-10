package org.stummi.jadis.output.dump.attribute;

import java.io.IOException;

import org.stummi.jadis.element.attribute.AnnotationsAttribute;
import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.element.attribute.ParamAnnotationsAttribute;
import org.stummi.jadis.output.dump.AttributeDumper;

public class ParamAnnotationsDumper extends
		AbstractAttributeDumper<ParamAnnotationsAttribute> {

	@Override
	protected void dumpAttribute(ParamAnnotationsAttribute attribute)
			throws IOException {
		AnnotationsAttribute[] params = attribute.getAnnotations();
		AttributeDumper<Attribute> ad = dumperMap
				.getDumper(AnnotationsAttribute.class);
		for (int idx = 0; idx < params.length; idx++) {
			printfln("Param %d:", idx);
			ad.dumpAttribute(params[idx], classFile, indent + 1, out, dumperMap);
		}

	}

}
