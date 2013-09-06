package org.stummi.jadis.output.dump;

import java.io.PrintStream;

import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.element.attribute.Attribute;

public abstract class AbstractAttributeDumper<T extends Attribute> implements
		AttributeDumper<T> {

	protected Attribute attribute;
	protected int indent;
	protected PrintStream out;

	@Override
	public final synchronized void dumpAttribute(Attribute attribute,
			ClassFile cf, int indent, PrintStream out) {
		this.attribute = attribute;
		this.indent = indent;
		this.out = out;

		try {
			dumpAttribute(attribute);
		} finally {
			attribute = null;
			indent = 0;
			out = null;
		}
	}

	protected abstract void dumpAttribute(Attribute attribute);

	protected void println(String line) {
		printIndent();
		out.println(line);
	}

	protected void printfln(String line, Object... args) {
		printIndent();
		out.printf(line, args);
		out.println();
	}

	protected void printIndent() {
		for (int idx = 0; idx < indent; idx++) {
			out.print("    ");
		}
	}

}
