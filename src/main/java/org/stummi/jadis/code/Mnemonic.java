package org.stummi.jadis.code;

import static org.stummi.jadis.code.MnemonicParam.*;

import java.util.HashMap;
import java.util.Map;

public enum Mnemonic {
	AALOAD(0x32),
	AASTORE(0x53),
	ACONST_NULL(0x01),
	ALOAD(0x19, U8),
	ALOAD_0(0x2a),
	ALOAD_1(0x2b),
	ALOAD_2(0x2c),
	ALOAD_3(0x2d),
	ANEWARRAY(0xbd, CONST_REF),
	ARETURN(0xB0),
	ARRAYLENGTH(0xbe),
	ASTORE(0x3a, U8),
	ASTORE_0(0x4b),
	ASTORE_1(0x4c),
	ASTORE_2(0x4d),
	ASTORE_3(0x4e),
	ATHROW(0xBF),
	BALOAD(0x33),
	BASTORE(0x54),
	BIPUSH(0x10, S8),
	CALOAD(0x34),
	CASTORE(0x55),
	CHECKCAST(0xC0, CONST_REF),
	D2F(0x90),
	D2I(0x8e),
	D2L(0x8f),
	DADD(0x63),
	DALOAD(0x31),
	DASTORE(0x52),
	DCMPG(0x98),
	DCMPL(0x97),
	DCONST_0(0x0e),
	DCONST_1(0x0f),
	DDIV(0x6f),
	DLOAD(0x18, U8),
	DLOAD_0(0x26),
	DLOAD_1(0x27),
	DLOAD_2(0x28),
	DLOAD_3(0x29),
	DMUL(0x6B),
	DNEG(0x77),
	DREM(0x73),
	DRETURN(0xAF),
	DSTORE(0x39, U8),
	DSTORE_0(0x47),
	DSTORE_1(0x48),
	DSTORE_2(0x49),
	DSTORE_3(0x4a),
	DSUB(0x67),
	DUP(0x59),
	DUP_X1(0x5a),
	DUP_X2(0x5b),
	DUP2(0x5c),
	DUP2_X1(0x5d),
	DUP2_X2(0x5e),
	F2D(0x8D),
	F2I(0x8B),
	F2L(0x8C),
	FADD(0x62),
	FALOAD(0x30),
	FASTORE(0x51),
	FCMPG(0x96),
	FCMPL(0x95),
	FCONST_0(0x0b),
	FCONST_1(0x0c),
	FCONST_2(0x0d),
	FDIV(0x6e),
	FLOAD(0x17, U8),
	FLOAD_0(0x22),
	FLOAD_1(0x23),
	FLOAD_2(0x24),
	FLOAD_3(0x25),
	FMUL(0x6a),
	FNEG(0x76),
	FREM(0x72),
	FRETURN(0xAE),
	FSTORE(0x38, U8),
	FSTORE_0(0x43),
	FSTORE_1(0x44),
	FSTORE_2(0x45),
	FSTORE_3(0x46),
	FSUB(0x66),
	GETFIELD(0xb4, CONST_REF),
	GETSTATIC(0xb2, CONST_REF),
	GOTO(0xa7, S16),
	GOTO_W(0xc8, S32),
	I2B(0x91),
	I2C(0x92),
	I2D(0x87),
	I2F(0x86),
	I2L(0x85),
	I2S(0x93),
	IADD(0x60),
	IALOAD(0x2e),
	IAND(0x7e),
	IASTORE(0x4f),
	ICONST_M1(0x02),
	ICONST_0(0x03),
	ICONST_1(0x04),
	ICONST_2(0x05),
	ICONST_3(0x06),
	ICONST_4(0x07),
	ICONST_5(0x08),
	IDIV(0x6c),
	IF_ACMPEQ(0xa5, S16),
	IF_ACMPNE(0xa6, S16),
	IF_ICMPEQ(0x9f, S16),
	IF_ICMPNE(0xa0, S16),
	IF_ICMPLT(0xa1, S16),
	IF_ICMPGE(0xa2, S16),
	IF_ICMPGT(0xa3, S16),
	IF_ICMPLE(0xa4, S16),
	IFEQ(0x99, S16),
	IFNE(0x9a, S16),
	IFLT(0x9b, S16),
	IFGE(0x9c, S16),
	IFGT(0x9d, S16),
	IFLE(0x9e, S16),
	IFNONNULL(0xc7, S16),
	IFNULL(0xc6, S16),
	IINC(0x84, U8, S8),
	ILOAD(0x15, U8),
	ILOAD_0(0x1a),
	ILOAD_1(0x1b),
	ILOAD_2(0x1c),
	ILOAD_3(0x1d),
	IMUL(0x68),
	INEG(0x74),
	INSTANCEOF(0xC1, CONST_REF),
	INVOKEDYNAMIC(0xba, CONST_REF, NUL, NUL),
	INVOKEINTERFACE(0xb9, CONST_REF, U8, NUL),
	INVOKESPECIAL(0xb7, CONST_REF),
	INVOKESTATIC(0xb8, CONST_REF),
	INVOKEVIRTUAL(0xb6, CONST_REF),
	IOR(0x80),
	IREM(0x70),
	IRETURN(0xAC),
	ISHL(0x78),
	ISHR(0x7A),
	ISTORE(0x36, U8),
	ISTORE_0(0x3B),
	ISTORE_1(0x3C),
	ISTORE_2(0x3D),
	ISTORE_3(0x3E),
	ISUB(0x64),
	IUSHR(0x7c),
	IXOR(0x82),
	JSR(0xa8, S16),
	JSR_W(0xc9, S32),
	L2D(0x8a),
	L2F(0x89),
	L2I(0x88),
	LADD(0x61),
	LALOAD(0x2F),
	LAND(0x7F),
	LASTORE(0x50),
	LCMP(0x94),
	LCONST_0(0x09),
	LCONST_1(0x0A),
	LDC(0x12, CONST_REF_U8),
	LDC_W(0x13, CONST_REF),
	LDC2_W(0x14, CONST_REF),
	LDIV(0x6d),
	LLOAD(0x16, U8),
	LLOAD_0(0x1e),
	LLOAD_1(0x1f),
	LLOAD_2(0x20),
	LLOAD_3(0x21),
	LMUL(0x69),
	LNEG(0x75),
	LOOKUPSWITCH(0xAB, PADDING, LOOKUPSWITCHDATA),
	LOR(0x81),
	LREM(0x71),
	LRETURN(0xAD),
	LSHL(0x79),
	LSHR(0x7B),
	LSTORE(0x37, U8),
	LSTORE_0(0x3f),
	LSTORE_1(0x40),
	LSTORE_2(0x41),
	LSTORE_3(0x42),
	LSUB(0x65),
	LUSHR(0x7D),
	LXOR(0x83),
	MONITORENTER(0xc2),
	MONITOREXIT(0xc3),
	MULTIANEWARRAY(0xc5, CONST_REF, U8),
	NEW(0xbb, CONST_REF),
	NEWARRAY(0xBC, U8),
	NOP(0x00),
	POP(0x57),
	POP2(0x58),
	PUTFIELD(0xb5, CONST_REF),
	PUTSTATIC(0xb3, CONST_REF),
	RET(0xA9, U8),
	RETURN(0xb1),
	SALOAD(0x35),
	SASTORE(0x56),
	SIPUSH(0x11, S16),
	SWAP(0x5F),
	TABLESWITCH(0xAA, PADDING, TABLESWITCHDATA),
	
	WIDE(0xC4, DONOTREAD),
	WIDE_ILOAD(true, 0x15, U16),
	WIDE_LLOAD(true, 0x16, U16),
	WIDE_FLOAD(true, 0x17, U16),
	WIDE_DLOAD(true, 0x18, U16),
	WIDE_ALOAD(true, 0x19, U16),
	WIDE_ISTORE(true, 0x36, U16),
	WIDE_LSTORE(true, 0x37, U16),
	WIDE_FSTORE(true, 0x38, U16),
	WIDE_DSTORE(true, 0x39, U16),
	WIDE_ASTORE(true, 0x3A, U16),
	WIDE_RET(true, 0xa9, U16),
	WIDE_IINC(true, 0x84, U16, S16)
	;

	private int opCode;
	private MnemonicParam[] params;
	private boolean wide;

	private static final Map<Integer, Mnemonic> byOpCode;
	private static final Map<Integer, Mnemonic> widesByOpCode;

	static {
		widesByOpCode = new HashMap<>();
		byOpCode = new HashMap<>();

		for (Mnemonic v : values()) {
			Map<Integer, Mnemonic> useMap;
			if (v.wide) {
				useMap = widesByOpCode;
			} else {
				useMap = byOpCode;
			}

			Mnemonic cv = useMap.get(v.opCode);
			if (cv != null) {
				String errorMsg = String.format(
						"Duplicate %s opcode: %02x (%s/%s)", v.wide ? "wide"
								: "", v.opCode, cv, v);
				throw new RuntimeException(errorMsg);
			}
			useMap.put(v.opCode, v);
		}
	}

	private Mnemonic(int opCode, MnemonicParam... params) {
		this(false, opCode, params);
	}

	private Mnemonic(boolean wide, int opCode, MnemonicParam... params) {
		this.wide = wide;
		this.opCode = opCode;
		this.params = params;
	}

	public static Mnemonic forOpCode(int opCode, boolean wide) {
		if (wide) {
			return widesByOpCode.get(opCode);
		} else {
			return byOpCode.get(opCode);
		}
	}
	public MnemonicParam[] getParams() {
		return params;
	}
}
