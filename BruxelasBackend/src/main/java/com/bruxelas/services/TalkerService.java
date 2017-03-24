package com.bruxelas.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.Talker;
import com.bruxelas.repositories.TalkerRepository;

@Service
public class TalkerService {

	private static final Logger logger = LoggerFactory.getLogger(TalkerService.class);
	
	@Autowired
	private TalkerRepository talkerRepository;
	
	public Talker save(Talker talker) {
		logger.info("save("+talker+")");
		talker = this.talkerRepository.save(talker);
		return talker;
	}

	public List<Talker> findAll() {
		logger.info("findAll()");
		return (List<Talker>) this.talkerRepository.findAll();
	}

}
