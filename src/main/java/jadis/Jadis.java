package jadis;

import jadis.element.ClassFile;

import java.io.IOException;
import java.io.InputStream;

public class Jadis {
	public static void main(String[] args) throws IOException {
		InputStream fis = ClassLoader
				.getSystemResourceAsStream("jadis/Test.class");
		try (JadisInputStream jis = new JadisInputStream(fis)) {
			jis.readElement(ClassFile.class).dump(System.out);
			jis.close();
		}
	}
}
