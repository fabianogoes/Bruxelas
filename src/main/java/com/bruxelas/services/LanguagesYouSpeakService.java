package com.bruxelas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.LanguagesYouSpeak;
import com.bruxelas.repositories.LanguagesYouSpeakRepository;

@Service
public class LanguagesYouSpeakService {

	@Autowired
	private LanguagesYouSpeakRepository languagesYouSpeakRepository;

	public LanguagesYouSpeak save(LanguagesYouSpeak languagesYouSpeak) {
		return this.languagesYouSpeakRepository.save(languagesYouSpeak);
	}

	public List<LanguagesYouSpeak> findByTalkerId(Long talkerId) {
		return this.languagesYouSpeakRepository.findByTalkerId(talkerId);
	}

	public void delete(Long languageId) {
		this.languagesYouSpeakRepository.delete(languageId);;
	}
	
	
	
}
