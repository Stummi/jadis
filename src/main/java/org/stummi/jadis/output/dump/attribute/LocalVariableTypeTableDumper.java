package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.attribute.LocalVariableTypeTable;
import org.stummi.jadis.element.attribute.LocalVariableTypeTableEntry;

public class LocalVariableTypeTableDumper extends
		AbstractAttributeDumper<LocalVariableTypeTable> {

	@Override
	protected void dumpAttribute(LocalVariableTypeTable attribute) {
		ConstantPool cp = classFile.getConstantPool();
		for (LocalVariableTypeTableEntry lvte : attribute.getTable()) {
			int index = lvte.getIndex();
			int startCodePos = lvte.getStartPos();
			int length = lvte.getLength();
			String name = cp.getStringConstantValue(lvte.getNameIndex());
			String descriptor = cp.getStringConstantValue(lvte
					.getSignatureIndex());
			printfln("%d:%d-%d:%s %s", index, startCodePos, length, name,
					descriptor);
		}
	}

}
