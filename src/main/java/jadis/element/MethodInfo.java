package jadis.element;

import jadis.element.accessflags.AccessFlag;

import java.util.List;

import lombok.Value;

@Value
public class MethodInfo implements Element {
	final private List<AccessFlag> flags;
	final private short nameIndex;
	final private short descriptorIndex;
	final private List<AttributeInfo> attributes;
	
}
