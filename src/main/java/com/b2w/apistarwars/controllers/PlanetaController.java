package com.b2w.apistarwars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.apistarwars.models.Planeta;
import com.b2w.apistarwars.services.PlanetaService;
import com.b2w.apistarwars.util.URL;

@RestController
@RequestMapping(value="/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService service;
	
	@GetMapping
	public ResponseEntity<List<Planeta>> encontraTodos(){
		List<Planeta> planetas = service.findAll();
		return ResponseEntity.ok().body(planetas);
			}
	
	@GetMapping(value="/buscaid")
	public ResponseEntity<Planeta> encontraPorID(@RequestParam(value="id", defaultValue="") String id){
		Planeta planeta = service.findById(id);
		return ResponseEntity.ok().body(planeta);
	}
	
	@GetMapping(value="/buscanome")
	public ResponseEntity<List<Planeta>> encontraPorNome(@RequestParam(value="nome", defaultValue="") String nome){
		nome = URL.decodeParam(nome);
		List<Planeta> planeta = service.findByNome(nome);
		return ResponseEntity.ok().body(planeta);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleta(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}