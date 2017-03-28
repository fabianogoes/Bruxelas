package com.bruxelas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.ConnectionType;
import com.bruxelas.repositories.ConnectionTypeRepository;

@Service
public class ConnectionTypeService {

	@Autowired
	private ConnectionTypeRepository repository;

	public ConnectionType save(ConnectionType connectionType) {
		return this.repository.save(connectionType);
	}

	public List<ConnectionType> findAll() {
		return (List<ConnectionType>) this.repository.findAll();
	}

	public ConnectionType findOne(long id) {
		return this.repository.findOne(id);
	}

	public void delete(long id) {
		this.repository.delete(id);
	}
	
	
}
