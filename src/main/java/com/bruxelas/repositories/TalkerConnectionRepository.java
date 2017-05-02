package com.bruxelas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bruxelas.entities.TalkerConnection;

@Repository
public interface TalkerConnectionRepository extends CrudRepository<TalkerConnection, Long> {

}
