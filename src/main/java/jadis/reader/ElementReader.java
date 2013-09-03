package jadis.reader;

import jadis.JadisInputStream;
import jadis.element.Element;

import java.io.IOException;

public interface ElementReader<T extends Element> {
	T readElement(JadisInputStream jadis) throws IOException;
}
