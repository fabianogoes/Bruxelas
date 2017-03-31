package com.bruxelas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.Country;
import com.bruxelas.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> findAll() {
		return (List<Country>) this.countryRepository.findAll();
	}
	
	
	
}
