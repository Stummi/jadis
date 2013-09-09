package org.stummi.jadis.output.dump.attribute;

import java.io.IOException;

import org.stummi.jadis.code.ByteCode;
import org.stummi.jadis.code.ByteCodeParser;
import org.stummi.jadis.code.Instruction;
import org.stummi.jadis.code.Mnemonic;
import org.stummi.jadis.code.MnemonicParam;
import org.stummi.jadis.element.ConstantPool;
import org.stummi.jadis.element.attribute.CodeAttribute;
import org.stummi.jadis.element.attribute.ExceptionEntry;

public class CodeAttributeDumper extends AbstractAttributeDumper<CodeAttribute> {

	@Override
	protected void dumpAttribute(CodeAttribute attribute) throws IOException {
		printfln("max_stack: %d", attribute.getMaxStack());
		printfln("max_locals: %d", attribute.getMaxLocals());
		printfln("code: ");
		indent++;
		dumpCode(attribute.getCode());
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

	private void dumpCode(byte[] code) throws IOException {
		ByteCodeParser bcp = new ByteCodeParser();

		ByteCode bc = bcp.parse(code);
		for (Instruction i : bc.getInstructions()) {
			printIndent();
			Mnemonic mnemonic = i.getMnemonic();
			MnemonicParam[] mnemonicParams = mnemonic.getParams();
			Integer[] instructionArgs = i.getArgs();

			out.printf(i.getMnemonic().toString());
			for (int idx = 0; idx < mnemonicParams.length; idx++) {
				MnemonicParam paramType = mnemonicParams[idx];
				Integer instructionArg = instructionArgs[idx];
				printInstructionArg(paramType, instructionArg);
			}
			out.println();
		}
	}

	private void printInstructionArg(MnemonicParam paramType, Integer arg) {
		switch (paramType) {
		case NUL:
			break;
		case CONST_REF:
			ConstantPool cp = classFile.getConstantPool();
			out.printf(" (%d -> %s)", arg, cp.getConstant(arg)
					.toResolvedString(cp));
			break;
		default:
			out.printf(" %d", arg);
			break;
		}
	}
}
