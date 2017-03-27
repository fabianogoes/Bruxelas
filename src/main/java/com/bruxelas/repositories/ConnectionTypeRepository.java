package com.bruxelas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bruxelas.entities.ConnectionType;

@Repository
public interface ConnectionTypeRepository extends CrudRepository<ConnectionType, Long> {

}
