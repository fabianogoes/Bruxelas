package com.bruxelas.api.builders;

import com.bruxelas.entities.NacionalityType;
import com.bruxelas.entities.Talker;

public class TalkerBuilder {

	private Talker talker = new Talker();
	
	public Talker build(){
		return this.talker;
	}
	
	public TalkerBuilder withId(Long id){
		this.talker.setId(id);
		return this;
	}
	
	public TalkerBuilder withName(String name){
		this.talker.setName(name);
		return this;
	}
	
	public TalkerBuilder withNacionality(NacionalityType nacionality){
		this.talker.setNacionality(nacionality);
		return this;
	}
	
	public TalkerBuilder withLivingIn(NacionalityType livingIn){
		this.talker.setLivingIn(livingIn);
		return this;
	}
	
}
