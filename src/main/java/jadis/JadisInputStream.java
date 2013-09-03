package jadis;

import jadis.element.Element;
import jadis.element.accessflags.AccessFlag;
import jadis.element.accessflags.AccessFlagContext;
import jadis.reader.AttributeInfoReader;
import jadis.reader.ClassFileReader;
import jadis.reader.ClassVersionReader;
import jadis.reader.ConstantPoolReader;
import jadis.reader.ElementReader;
import jadis.reader.FieldInfoReader;
import jadis.reader.LongConstantReader;
import jadis.reader.MethodInfoReader;
import jadis.reader.constant.ClassConstantReader;
import jadis.reader.constant.DoubleConstantReader;
import jadis.reader.constant.FieldRefConstantReader;
import jadis.reader.constant.FloatConstantReader;
import jadis.reader.constant.IMethodRefConstantReader;
import jadis.reader.constant.IntegerConstantReader;
import jadis.reader.constant.MethodRefConstantReader;
import jadis.reader.constant.NameAndTypeConstantReader;
import jadis.reader.constant.StringConstantReader;
import jadis.reader.constant.StringRefConstantReader;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
