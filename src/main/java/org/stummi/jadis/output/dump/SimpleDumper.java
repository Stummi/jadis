package org.stummi.jadis.output.dump;

import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.stummi.jadis.element.AttributeInfo;
import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.element.ClassVersion;
import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.FieldInfo;
import org.stummi.jadis.element.MethodInfo;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.element.attribute.AttributeFactory;
import org.stummi.jadis.element.constant.Constant;
import org.stummi.jadis.element.constant.StringConstant;

@RequiredArgsConstructor
public class SimpleDumper {
	private final ClassFile cf;
	private final PrintStream out;

	public void dump() {
		dumpHeader();
		dumpConstantPool();
		dumpClassDef();
		dumpInterfaces();
		dumpFields();
		dumpMethods();
		dumpAttributes();
	}

	public void dumpHeader() {
		printHead("HEADER");
		ClassVersion version = cf.getVersion();
		Constant c = cf.getConstantPool().getConstant(cf.getThisClassId());
		out.println("Jadis Class File Dump");
		out.printf("For %s\n",
				c.toResolvedString(cf.getConstantPool().getConstants()));
		out.printf("Version: %d.%d\n", version.getMajor(), version.getMinor());
		out.printf("Date: %s\n", new Date());
	}

	public void dumpConstantPool() {
		printHead("CONSTANTS");
		ConstantPool constantPool = cf.getConstantPool();
		Constant[] constants = constantPool.getConstants();
		for (int idx = 0; idx < constants.length; idx++) {
			Constant c = constants[idx];
			if (c == null) {
				continue;
			}
			out.println(idx + ": " + c.toResolvedString(constants));
		}
	}

	public void dumpClassDef() {
		printHead("CLASS");
		ConstantPool constantPool = cf.getConstantPool();
		List<AccessFlag> accessFlags = cf.getAccessFlags();
		short thisClassId = cf.getThisClassId();
		short superClassId = cf.getSuperClassId();
		Constant[] constants = constantPool.getConstants();

		out.println("Accessflags: " + accessFlags);
		Constant thisClass = constantPool.getConstant(thisClassId);
		Constant superClass = constantPool.getConstant(superClassId);
		out.println("this: " + thisClass.toResolvedString(constants));
		out.println("super: "
				+ (superClass == null ? "<NULL>" : superClass
						.toResolvedString(constants)));

	}

	public void dumpInterfaces() {
		printHead("INTERFACES");
		ConstantPool constantPool = cf.getConstantPool();
		List<Short> interfaces = cf.getInterfaces();
		for (Short s : interfaces) {
			out.println(constantPool.getConstant(s).toResolvedString(
					constantPool.getConstants()));
		}
	}

	public void dumpFields() {
		printHead("FIELDS");
		List<FieldInfo> fields = cf.getFields();
		ConstantPool constantPool = cf.getConstantPool();
		for (FieldInfo fi : fields) {
			StringConstant nameConstant = (StringConstant) constantPool
					.getConstant(fi.getNameIndex());
			StringConstant descriptorConstant = (StringConstant) constantPool
					.getConstant(fi.getDescriptorIndex());
			out.println(fi.getFlags() + " " + nameConstant.getValue() + " "
					+ descriptorConstant.getValue());
			dumpAttributeInfoList(fi.getAttributes(), 2);
		}
	}

	public void dumpMethods() {
		printHead("METHODS");
		List<MethodInfo> methods = cf.getMethods();
		ConstantPool constantPool = cf.getConstantPool();
		for (MethodInfo fi : methods) {
			StringConstant nameConstant = (StringConstant) constantPool
					.getConstant(fi.getNameIndex());
			StringConstant descriptorConstant = (StringConstant) constantPool
					.getConstant(fi.getDescriptorIndex());
			out.println(fi.getFlags() + " " + nameConstant.getValue() + " "
					+ descriptorConstant.getValue());
			dumpAttributeInfoList(fi.getAttributes(), 2);

		}
	}

	public void dumpAttributeInfoList(List<AttributeInfo> attributes, int indent) {
		for (AttributeInfo ai : attributes) {
			dumpAttributeInfo(ai, indent);
		}
	}

	public void dumpAttributeInfo(AttributeInfo ai, int indent) {
		Attribute a = AttributeFactory.createFromAttributeInfo(ai);
		dumpAttribute(a, indent);
	}

	public void dumpAttribute(Attribute a, int indent) {
		for (int idx = 0; idx < indent; idx++) {
			out.print("    ");
		}

		out.print("Attribute: ");

		ConstantPool constantPool = cf.getConstantPool();
		StringConstant nameConstant = (StringConstant) constantPool
				.getConstant(a.getNameRef());
		String attributeName = nameConstant.getValue();
		out.println(attributeName);

		getAttributeDumper(a).dumpAttribute(a, cf, indent + 1, out);

	}

	private AttributeDumper<Attribute> getAttributeDumper(Attribute a) {
		// TODO Auto-generated method stub
		return new GenericAttributeDumper();
	}

	public void dumpAttributes() {
		printHead("ATTRIBUTES");
		List<AttributeInfo> attributes = cf.getAttributes();
		dumpAttributeInfoList(attributes, 1);
	}

	private void printHead(String string) {
		System.out.printf("========== %s ==========\n", string);
	}

}
