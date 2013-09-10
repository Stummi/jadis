package org.stummi.jadis.output.dump;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

import lombok.SneakyThrows;

import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.output.dump.attribute.AnnotationDefaultDumper;
import org.stummi.jadis.output.dump.attribute.AnnotationsAttributeDumper;
import org.stummi.jadis.output.dump.attribute.CodeAttributeDumper;
import org.stummi.jadis.output.dump.attribute.EnclosingMethodDumper;
import org.stummi.jadis.output.dump.attribute.ExceptionsAttributeDumper;
import org.stummi.jadis.output.dump.attribute.InnerClassesAttributeDumper;
import org.stummi.jadis.output.dump.attribute.LineNumberTableAttributeDumper;
import org.stummi.jadis.output.dump.attribute.LocalVariableTableDumper;
import org.stummi.jadis.output.dump.attribute.LocalVariableTypeTableDumper;
import org.stummi.jadis.output.dump.attribute.MarkerAttributeDumper;
import org.stummi.jadis.output.dump.attribute.ParamAnnotationsDumper;
import org.stummi.jadis.output.dump.attribute.SimpleReferenceAttributeDumper;
import org.stummi.jadis.output.dump.attribute.UnknownAttributeDumper;

public class AttributeDumperMap
		extends
		HashMap<Class<? extends Attribute>, AttributeDumper<? extends Attribute>> {
	private static final long serialVersionUID = 1L;

	public AttributeDumperMap() {
		putAttributeDumper(SimpleReferenceAttributeDumper.class);
		putAttributeDumper(ExceptionsAttributeDumper.class);
		putAttributeDumper(InnerClassesAttributeDumper.class);
		putAttributeDumper(UnknownAttributeDumper.class);
		putAttributeDumper(AnnotationsAttributeDumper.class);
		putAttributeDumper(CodeAttributeDumper.class);
		putAttributeDumper(LineNumberTableAttributeDumper.class);
		putAttributeDumper(LocalVariableTableDumper.class);
		putAttributeDumper(LocalVariableTypeTableDumper.class);
		putAttributeDumper(MarkerAttributeDumper.class);
		putAttributeDumper(EnclosingMethodDumper.class);
		putAttributeDumper(ParamAnnotationsDumper.class);
		putAttributeDumper(AnnotationDefaultDumper.class);
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
		return (AttributeDumper<T>) get(class1);
	}

}
