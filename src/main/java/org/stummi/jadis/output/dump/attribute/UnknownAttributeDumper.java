package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.attribute.UnknownAttribute;

public class UnknownAttributeDumper extends
		AbstractAttributeDumper<UnknownAttribute> {

	@Override
	public void dumpAttribute(UnknownAttribute attribute) {
		printHexDump(attribute.getAttributeData());
	}
}
