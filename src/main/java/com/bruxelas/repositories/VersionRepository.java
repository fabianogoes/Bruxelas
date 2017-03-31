package com.bruxelas.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bruxelas.entities.Version;

@Repository
public interface VersionRepository extends CrudRepository<Version, Long> {

	
	@Query(value = "select * from version v where v.id = (select max(vv.id) from version vv)", nativeQuery = true)
	Version findActualVersion();
	
}
