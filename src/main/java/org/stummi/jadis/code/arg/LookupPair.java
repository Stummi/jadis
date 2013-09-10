package org.stummi.jadis.code.arg;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LookupPair {
	int match;
	int offset;
}
