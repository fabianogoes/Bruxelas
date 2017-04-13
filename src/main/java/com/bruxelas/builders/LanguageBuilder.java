package com.bruxelas.builders;

import com.bruxelas.entities.Language;

public class LanguageBuilder {

	private Language language = new Language();
	
	public Language build(){
		return this.language;
	}
	
	public LanguageBuilder withId(Long id){
		this.language.setId(id);
		return this;
	}
	
	public LanguageBuilder withName(String name){
		this.language.setName(name);
		return this;
	}
	
}
