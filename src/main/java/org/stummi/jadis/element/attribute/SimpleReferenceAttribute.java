package org.stummi.jadis.element.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleReferenceAttribute extends AbstractAttribute {

	private int constantRef;

	@Override
	protected void readAttributeData(DataInputStream dis) throws IOException {
		this.constantRef = dis.readUnsignedShort();
	}

	@Override
	protected void writeAttributeData(DataOutputStream dos) throws IOException {
		dos.writeShort(constantRef);

	}


}
