package jadis.element.constant;

import lombok.Value;

@Value
public class IntegerConstant implements Constant {

	private final int value;

	@Override
	public String toResolvedString(Constant[] constants) {
		return String.format("Integer: %d", value);
	}

}
