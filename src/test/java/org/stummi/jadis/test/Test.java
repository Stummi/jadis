package org.stummi.jadis.test;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Test implements Serializable, TestInterface {
	class SubTest {
		
	}
	
	private static final long serialVersionUID = 1234567L;

	int foo;
	@TestAnnotation("asd")
	public String bar = "asdf";
	public int bla = 42;

	void test(int foo, String bar, int bla) {
		this.foo = foo;
		this.bar = bar;
		this.bla = bla;
	}
}
