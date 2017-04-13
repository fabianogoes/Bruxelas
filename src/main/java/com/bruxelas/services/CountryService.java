package com.bruxelas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.Country;
import com.bruxelas.entities.Language;
import com.bruxelas.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private LanguageService languageService;

	public List<Country> findAll() {
		return (List<Country>) this.countryRepository.findAll();
	}
	
	public Country save(Country country){
		for (Language language : country.getLanguages()) {
			this.languageService.save(language);
		}
		this.countryRepository.save(country);
		return country;
	}

	public Country findOne(Long id) {
		return this.countryRepository.findOne(id);
	}

	public void delete(Long id) {
		this.countryRepository.delete(id);
	}

}
