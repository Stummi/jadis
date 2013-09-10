package org.stummi.jadis.reader.attribute;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.MarkerAttribute;
import org.stummi.jadis.reader.ElementReader;

public class MarkerAttributeReader implements ElementReader<MarkerAttribute> {

	@Override
	public MarkerAttribute readElement(JadisInputStream jadis) {
		return new MarkerAttribute();
	}

}
