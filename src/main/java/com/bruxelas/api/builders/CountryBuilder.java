package com.bruxelas.api.builders;

import com.bruxelas.entities.Country;
import com.bruxelas.entities.Language;

public class CountryBuilder {

	private Country country = new Country();
	
	public CountryBuilder withId(Long id){
		this.country.setId(id);
		return this;
	}
	
	public CountryBuilder withName(String name){
		this.country.setName(name);
		return this;
	}
	
	public CountryBuilder withLanguage(Language language){
		this.country.setLanguage(language);
		return this;
	}
	
	public Country build(){
		return this.country;
	}
	
}
