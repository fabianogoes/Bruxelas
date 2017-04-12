package com.bruxelas.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.Country;
import com.bruxelas.entities.Language;
import com.bruxelas.entities.LanguagesYouSpeak;
import com.bruxelas.entities.Talker;
import com.bruxelas.repositories.TalkerRepository;

@Service
public class TalkerService {

	private static final Logger logger = LoggerFactory.getLogger(TalkerService.class);
	
	@Autowired
	private TalkerRepository repository;
	
	@Autowired
	private CountryService countryService; 
	
	@Autowired
	private LanguageService languageService;
	
	@Autowired
	private LanguagesYouSpeakService LanguagesYouSpeakService;
	
	public Talker save(Talker talker) {
		logger.info("save("+talker+")");
		talker = this.repository.save(talker);
		return talker;
	}

	public List<Talker> findAll() {
		logger.info("findAll()");
		return (List<Talker>) this.repository.findAll();
	}

	public Talker findOne(long id) {
		logger.info("findOne("+id+")");
		return this.repository.findOne(id);
	}

	public void delete(long id) {
		logger.info("delete("+id+")");
		this.repository.delete(id);
	}

	public List<Country> findAllCountries() {
		return this.countryService.findAll();
	}

	public List<Language> findAllLanguages() {
		return this.languageService.findAll();
	}

	public LanguagesYouSpeak addLanguageLearn(LanguagesYouSpeak languagesYouSpeak) {
		return this.LanguagesYouSpeakService.save(languagesYouSpeak);
	}

	public List<LanguagesYouSpeak> findLanguageLearnByTalker(Long talkerId) {
		return this.LanguagesYouSpeakService.findByTalkerId(talkerId);
	}
}
