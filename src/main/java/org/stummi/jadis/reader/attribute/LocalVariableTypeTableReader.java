package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.LocalVariableTypeTable;
import org.stummi.jadis.element.attribute.LocalVariableTypeTableEntry;
import org.stummi.jadis.reader.ElementReader;

public class LocalVariableTypeTableReader implements
		ElementReader<LocalVariableTypeTable> {

	@Override
	public LocalVariableTypeTable readElement(JadisInputStream jadis)
			throws IOException {
		return new LocalVariableTypeTable(
				jadis.readElementList(LocalVariableTypeTableEntry.class));
	}

}
