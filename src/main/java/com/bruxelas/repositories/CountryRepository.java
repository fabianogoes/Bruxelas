package com.bruxelas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bruxelas.entities.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
