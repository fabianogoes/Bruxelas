package com.bruxelas.api.helpers;

import com.bruxelas.api.builders.ConnectionTypeBuilder;
import com.bruxelas.entities.CategoryConnectionType;
import com.bruxelas.entities.ConnectionType;

public class EntityAnyValueHelper {

	public static ConnectionType anyConnectionTypeIdNull(){
		return new ConnectionTypeBuilder()
				.withId(null)
				.withName(RandomValueGeneratorHelper.anyString(10))
				.withCategory(CategoryConnectionType.ENGLISH)
				.build();
	}
	
	public static ConnectionType anyConnectionType(){
		return new ConnectionTypeBuilder()
				.withId(RandomValueGeneratorHelper.anyLong())
				.withName(RandomValueGeneratorHelper.anyString(10))
				.withCategory(CategoryConnectionType.ENGLISH)
				.build();
	}
	
}
