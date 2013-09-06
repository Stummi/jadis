package org.stummi.jadis.element.attribute;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class AbstractAttribute implements Attribute {
	private int nameRef;

	@Override
	@SneakyThrows
	public void setAttributeData(byte[] bytes) {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(bais);
		readAttributeData(dis);
	}

	@Override
	@SneakyThrows
	public byte[] getAttributeData() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		writeAttributeData(dos);
		return baos.toByteArray();
	}

	protected void writeAttributeData(DataOutputStream dos) throws IOException {
		throw new UnsupportedOperationException("writing is not supported yet");
	};

	protected abstract void readAttributeData(DataInputStream dis)
			throws IOException;

}
