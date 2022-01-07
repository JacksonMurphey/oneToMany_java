package com.jmurphey.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmurphey.dojos.models.Dojo;
import com.jmurphey.dojos.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long>{

	List<Ninja> findAllByDojo(Dojo dojo);
	
}
