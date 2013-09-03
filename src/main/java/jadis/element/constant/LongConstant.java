package jadis.element.constant;

import lombok.Value;

@Value
public class LongConstant implements Constant {
	private long value;

	@Override
	public String toResolvedString(Constant[] constants) {
		return String.format("Long: %d", value);
	}
}
