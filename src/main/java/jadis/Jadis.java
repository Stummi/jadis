package jadis;

import jadis.element.ClassFile;
import jadis.output.SimpleDumper;

import java.io.IOException;
import java.io.InputStream;

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
