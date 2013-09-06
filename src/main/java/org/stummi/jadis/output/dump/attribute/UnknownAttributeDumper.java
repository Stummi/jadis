package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.attribute.UnknownAttribute;

public class UnknownAttributeDumper extends
		AbstractAttributeDumper<UnknownAttribute> {

	@Override
	public void dumpAttribute(UnknownAttribute attribute) {
		printHexDump(attribute.getAttributeData());
	}

	public static void main(String[] args) {

		for (int idx = 0; idx < 256; idx++) {
			byte b = (byte) idx;
			System.out.printf("%d %02X\n", b, b);
		}
	}

}
