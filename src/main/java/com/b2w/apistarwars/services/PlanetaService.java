package com.b2w.apistarwars.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.apistarwars.exception.ObjectNotFoundException;
import com.b2w.apistarwars.models.Planeta;
import com.b2w.apistarwars.repository.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repo;
	public List<Planeta> findAll(){
		return repo.findAll();
		
	}
	
	public Planeta findById(String id) {
		Optional<Planeta> obj = repo.findById(id);
		return  obj.orElseThrow(() -> new ObjectNotFoundException("Planeta não encontrado"));
	}
}
