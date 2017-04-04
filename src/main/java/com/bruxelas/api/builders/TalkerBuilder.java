package com.bruxelas.api.builders;

import com.bruxelas.entities.Country;
import com.bruxelas.entities.Language;
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
	
	public TalkerBuilder withBornIn(Country bornIn){
		this.talker.setBornIn(bornIn);
		return this;
	}
	
	public TalkerBuilder withLivingIn(Country livingIn){
		this.talker.setLivingIn(livingIn);
		return this;
	}
	
	public TalkerBuilder withNativeLanguage(Language nativeLanguage){
		this.talker.setNativeLanguage(nativeLanguage);
		return this;
	}
	
}
