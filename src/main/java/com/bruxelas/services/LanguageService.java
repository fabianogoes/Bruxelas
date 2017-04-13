package com.bruxelas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.Language;
import com.bruxelas.repositories.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	public List<Language> findAll() {
		return (List<Language>) this.languageRepository.findAll();
	}

	public Language save(Language language) {
		return this.languageRepository.save(language);
	}

}
