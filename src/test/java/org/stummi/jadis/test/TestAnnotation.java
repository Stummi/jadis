package org.stummi.jadis.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

	String value();

	TestEnum testEnum() default TestEnum.FOO;
}
