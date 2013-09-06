package org.stummi.jadis.output.dump;

import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.element.ClassVersion;
import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.FieldInfo;
import org.stummi.jadis.element.MethodInfo;
import org.stummi.jadis.element.accessflags.AccessFlag;
import org.stummi.jadis.element.attribute.Attribute;
import org.stummi.jadis.element.constant.Constant;
import org.stummi.jadis.element.constant.StringConstant;

@RequiredArgsConstructor
public class SimpleDumper {
	private final ClassFile cf;
	private final PrintStream out;

	private AttributeDumperMap dumperMap;

	public void dump() {
		dumpHeader();
		dumpConstantPool();
		dumpClassDef();
		dumpInterfaces();
		dumpFields();
		dumpMethods();
		dumpAttributes();
	}

	private String getConstantPoolString(int nameIndex) {
		Constant c = cf.getConstantPool().getConstant(nameIndex);
		return ((StringConstant) c).getValue();
	}

	public void dumpHeader() {
		printHead("HEADER");
		ClassVersion version = cf.getVersion();
		Constant c = cf.getConstantPool().getConstant(cf.getThisClassId());
		out.println("Jadis Class File Dump");
		out.printf("For %s\n", c.toResolvedString(cf.getConstantPool()));
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
			out.printf("%s: %s\n", idx, c.toResolvedString(constantPool));
		}
	}

	public void dumpClassDef() {
		printHead("CLASS");
		ConstantPool constantPool = cf.getConstantPool();
		List<AccessFlag> accessFlags = cf.getAccessFlags();
		int thisClassId = cf.getThisClassId();
		int superClassId = cf.getSuperClassId();

		out.printf("Accessflags: %s\n", accessFlags);
		Constant thisClass = constantPool.getConstant(thisClassId);
		Constant superClass = constantPool.getConstant(superClassId);
		out.printf("this: %s\n", thisClass.toResolvedString(constantPool));
		out.printf(
				"super: %s\n",
				(superClass == null ? "<NULL>" : superClass
						.toResolvedString(constantPool)));

	}

	public void dumpInterfaces() {
		printHead("INTERFACES");
		ConstantPool constantPool = cf.getConstantPool();
		List<Integer> interfaces = cf.getInterfaces();
		for (Integer s : interfaces) {
			out.println(constantPool.getConstant(s).toResolvedString(
					constantPool));
		}
	}

	public void dumpFields() {
		printHead("FIELDS");
		List<FieldInfo> fields = cf.getFields();
		for (FieldInfo fi : fields) {
			String name = getConstantPoolString(fi.getNameRef());
			String descriptor = getConstantPoolString(fi.getDescriptorRef());
			out.printf("%s %s %s\n", fi.getFlags(), name, descriptor);
			dumpAttributeList(fi.getAttributes(), 1);
		}
	}

	public void dumpMethods() {
		printHead("METHODS");
		List<MethodInfo> methods = cf.getMethods();
		for (MethodInfo mi : methods) {
			String name = getConstantPoolString(mi.getNameIndex());
			String descriptor = getConstantPoolString(mi.getDescriptorIndex());
			out.printf("%s %s %s\n", mi.getFlags(), name, descriptor);
			dumpAttributeList(mi.getAttributes(), 1);

		}
	}

	public void dumpAttributes() {
		printHead("ATTRIBUTES");
		List<Attribute> attributes = cf.getAttributes();
		dumpAttributeList(attributes, 0);
	}

	public void dumpAttributeList(List<Attribute> attributes, int indent) {
		for (Attribute a : attributes) {
			dumpAttribute(a, indent);
		}
	}

	public <T extends Attribute> void dumpAttribute(T a, int indent) {
		for (int idx = 0; idx < indent; idx++) {
			out.print("    ");
		}

		out.print("Attribute: ");
		String attributeName = getConstantPoolString(a.getNameRef());
		out.println(attributeName);

		if (dumperMap == null) {
			initDumperMap();
		}

		AttributeDumper<T> dumper = dumperMap.getDumper(a.getClass());

		dumper.dumpAttribute(a, cf, indent + 1, out);
	}

	private void initDumperMap() {
		dumperMap = new AttributeDumperMap();

	}

	private void printHead(String string) {
		System.out.printf("========== %s ==========\n", string);
	}

}
