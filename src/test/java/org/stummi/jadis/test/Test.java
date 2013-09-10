package org.stummi.jadis.test;

import java.io.IOException;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Test implements Serializable, TestInterface {
	class SubTest {

	}

	private static final long serialVersionUID = 1234567L;

	int foo;
	@TestAnnotation(value = "asd", testEnum = TestEnum.BAR, nested = {
			@TestNestedAnnotation("foo"), @TestNestedAnnotation("bar") })
	public String bar = "asdf";
	public int bla = 42;

	void test(int foo, String bar, int bla) throws IOException {
		if (foo > 100) {
			throw new IOException("foo must be <= 100");
		}

		this.foo = foo;
		try {
			this.bar = bar.toUpperCase();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			bar = "NULL";
		} catch (Exception ioe) {
			ioe.printStackTrace();
		} finally {
			this.bla = bla;
		}

	}

	public void t() {
		int[] i = { 1, 2, 3, 4, 5 };
	}

	public int arraySum(int... values) {
		int ret = 0;
		for (int v : values) {
			ret += v;
		}
		return ret;
	}

	public int somethingWithSwitch(int e, int a, int b) {
		switch (e) {
		case 8:
			return a + b;
		case 1:
			return a * b;
		default:
			return 0;
		}
	}
}
