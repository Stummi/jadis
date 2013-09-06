package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.attribute.Attribute;

public class GenericAttributeDumper extends AbstractAttributeDumper<Attribute> {

	@Override
	public void dumpAttribute(Attribute attribute) {
		byte[] data = attribute.getAttributeData();
		boolean firstLine = true;
		int idx = 0;
		for (byte b : data) {
			if (idx % 16 == 0) {
				if (!firstLine) {
					out.println();
				} else {
					firstLine = false;
				}

				printIndent();
				out.printf("%08X   ", idx);
			}

			if (idx % 8 == 0) {
				out.print(" ");
			}
			out.printf("%02X ", b);
			idx++;
		}
		out.println();
	}

	public static void main(String[] args) {

		for (int idx = 0; idx < 256; idx++) {
			byte b = (byte) idx;
			System.out.printf("%d %02X\n", b, b);
		}
	}


}
