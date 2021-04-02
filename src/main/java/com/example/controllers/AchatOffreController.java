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
import com.example.model.Achatoffre;
import com.example.repository.AchatoffreRepository;
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController

public class AchatOffreController {
	@Autowired
	private AchatoffreRepository repository;
	
	
	@PostMapping("/addAchatoffre")
	public JsonRequest createTutorial(@RequestBody Achatoffre achatoffre) {
	  try {
		  Achatoffre _achatoffre = repository.save(achatoffre);
		  JsonRequest rep=new <Achatoffre> JsonRequest (200,_achatoffre,"ok");
		  return rep;
	  } catch (Exception e) {
		  ArrayList ax=new ArrayList();
	      new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      JsonRequest rep= new <Achatoffre> JsonRequest(21,ax,"votre achat n a pas ete effectuer");
	      return rep;
	  }
	}
	
	@GetMapping("/api/getachatoffre")
	public JsonRequest  getAllCredit(){
		List<Achatoffre> liste = repository.findAll();
		JsonRequest rep=new JsonRequest(200,(ArrayList)liste,"ok");
		return rep;
	
	}
	
	@GetMapping("/api/achatoffre/{id}")
	public <Achatoffre> JsonRequest getAchatoffreById (@PathVariable("id") int id) {
	  
	  try {
		  Optional<Achatoffre> achatoffredata = (Optional<Achatoffre>) repository.findById(id);
		 // new ResponseEntity<> (achatoffredata.get(), HttpStatus.OK);
		  JsonRequest rep=new <Achatoffre> JsonRequest (200,achatoffredata.get(),"ok");
		  return rep;  
			    
	   } catch (Exception e) {
	      ArrayList ax=new ArrayList();
	      new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      JsonRequest rep= new <Achatoffre> JsonRequest(21,ax,"votre achat n a pas ete effectuer");
	      return rep;
	   }
	  
	}

}
