package com.bruxelas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.Connection;
import com.bruxelas.repositories.ConnectionRepository;

@Service
public class ConnectionService {

	@Autowired
	private ConnectionRepository repository;
	
	public List<Connection> findAll(){
		return (List<Connection>) this.repository.findAll();
	}
	
	public Connection findOne(Long id){
		return this.repository.findOne(id);
	}
	
	public Connection save(Connection connection){
		return this.repository.save(connection);
	}
	
	public void delete(Long id){
		this.repository.delete(id);
	}
}
