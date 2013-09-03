package org.stummi.jadis.reader;

import java.io.IOException;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.Element;

public interface ElementReader<T extends Element> {
	T readElement(JadisInputStream jadis) throws IOException;
}
