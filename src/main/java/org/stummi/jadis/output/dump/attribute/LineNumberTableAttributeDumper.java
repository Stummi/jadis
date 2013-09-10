package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.attribute.LineNumberTableAttribute;
import org.stummi.jadis.element.attribute.LineNumberTableEntry;

public class LineNumberTableAttributeDumper extends
		AbstractAttributeDumper<LineNumberTableAttribute> {

	@Override
	protected void dumpAttribute(LineNumberTableAttribute attribute) {
		for (LineNumberTableEntry lnte : attribute.getEntries()) {
			printfln("%5d %d", lnte.getByteIndex(), lnte.getLineNumber());
		}
	}

}
