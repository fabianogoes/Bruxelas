package com.bruxelas.builders;

import java.util.List;

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
	
	public CountryBuilder withLanguages(List<Language> languages){
		this.country.setLanguages(languages);
		return this;
	}
	
	public CountryBuilder withNativeName(String nativeName){
		this.country.setNativeName(nativeName);
		return this;
	}	
	
	public Country build(){
		return this.country;
	}
	
}
