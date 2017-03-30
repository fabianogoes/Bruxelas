package com.bruxelas.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	public Version save(String build, String commit) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
		String buildDate = sdf.format(Calendar.getInstance().getTime());
		Version version = new Version(null, build, commit, buildDate); 
		version = this.repository.save(version);
		return version;
	}
	
}
