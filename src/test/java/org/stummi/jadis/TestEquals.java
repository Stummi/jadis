package org.stummi.jadis;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Test;
import org.stummi.jadis.element.ClassFile;

public class TestEquals {
	/**
	 * Check if two ClassFile Instances for the same class are equal
	 */
	@Test
	public void testEquals() throws IOException {
		ClassFile cf1 = loadTestClass("org/stummi/jadis/test/Test.class");
		ClassFile cf2 = loadTestClass("org/stummi/jadis/test/Test.class");
		ClassFile cf3 = loadTestClass("java/lang/Object.class");
		Assert.assertEquals(cf1.hashCode(), cf2.hashCode());
		Assert.assertEquals(cf1, cf2);
		Assert.assertFalse(cf1.equals(cf3));
	}

	private ClassFile loadTestClass(String name) throws IOException {
		try (InputStream fis = ClassLoader.getSystemResourceAsStream(name);
				JadisInputStream jis = new JadisInputStream(fis);) {
			return jis.readClassFile();
		}
	}

}
