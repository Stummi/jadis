package org.stummi.jadis.output.dump;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

import lombok.SneakyThrows;

import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.output.dump.attribute.ExceptionsAttributeDumper;
import org.stummi.jadis.output.dump.attribute.GenericAttributeDumper;
import org.stummi.jadis.output.dump.attribute.InnerClassesAttributeDumper;
import org.stummi.jadis.output.dump.attribute.SimpleReferenceAttributeDumper;

public class AttributeDumperMap
		extends
		HashMap<Class<? extends Attribute>, AttributeDumper<? extends Attribute>> {
	private static final long serialVersionUID = 1L;
	private GenericAttributeDumper defaultDumper;

	public AttributeDumperMap() {
		defaultDumper = new GenericAttributeDumper();
		putAttributeDumper(SimpleReferenceAttributeDumper.class);
		putAttributeDumper(ExceptionsAttributeDumper.class);
		putAttributeDumper(InnerClassesAttributeDumper.class);
	}

	@SneakyThrows
	@SuppressWarnings("unchecked")
	private void putAttributeDumper(Class<? extends AttributeDumper<?>> class1) {
		ParameterizedType pt = (ParameterizedType) class1
				.getGenericSuperclass();
		Class<? extends Attribute> dumpClass = (Class<? extends Attribute>) pt
				.getActualTypeArguments()[0];
		AttributeDumper<?> dumper = class1.getConstructor().newInstance();
		put(dumpClass, dumper);
	}

	@SuppressWarnings("unchecked")
	public <T extends Attribute> AttributeDumper<T> getDumper(Class<?> class1) {
		AttributeDumper<T> ret = (AttributeDumper<T>) get(class1);
		if (ret == null) {
			ret = (AttributeDumper<T>) defaultDumper;
		}
		return ret;
	}

}
