package com.jmurphey.dojos.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmurphey.dojos.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {

	List<Dojo> findAll();
	
//  So there is a way to use findById(Long id) without calling it here. 
//	Optional<Dojo> findById(Long id);
	
}
