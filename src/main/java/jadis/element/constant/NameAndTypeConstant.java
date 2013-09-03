package jadis.element.constant;

import lombok.Value;

@Value
public class NameAndTypeConstant implements Constant {
	private final short nameId;
	private final short typeId;

	@Override
	public String toResolvedString(Constant[] constants) {
		StringConstant name = (StringConstant) constants[nameId];
		StringConstant type = (StringConstant) constants[typeId];
		return String.format("NameAndType: %s %s [%d %d]", name.getValue(),
				type.getValue(), nameId, typeId);
	}
}
