package jadis.element.constant;

import lombok.Value;

@Value
public class FieldRefConstant implements Constant {

	private final short classRef;
	private final short ntRef;

	@Override
	public String toResolvedString(Constant[] constants) {
		String s = StringUtilities.createResolvedClassNTRef(classRef, ntRef,
				constants);
		return String.format("Field: %s", s);
	}

}
