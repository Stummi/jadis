package jadis.element.constant;

import lombok.Value;

@Value
public class DoubleConstant implements Constant {

	private final double value;

	@Override
	public String toResolvedString(Constant[] constants) {
		return String.format("Double: %f", value);
	}

}
