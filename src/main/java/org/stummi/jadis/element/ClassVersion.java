package org.stummi.jadis.element;

import lombok.Value;

@Value
public class ClassVersion implements Element {
	int major, minor;
}
