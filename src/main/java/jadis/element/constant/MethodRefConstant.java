package jadis.element.constant;

import lombok.Value;

@Value
public class MethodRefConstant implements Constant {

	private final short classId;
	private final short nameAndTypeId;

	@Override
	public String toResolvedString(Constant[] constants) {
		return String.format("Method: %s", StringUtilities
				.createResolvedClassNTRef(classId, nameAndTypeId, constants));
	}

}
