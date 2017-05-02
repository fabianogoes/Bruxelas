package com.bruxelas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bruxelas.entities.TalkerConnection;
import com.bruxelas.repositories.TalkerConnectionRepository;

@Service
public class TalkerConnectionService {

	private TalkerConnectionRepository repository;
	
	public List<TalkerConnection> findAll(){
		return (List<TalkerConnection>) this.repository.findAll();
	}
	
	public TalkerConnection findOne(Long id){
		return this.repository.findOne(id);
	}
	
	public TalkerConnection save(TalkerConnection talkerConnection){
		return this.repository.save(talkerConnection);
	}
	
	public void delete(Long id){
		this.repository.delete(id);
	}

}
