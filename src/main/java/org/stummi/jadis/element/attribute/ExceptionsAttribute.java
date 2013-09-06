package org.stummi.jadis.element.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExceptionsAttribute extends AbstractAttribute {

	private List<Integer> exceptionRefs;

	@Override
	protected void writeAttributeData(DataOutputStream dos) throws IOException {
		dos.writeShort(exceptionRefs.size());
		for (Integer i : exceptionRefs) {
			dos.writeShort(i);
		}
	}

	@Override
	protected void readAttributeData(DataInputStream dis) throws IOException {
		int len = dis.readShort();
		exceptionRefs = new LinkedList<>();
		for (int idx = 0; idx < len; idx++) {
			exceptionRefs.add(dis.readUnsignedShort());
		}
	}

}
