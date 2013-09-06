package org.stummi.jadis.output.dump.attribute;

import org.stummi.jadis.element.attribute.CodeAttribute;
import org.stummi.jadis.element.attribute.ExceptionEntry;

public class CodeAttributeDumper extends AbstractAttributeDumper<CodeAttribute> {

	@Override
	protected void dumpAttribute(CodeAttribute attribute) {
		printfln("max_stack: %d", attribute.getMaxStack());
		printfln("max_locals: %d", attribute.getMaxLocals());
		printfln("code: ");
		indent++;
		printHexDump(attribute.getCode());
		indent--;
		printfln("exception handlers:");
		indent++;
		for (ExceptionEntry ee : attribute.getExceptions()) {
			int startPos = ee.getStartPc();
			int endPos = ee.getEndPc();
			int handlerPos = ee.getHandlerPc();
			int catchType = ee.getCatchType();
			String type = classFile.getConstantPool().getClassConstantName(
					catchType);
			printfln("try from %d to %d catch %s at %d", startPos, endPos,
					type, handlerPos);
		}
		indent--;

	}
}
