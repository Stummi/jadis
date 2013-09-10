package org.stummi.jadis;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.SneakyThrows;

import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.Element;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.accessflags.AccessFlagContext;
import org.stummi.jadis.reader.ArrayAnnotationValueReader;
import org.stummi.jadis.reader.AttributePoolReader;
import org.stummi.jadis.reader.AttributeReader;
import org.stummi.jadis.reader.ClassFileReader;
import org.stummi.jadis.reader.ClassVersionReader;
import org.stummi.jadis.reader.ConstantPoolReader;
import org.stummi.jadis.reader.ElementReader;
import org.stummi.jadis.reader.FieldInfoReader;
import org.stummi.jadis.reader.LongConstantReader;
import org.stummi.jadis.reader.MethodInfoReader;
import org.stummi.jadis.reader.attribute.AnnotationElementReader;
import org.stummi.jadis.reader.attribute.AnnotationElementValueReader;
import org.stummi.jadis.reader.attribute.AnnotationsAttributeReader;
import org.stummi.jadis.reader.attribute.AnnotationsEntryReader;
import org.stummi.jadis.reader.attribute.CodeAttributeReader;
import org.stummi.jadis.reader.attribute.EnumConstantAnnotationValueReader;
import org.stummi.jadis.reader.attribute.ExceptionEntryReader;
import org.stummi.jadis.reader.attribute.ExceptionsAttributeReader;
import org.stummi.jadis.reader.attribute.InnerClassEntryReader;
import org.stummi.jadis.reader.attribute.InnerClassesAttributeReader;
import org.stummi.jadis.reader.attribute.ReferenceAnnotationValueReader;
import org.stummi.jadis.reader.attribute.SimpleReferenceAttributeReader;
import org.stummi.jadis.reader.constant.ClassConstantReader;
import org.stummi.jadis.reader.constant.DoubleConstantReader;
import org.stummi.jadis.reader.constant.FieldRefConstantReader;
import org.stummi.jadis.reader.constant.FloatConstantReader;
import org.stummi.jadis.reader.constant.IMethodRefConstantReader;
import org.stummi.jadis.reader.constant.IntegerConstantReader;
import org.stummi.jadis.reader.constant.MethodRefConstantReader;
import org.stummi.jadis.reader.constant.NameAndTypeConstantReader;
import org.stummi.jadis.reader.constant.StringConstantReader;
import org.stummi.jadis.reader.constant.StringRefConstantReader;

public class JadisInputStream extends DataInputStream {
	private Map<Class<? extends Element>, ElementReader<? extends Element>> readerMap;
	private ConstantPool constantPool;

	public JadisInputStream(InputStream in) {
		super(in);
		initMap();
	}

	private void initMap() {
		readerMap = new HashMap<>();
		putReader(ClassFileReader.class);
		putReader(ClassVersionReader.class);
		putReader(ConstantPoolReader.class);
		putReader(FieldInfoReader.class);
		putReader(AttributeReader.class);
		putReader(MethodInfoReader.class);

		putReader(StringConstantReader.class);
		putReader(IntegerConstantReader.class);
		putReader(FloatConstantReader.class);
		putReader(LongConstantReader.class);
		putReader(DoubleConstantReader.class);
		putReader(ClassConstantReader.class);
		putReader(StringRefConstantReader.class);
		putReader(FieldRefConstantReader.class);
		putReader(MethodRefConstantReader.class);
		putReader(IMethodRefConstantReader.class);
		putReader(NameAndTypeConstantReader.class);
		putReader(AttributePoolReader.class);

		putReader(ExceptionsAttributeReader.class);
		putReader(InnerClassEntryReader.class);
		putReader(InnerClassesAttributeReader.class);
		putReader(SimpleReferenceAttributeReader.class);
		putReader(CodeAttributeReader.class);
		putReader(AnnotationsAttributeReader.class);
		putReader(ExceptionEntryReader.class);
		putReader(AnnotationsEntryReader.class);
		putReader(AnnotationElementReader.class);
		putReader(ReferenceAnnotationValueReader.class);
		putReader(AnnotationElementValueReader.class);
		putReader(ArrayAnnotationValueReader.class);
		putReader(EnumConstantAnnotationValueReader.class);
	}

	@SuppressWarnings("unchecked")
	@SneakyThrows
	private void putReader(Class<? extends ElementReader<?>> class1) {
		ParameterizedType pt = (ParameterizedType) class1
				.getGenericInterfaces()[0];
		Class<? extends Element> readClass = (Class<? extends Element>) pt
				.getActualTypeArguments()[0];
		ElementReader<?> reader = class1.getConstructor().newInstance();
		readerMap.put(readClass, reader);
	}

	@SuppressWarnings("unchecked")
	public <E extends Element> ElementReader<E> getReaderForElement(Class<E> e) {
		return (ElementReader<E>) readerMap.get(e);
	}

	public <E extends Element> E readElement(Class<E> clazz) throws IOException {
		ElementReader<E> reader = getReaderForElement(clazz);
		if (reader == null) {
			throw new IOException("there is no reader for " + clazz);
		}
		E ret = reader.readElement(this);
		return ret;
	}

	public <E extends Element> List<E> readElementList(Class<E> clazz)
			throws IOException {
		List<E> ret = new ArrayList<>();
		int count = readUnsignedShort();
		for (int idx = 0; idx < count; idx++) {
			ret.add(readElement(clazz));
		}
		return ret;
	}

	public List<AccessFlag> readAccessFlags(AccessFlagContext context)
			throws IOException {
		int bits = readShort();
		return context.bitsToFlags(bits);
	}

	// The constant pool is needed to interprete further elements
	public ConstantPool readConstantPool() throws IOException {
		ConstantPool cp = readElement(ConstantPool.class);
		this.constantPool = cp;
		return cp;
	}

	public ConstantPool getConstantPool() {
		return constantPool;
	}

	public ClassFile readClassFile() throws IOException {
		return readElement(ClassFile.class);
	}
}
