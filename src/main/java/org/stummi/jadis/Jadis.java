package org.stummi.jadis;

import java.io.IOException;
import java.io.InputStream;

import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.output.SimpleDumper;

public class Jadis {
	public static void main(String[] args) throws IOException {
		InputStream fis = ClassLoader
				.getSystemResourceAsStream("jadis/Test.class");
		try (JadisInputStream jis = new JadisInputStream(fis)) {
			ClassFile cf = jis.readElement(ClassFile.class);
			new SimpleDumper(cf, System.out).dump();
		}
	}
}
