package org.stummi.jadis.element.attribute;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.stummi.jadis.element.accessflags.AccessFlag;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InnerClassEntry {
	int innerClassInfoIndex;
	int outerClassInfoIndex;
	int innerNameIndex;
	List<AccessFlag> innerClassAccessFlags;
}
