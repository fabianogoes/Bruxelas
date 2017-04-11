package com.bruxelas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.LanguagesYouSpeak;
import com.bruxelas.repositories.LanguagesYouSpeakRepository;

@Service
public class LanguagesYouSpeakService {

	@Autowired
	private LanguagesYouSpeakRepository LanguagesYouSpeakRepository;

	public LanguagesYouSpeak save(LanguagesYouSpeak languagesYouSpeak) {
		return this.LanguagesYouSpeakRepository.save(languagesYouSpeak);
	}
	
	
	
}
