package com.bruxelas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bruxelas.entities.Talker;

@Repository
public interface TalkerRepository extends CrudRepository<Talker, Long> {

	Talker findByUserId(Long userId); 

}
