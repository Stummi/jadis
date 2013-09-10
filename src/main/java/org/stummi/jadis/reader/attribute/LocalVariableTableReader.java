package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.LocalVariableTable;
import org.stummi.jadis.element.attribute.LocalVariableTableEntry;
import org.stummi.jadis.reader.ElementReader;

public class LocalVariableTableReader implements
		ElementReader<LocalVariableTable> {

	@Override
	public LocalVariableTable readElement(JadisInputStream jadis)
			throws IOException {
		return new LocalVariableTable(
				jadis.readElementList(LocalVariableTableEntry.class));
	}

}
