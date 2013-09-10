package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.attribute.LocalVariableTable;
import org.stummi.jadis.element.attribute.LocalVariableTableEntry;

public class LocalVariableTableDumper extends
		AbstractAttributeDumper<LocalVariableTable> {

	@Override
	protected void dumpAttribute(LocalVariableTable attribute) {
		ConstantPool cp = classFile.getConstantPool();
		for(LocalVariableTableEntry lvte:attribute.getTable()) {
			int index = lvte.getIndex();
			int startCodePos = lvte.getStartPos();
			int length = lvte.getLength();
			String name = cp.getStringConstantValue(lvte.getNameIndex());
			String descriptor = cp.getStringConstantValue(lvte.getDescriptorIndex());
			printfln("%d:%d-%d:%s %s", index, startCodePos, length, name,
					descriptor);
		}
	}

}
