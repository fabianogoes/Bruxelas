package com.bruxelas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bruxelas.entities.LanguagesYouSpeak;

public interface LanguagesYouSpeakRepository extends CrudRepository<LanguagesYouSpeak, Long> {

	List<LanguagesYouSpeak> findByTalkerId(Long talkerId);

}
