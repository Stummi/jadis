package org.stummi.jadis.output.dump.attribute;

import java.io.IOException;
import java.io.PrintStream;

import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.output.dump.AttributeDumper;
import org.stummi.jadis.output.dump.AttributeDumperMap;

public abstract class AbstractAttributeDumper<T extends Attribute> implements
		AttributeDumper<T> {

	protected int indent;
	protected PrintStream out;
	protected ClassFile classFile;
	protected AttributeDumperMap dumperMap;

	@Override
	public final synchronized void dumpAttribute(T attribute,
			ClassFile classFile, int indent, PrintStream out,
			AttributeDumperMap dumperMap)
			throws IOException {
		this.classFile = classFile;
		this.indent = indent;
		this.out = out;
		this.dumperMap = dumperMap;

		try {
			dumpAttribute(attribute);
		} finally {
			this.classFile = null;
			this.indent = 0;
			this.out = null;
			this.dumperMap = null;
		}
	}

	protected abstract void dumpAttribute(T attribute) throws IOException;

	protected void dumpSubAttribute(Attribute a) throws IOException {
		String name = classFile.getConstantPool().getStringConstantValue(
				a.getNameRef());
		printfln("Attribute: %s", name);
		dumperMap.getDumper(a.getClass()).dumpAttribute(a, classFile,
				indent + 1,
				out, dumperMap);
	}

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
