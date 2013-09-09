package org.stummi.jadis.output.dump;

import java.io.IOException;
import java.io.PrintStream;

import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.element.attribute.Attribute;

public interface AttributeDumper<T extends Attribute> {
	void dumpAttribute(T attribute, ClassFile cf, int intent, PrintStream out)
			throws IOException;
}
