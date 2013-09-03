package jadis.element.constant;

import lombok.Value;

@Value
public class StringConstant implements Constant {

	private final String value;

	@Override
	public String toResolvedString(Constant[] constants) {
		return String.format("String: %s", value);
	}

}
