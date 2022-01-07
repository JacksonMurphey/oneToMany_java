package com.jmurphey.dojos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmurphey.dojos.models.Dojo;
import com.jmurphey.dojos.models.Ninja;
import com.jmurphey.dojos.repositories.DojoRepo;
import com.jmurphey.dojos.repositories.NinjaRepo;

@Service
public class ConnectService {

	@Autowired
	private DojoRepo dojoRepo;
	
	@Autowired
	private NinjaRepo ninjaRepo;
	
	
	// Create Object Methods 
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	
	
	// Find all Dojos Method
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}

	// Get One Method
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	
	// Get Ninjas of a Dojo Method
	public List<Ninja> getNinjasOfDojo(Dojo dojo){
		return ninjaRepo.findAllByDojo(dojo);
	}
	
}
