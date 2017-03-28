package com.bruxelas.api.builders;

import com.bruxelas.entities.CategoryConnectionType;
import com.bruxelas.entities.ConnectionType;

public class ConnectionTypeBuilder {

	private ConnectionType connectionType = new ConnectionType();
	
	public ConnectionType build(){
		return this.connectionType;
	}
	
	public ConnectionTypeBuilder withId(Long id){
		this.connectionType.setId(id);
		return this;
	}
	
	public ConnectionTypeBuilder withName(String name){
		this.connectionType.setName(name);
		return this;
	}
	
	public ConnectionTypeBuilder withCategory(CategoryConnectionType category){
		this.connectionType.setCategory(category);
		return this;
	}
	
}
