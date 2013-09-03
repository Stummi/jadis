package jadis.element;

import jadis.element.accessflags.AccessFlag;

import java.util.List;

import lombok.Value;

@Value
public class FieldInfo implements Element {
	final List<AccessFlag> flags;
	final short nameIndex;
	final short descriptorIndex;
	final List<AttributeInfo> attributes;
}
