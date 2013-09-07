package org.stummi.jadis.code;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ByteCode {
	private List<Instruction> instructions;

}
