package org.stummi.jadis.code;

import java.io.DataInputStream;

import lombok.SneakyThrows;

import org.stummi.jadis.code.arg.InstructionArgument;
import org.stummi.jadis.code.arg.LookupSwitchInstructionArgument;
import org.stummi.jadis.code.arg.NulInstructionArgument;
import org.stummi.jadis.code.arg.PaddingInstructionArgument;
import org.stummi.jadis.code.arg.S16InstructionArgument;
import org.stummi.jadis.code.arg.S32InstructionArgument;
import org.stummi.jadis.code.arg.S8InstructionArgument;
import org.stummi.jadis.code.arg.TableSwitchInstructionArgument;
import org.stummi.jadis.code.arg.U16InstructionArgument;
import org.stummi.jadis.code.arg.U8InstructionArgument;

public enum MnemonicParam {
	U8(U8InstructionArgument.class),
	U16(U16InstructionArgument.class),
	S8(S8InstructionArgument.class),
	S16(S16InstructionArgument.class),
	S32(S32InstructionArgument.class),
	CONST_REF_U8(U8InstructionArgument.class),
	CONST_REF(U16InstructionArgument.class),
	NUL(NulInstructionArgument.class),
	TABLESWITCHDATA(TableSwitchInstructionArgument.class),
	LOOKUPSWITCHDATA(LookupSwitchInstructionArgument.class),
	PADDING(PaddingInstructionArgument.class),
	DONOTREAD(null);

	private final Class<? extends InstructionArgument> argumenClass;

	private MnemonicParam(Class<? extends InstructionArgument> argumentClass) {
		this.argumenClass = argumentClass;
	}

	@SneakyThrows
	public InstructionArgument readFromDataInputStream(int pos, DataInputStream dais) {
		InstructionArgument ia = argumenClass.newInstance();
		ia.readFromDataInputStream(pos, dais);
		return ia;
	}

}
