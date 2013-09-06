package org.stummi.jadis.output.dump.attribute;

import java.io.PrintStream;

import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.output.dump.AttributeDumper;

public abstract class AbstractAttributeDumper<T extends Attribute> implements
		AttributeDumper<T> {

	protected int indent;
	protected PrintStream out;
	protected ClassFile classFile;

	@Override
	public final synchronized void dumpAttribute(T attribute,
			ClassFile classFile, int indent, PrintStream out) {
		this.classFile = classFile;
		this.indent = indent;
		this.out = out;

		try {
			dumpAttribute(attribute);
		} finally {
			classFile = null;
			indent = 0;
			out = null;
		}
	}

	protected abstract void dumpAttribute(T attribute);

	protected void println(String line) {
		printIndent();
		out.println(line);
	}

	protected void printfln(String line, Object... args) {
		printIndent();
		out.printf(line, args);
		out.println();
	}

	protected void printHexDump(byte[] data) {
		boolean firstLine = true;
		int idx = 0;
		for (byte b : data) {
			if (idx % 16 == 0) {
				if (!firstLine) {
					out.println();
				} else {
					firstLine = false;
				}

				printIndent();
				out.printf("%08X   ", idx);
			}

			if (idx % 8 == 0) {
				out.print(" ");
			}
			out.printf("%02X ", b);
			idx++;
		}
		out.println();
	}

	protected void printIndent() {
		for (int idx = 0; idx < indent; idx++) {
			out.print("    ");
		}
	}

}
