package com.bruxelas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bruxelas.entities.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

}
