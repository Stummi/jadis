package jadis.element.constant;

import lombok.Value;

@Value
public class ClassConstant implements Constant {
	private final short refId;

	@Override
	public String toResolvedString(Constant[] constants) {
		String className = ((StringConstant) constants[refId]).getValue();
		return String.format("Class: %s [%d]", className, refId);
	}
}
