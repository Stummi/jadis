package org.stummi.jadis.reader.attribute;

import java.io.IOException;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.AnnotationElement;
import org.stummi.jadis.element.attribute.AnnotationsEntry;
import org.stummi.jadis.reader.ElementReader;

public class AnnotationsEntryReader implements ElementReader<AnnotationsEntry> {

	@Override
	public AnnotationsEntry readElement(JadisInputStream jadis)
			throws IOException {
		int typeRef = jadis.readUnsignedShort();
		List<AnnotationElement> elementValues = jadis
				.readElementList(AnnotationElement.class);
		return new AnnotationsEntry(typeRef, elementValues);
	}

}
