package com.example.controllers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fonction.JsonRequest;
import fonction.Postgres_connection;
import com.example.model.Depot;
import com.example.repository.DepotRepository;
import Modele.DetailsOffre;
import Modele.Offre;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController

public class DepotController {
	@Autowired
	private DepotRepository repository;
	
	@PostMapping("/api/addDepot")
	public JsonRequest createTutorial(@RequestBody Depot depot) {
	  try {
		  Depot _depot = repository.save(depot);
		  JsonRequest rep=new JsonRequest(200,_depot,"ok");
			return rep;
	  } catch (Exception e) {
		  ArrayList ax=new ArrayList();
          ax.add(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
          return new JsonRequest(21,ax,"votre achat n a pas ete effectuer");
	  }
	}
	
	@GetMapping("/api/getdepot")
	public JsonRequest getAllDepot(){
		
		List<Depot> liste = repository.findAll();
		JsonRequest rep=new JsonRequest(200,(ArrayList)liste,"ok");
		return rep;
	  
	}
	
	@GetMapping("/api/depot/{id}")
	public JsonRequest AchatoffreById(@PathVariable("id") int id) {
	  Optional<Depot> depotdata = repository.findById(id);

	  if (depotdata.isPresent()) {
		  ArrayList ax=new ArrayList();
		  ax.add(new ResponseEntity<>(depotdata.get(), HttpStatus.OK));
          return new JsonRequest(200,depotdata.get(),"ok");
	  } else {
		  ArrayList axp=new ArrayList();
		  axp.add(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		  return new JsonRequest(21,axp,"error");
	  }
	}

}
