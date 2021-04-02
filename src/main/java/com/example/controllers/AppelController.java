package com.example.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fonction.JsonRequest;
import com.example.model.Achatcredit;
import com.example.model.Appel;
import com.example.model.Depot;
import com.example.repository.AppelRepository;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController

public class AppelController {
	@Autowired
	private AppelRepository repository;
	
	@PostMapping("/api/addAppel")
	public JsonRequest createTutorial(@RequestBody Appel appel) {
	  try {
		  Appel _appel = repository.save(appel);
          return new JsonRequest(200,_appel,"appel created");
	  } catch (Exception e) {
		  ArrayList axp=new ArrayList();
		  axp.add(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
		  return new JsonRequest(21,axp,"error");
	  }
	}
	
	@GetMapping("/api/appel")
	public JsonRequest  getAllAppel(){
		List<Appel> liste = repository.findAll();
		JsonRequest rep=new JsonRequest(200,(ArrayList)liste,"ok");
		return rep;
	  
	}
	
	
	//@GetMapping("/getcredit/{idclient1}")
	//public List<Appel> appelsortant(@PathVariable("idclient1") int idclient1) {
		//return repository.findAll();
		//return repository.findAppelByIdclient1(idclient1);
	//}
	
	@GetMapping("/api/appel/{id}")
	public JsonRequest getAchatoffreById(@PathVariable("id") int id) {
	  Optional<Appel> appeldata = repository.findById(id);

	  if (appeldata.isPresent()) {
		  return new JsonRequest(200,appeldata.get(),"ok");
	  } else {
		  ArrayList axp=new ArrayList();
		  axp.add(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		  return new JsonRequest(21,axp,"error");
	  }
	}

}
