package com.bruxelas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.Version;
import com.bruxelas.repositories.VersionRepository;

@Service
public class VersionService {

	@Autowired
	private VersionRepository repository;
	
	public Version findActualVersion(){
		Version version = repository.findActualVersion();
		return version;
	}

	public Version save(Version version) {
		version = this.repository.save(version);
		return version;
	}
	
}
