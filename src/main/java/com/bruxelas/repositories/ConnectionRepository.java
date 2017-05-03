package com.bruxelas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bruxelas.entities.Connection;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Long> {

}
