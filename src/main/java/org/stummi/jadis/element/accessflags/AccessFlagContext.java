package org.stummi.jadis.element.accessflags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Value;

@Value
class AccessFlagMask {
	private final int mask;
	private final AccessFlag flag;
}

public final class AccessFlagContext {
	private static final AccessFlagMask[] CLASS_FLAGS = {
			new AccessFlagMask(0x0001, AccessFlag.PUBLIC),
			new AccessFlagMask(0x0010, AccessFlag.FINAL),
			new AccessFlagMask(0x0020, AccessFlag.SUPER),
			new AccessFlagMask(0x0200, AccessFlag.INTERFACE),
			new AccessFlagMask(0x0400, AccessFlag.ABSTRACT),
			new AccessFlagMask(0x1000, AccessFlag.SYNTHETIC),
			new AccessFlagMask(0x2000, AccessFlag.ANNOTATION),
			new AccessFlagMask(0x4000, AccessFlag.ENUM) };

	private static final AccessFlagMask[] FIELD_FLAGS = {
			new AccessFlagMask(0x0001, AccessFlag.PUBLIC),
			new AccessFlagMask(0x0002, AccessFlag.PRIVATE),
			new AccessFlagMask(0x0004, AccessFlag.PROTECTED),
			new AccessFlagMask(0x0008, AccessFlag.STATIC),
			new AccessFlagMask(0x0010, AccessFlag.FINAL),
			new AccessFlagMask(0x0040, AccessFlag.VOLATILE),
			new AccessFlagMask(0x0080, AccessFlag.TRANSIENT),
			new AccessFlagMask(0x1000, AccessFlag.SYNTHETIC),
			new AccessFlagMask(0x4000, AccessFlag.ENUM) };

	private static final AccessFlagMask[] METHOD_FLAGS = {
			new AccessFlagMask(0x0001, AccessFlag.PUBLIC),
			new AccessFlagMask(0x0002, AccessFlag.PRIVATE),
			new AccessFlagMask(0x0004, AccessFlag.PROTECTED),
			new AccessFlagMask(0x0008, AccessFlag.STATIC),
			new AccessFlagMask(0x0010, AccessFlag.FINAL),
			new AccessFlagMask(0x0020, AccessFlag.SYNCHRONIZED),
			new AccessFlagMask(0x0040, AccessFlag.BRIDGE),
			new AccessFlagMask(0x0080, AccessFlag.VARARGS),
			new AccessFlagMask(0x0100, AccessFlag.NATIVE),
			new AccessFlagMask(0x0400, AccessFlag.ABSTRACT),
			new AccessFlagMask(0x0800, AccessFlag.STRICT),
			new AccessFlagMask(0x1000, AccessFlag.SYNTHETIC), };

	private static final AccessFlagMask[] NESTED_FLAGS = {
			new AccessFlagMask(0x0001, AccessFlag.PUBLIC),
			new AccessFlagMask(0x0002, AccessFlag.PRIVATE),
			new AccessFlagMask(0x0004, AccessFlag.PROTECTED),
			new AccessFlagMask(0x0008, AccessFlag.STATIC),
			new AccessFlagMask(0x0010, AccessFlag.FINAL),
			new AccessFlagMask(0x0200, AccessFlag.INTERFACE),
			new AccessFlagMask(0x0400, AccessFlag.ABSTRACT),
			new AccessFlagMask(0x1000, AccessFlag.SYNTHETIC),
			new AccessFlagMask(0x2000, AccessFlag.ANNOTATION),
			new AccessFlagMask(0x4000, AccessFlag.ENUM) };

	public static final AccessFlagContext CLASS = new AccessFlagContext(
			CLASS_FLAGS);
	public static final AccessFlagContext FIELD = new AccessFlagContext(
			FIELD_FLAGS);
	public static final AccessFlagContext METHOD = new AccessFlagContext(
			METHOD_FLAGS);
	public static final AccessFlagContext NESTED = new AccessFlagContext(
			NESTED_FLAGS);

	private AccessFlagMask[] flagMasks;

	private AccessFlagContext(AccessFlagMask[] flagMasks) {
		this.flagMasks = flagMasks;
	}

	public List<AccessFlag> bitsToFlags(int bits) {
		List<AccessFlag> flagList = new ArrayList<>();
		for (AccessFlagMask afm : flagMasks) {
			if ((bits & afm.getMask()) > 0) {
				flagList.add(afm.getFlag());
				bits ^= afm.getMask();
			}
		}
		if (bits != 0) {
			throw new IllegalArgumentException("unknown Flags: " + bits);
		}
		return Collections.unmodifiableList(flagList);
	}
}
