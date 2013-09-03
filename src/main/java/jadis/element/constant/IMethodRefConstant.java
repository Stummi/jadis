package jadis.element.constant;

import lombok.Value;

@Value
public class IMethodRefConstant implements Constant {
	private final short classId;
	private final short ntId;

	@Override
	public String toResolvedString(Constant[] constants) {
		return String.format("IMethod: %d %d", classId, ntId);
	}
}
