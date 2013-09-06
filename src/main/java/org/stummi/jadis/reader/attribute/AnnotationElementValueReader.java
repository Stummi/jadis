package org.stummi.jadis.reader.attribute;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.AnnotationElementValue;
import org.stummi.jadis.element.attribute.AnnotationsEntry;
import org.stummi.jadis.element.attribute.ArrayAnnotationValue;
import org.stummi.jadis.element.attribute.EnumConstAnnotationValue;
import org.stummi.jadis.element.attribute.ReferenceAnnotationValue;
import org.stummi.jadis.reader.ElementReader;

public class AnnotationElementValueReader implements
		ElementReader<AnnotationElementValue> {

	private Map<Character, Class<? extends AnnotationElementValue>> elementTypeMap;

	public AnnotationElementValueReader() {
		initElementTypeMap();
	}

	private void initElementTypeMap() {
		elementTypeMap = new HashMap<>();
		for (char c : "BCcDFIJSZs".toCharArray()) {
			elementTypeMap.put(c, ReferenceAnnotationValue.class);
		}
		
		elementTypeMap.put('e', EnumConstAnnotationValue.class);
		elementTypeMap.put('@', AnnotationsEntry.class);
		elementTypeMap.put('[', ArrayAnnotationValue.class);

	}

	@Override
	public AnnotationElementValue readElement(JadisInputStream jadis)
			throws IOException {
		char c = (char) jadis.readUnsignedByte();
		if (!elementTypeMap.containsKey(c)) {
			throw new IOException("unknown annotation value type: " + c);
		}

		return jadis.readElement(elementTypeMap.get(c));
	}

}
