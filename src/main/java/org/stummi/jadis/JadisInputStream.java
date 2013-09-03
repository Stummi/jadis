package org.stummi.jadis;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.stummi.jadis.element.Element;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.accessflags.AccessFlagContext;
import org.stummi.jadis.reader.AttributeInfoReader;
import org.stummi.jadis.reader.ClassFileReader;
import org.stummi.jadis.reader.ClassVersionReader;
import org.stummi.jadis.reader.ConstantPoolReader;
import org.stummi.jadis.reader.ElementReader;
import org.stummi.jadis.reader.FieldInfoReader;
import org.stummi.jadis.reader.LongConstantReader;
import org.stummi.jadis.reader.MethodInfoReader;
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

import lombok.SneakyThrows;

public class JadisInputStream extends DataInputStream {
	private Map<Class<? extends Element>, ElementReader<? extends Element>> readerMap;

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
		putReader(AttributeInfoReader.class);
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
	}

	@SuppressWarnings("unchecked")
	@SneakyThrows
	private void putReader(Class<? extends ElementReader<?>> class1) {
		ParameterizedType pt = (ParameterizedType) class1
				.getGenericInterfaces()[0];
		Class<? extends Element> readClass = (Class<? extends Element>) pt
				.getActualTypeArguments()[0];
		ElementReader<?> reader = createInstance(class1);
		readerMap.put(readClass, reader);
	}

	@SneakyThrows
	private <T extends ElementReader<?>> T createInstance(Class<T> class1) {
			return class1.getConstructor().newInstance();
	}
	
	@SuppressWarnings("unchecked")
	public <E extends Element> ElementReader<E> getReaderForElement(Class<E> e) {
		return (ElementReader<E>) readerMap.get(e);
	}

	public <E extends Element> E readElement(Class<E> clazz)
			throws IOException {
		ElementReader<E> reader = getReaderForElement(clazz);
		if (reader == null) {
			throw new IOException("there is no reader for " + clazz);
		}
		return reader.readElement(this);
	}

	public <E extends Element> List<E> readElementList(Class<E> clazz) throws IOException {
		List<E> ret = new ArrayList<>();
		int count = readShort();
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

}
