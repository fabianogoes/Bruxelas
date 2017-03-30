package com.bruxelas.api.builders;

import com.bruxelas.entities.Country;

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
	
	public CountryBuilder withNationality(String nationality){
		this.country.setNationality(nationality);
		return this;
	}
	
	public CountryBuilder withLivingIn(String livingIn){
		this.country.setLivingIn(livingIn);
		return this;
	}
	
	public CountryBuilder withNativeLanguage(String nativeLanguage){
		this.country.setNativeLanguage(nativeLanguage);
		return this;
	}
	
	public Country build(){
		return this.country;
	}
	
}
