package jadis.element;

import jadis.element.accessflags.AccessFlag;
import jadis.element.constant.Constant;
import jadis.element.constant.StringConstant;

import java.io.PrintStream;
import java.util.List;

import lombok.Value;

@Value
public class ClassFile implements Element {
	final private ClassVersion version;
	final private ConstantPool constantPool;
	final private List<AccessFlag> accessFlags;
	final short thisClassId;
	final short superClassId;
	final private List<Short> interfaces;
	final private List<FieldInfo> fields;
	final private List<MethodInfo> methods;
	final private List<AttributeInfo> attributes;

	public void dump(PrintStream out) {
		out.println("-------------------");
		out.println("Class Version: " + version.getMajor() + "."
				+ version.getMinor());
		out.println("-------------------");
		Constant[] constants = constantPool.getConstants();
		out.println("Constants: ");
		for (int idx = 0; idx < constants.length; idx++) {
			Constant c = constants[idx];
			if (c == null) {
				continue;
			}
			out.println(idx + ": " + c.toResolvedString(constants));
		}
		out.println("-------------------");
		out.println("Accessflags: " + accessFlags);
		Constant thisClass = constantPool.getConstant(thisClassId);
		Constant superClass = constantPool.getConstant(superClassId);
		out.println("this: " + thisClass.toResolvedString(constants));
		out.println("super: "
				+ (superClass == null ? "<NULL>" : superClass
						.toResolvedString(constants)));
		out.println("-------------------");
		out.println("Interfaces: ");
		for (Short s : interfaces) {
			out.println(constantPool.getConstant(s).toResolvedString(
					constantPool.getConstants()));
		}
		out.println("-------------------");
		out.println("Fields: ");
		for (FieldInfo fi : fields) {
			StringConstant nameConstant = (StringConstant) constantPool
					.getConstant(fi.getNameIndex());
			StringConstant descriptorConstant = (StringConstant) constantPool
					.getConstant(fi.getDescriptorIndex());
			out.println(fi.getFlags() + " "
					+ nameConstant.getValue() + " "
					+ descriptorConstant.getValue());
			for (AttributeInfo ai : fi.getAttributes()) {
				Constant aNameConstant = constantPool.getConstant(ai
						.getNameIndex());
				out.println("    "
						+ aNameConstant.toResolvedString(constants));
			}
		}

		out.println("-------------------");
		out.println("Methods: ");
		for (MethodInfo fi : methods) {
			StringConstant nameConstant = (StringConstant) constantPool
					.getConstant(fi.getNameIndex());
			StringConstant descriptorConstant = (StringConstant) constantPool
					.getConstant(fi.getDescriptorIndex());
			out.println(fi.getFlags() + " "
					+ nameConstant.getValue() + " "
					+ descriptorConstant.getValue());
			for (AttributeInfo ai : fi.getAttributes()) {
				Constant aNameConstant = constantPool.getConstant(ai
						.getNameIndex());
				out.println("    "
						+ aNameConstant.toResolvedString(constants));
			}
		}

		out.println("-------------------");
		out.println("Attributes: ");
		for (AttributeInfo ai : attributes) {
			Constant aNameConstant = constantPool
					.getConstant(ai.getNameIndex());
			out.println("    "
					+ aNameConstant.toResolvedString(constants));
		}
	}
}
