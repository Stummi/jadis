package jadis.output;

import jadis.element.AttributeInfo;
import jadis.element.ClassFile;
import jadis.element.ClassVersion;
import jadis.element.ConstantPool;
import jadis.element.FieldInfo;
import jadis.element.MethodInfo;
import jadis.element.accessflags.AccessFlag;
import jadis.element.constant.Constant;
import jadis.element.constant.StringConstant;

import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;

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
		Constant[] constants = constantPool.getConstants();
		for (FieldInfo fi : fields) {
			StringConstant nameConstant = (StringConstant) constantPool
					.getConstant(fi.getNameIndex());
			StringConstant descriptorConstant = (StringConstant) constantPool
					.getConstant(fi.getDescriptorIndex());
			out.println(fi.getFlags() + " " + nameConstant.getValue() + " "
					+ descriptorConstant.getValue());
			for (AttributeInfo ai : fi.getAttributes()) {
				Constant aNameConstant = constantPool.getConstant(ai
						.getNameIndex());
				out.println("    " + aNameConstant.toResolvedString(constants));
			}
		}
	}

	public void dumpMethods() {
		printHead("METHODS");
		List<MethodInfo> methods = cf.getMethods();
		ConstantPool constantPool = cf.getConstantPool();
		Constant[] constants = constantPool.getConstants();
		for (MethodInfo fi : methods) {
			StringConstant nameConstant = (StringConstant) constantPool
					.getConstant(fi.getNameIndex());
			StringConstant descriptorConstant = (StringConstant) constantPool
					.getConstant(fi.getDescriptorIndex());
			out.println(fi.getFlags() + " " + nameConstant.getValue() + " "
					+ descriptorConstant.getValue());
			for (AttributeInfo ai : fi.getAttributes()) {
				Constant aNameConstant = constantPool.getConstant(ai
						.getNameIndex());
				out.println("    " + aNameConstant.toResolvedString(constants));
			}
		}
	}

	public void dumpAttributes() {

		printHead("ATTRIBUTES");
		List<AttributeInfo> attributes = cf.getAttributes();
		ConstantPool constantPool = cf.getConstantPool();
		Constant[] constants = constantPool.getConstants();
		for (AttributeInfo ai : attributes) {
			Constant aNameConstant = constantPool
					.getConstant(ai.getNameIndex());
			out.println("    " + aNameConstant.toResolvedString(constants));
		}
	}
	private void printHead(String string) {
		System.out.printf("========== %s ==========\n", string);
	}

}
