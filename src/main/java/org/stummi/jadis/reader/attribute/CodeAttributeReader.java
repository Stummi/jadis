package org.stummi.jadis.reader.attribute;

import java.io.IOException;
import java.util.List;

import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.element.attribute.CodeAttribute;
import org.stummi.jadis.element.attribute.ExceptionEntry;
import org.stummi.jadis.reader.ElementReader;

public class CodeAttributeReader implements ElementReader<CodeAttribute> {

	@Override
	public CodeAttribute readElement(JadisInputStream jadis) throws IOException {
		int maxStack = jadis.readUnsignedShort();
		int maxLocals = jadis.readUnsignedShort();
		int codeLen = jadis.readInt();
		byte[] code = new byte[codeLen];
		jadis.read(code);
		List<ExceptionEntry> exceptions = jadis
				.readElementList(ExceptionEntry.class);
		List<Attribute> attributes = jadis.readElementList(Attribute.class);
		return new CodeAttribute(maxStack, maxLocals, code, exceptions,
				attributes);

	}

}
