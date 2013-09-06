package org.stummi.jadis.reader.attribute;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.ExceptionEntry;
import org.stummi.jadis.reader.ElementReader;

public class ExceptionEntryReader implements ElementReader<ExceptionEntry> {

	@Override
	public ExceptionEntry readElement(JadisInputStream jadis)
			throws IOException {
		int startPc = jadis.readUnsignedShort();
		int endPc = jadis.readUnsignedShort();
		int handlerPc = jadis.readUnsignedShort();
		int catchType = jadis.readUnsignedShort();
		return new ExceptionEntry(startPc, endPc, handlerPc, catchType);
	}

}
