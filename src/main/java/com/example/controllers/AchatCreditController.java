package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fonction.JsonRequest;
import com.example.model.Achatcredit;
import com.example.model.Achatoffre;
import com.example.repository.AchatcreditRepository;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController

public class AchatCreditController {
	@Autowired
	private AchatcreditRepository repository;
	
	
	@PostMapping("/achatcredit")
	public JsonRequest createAchatCredit(@RequestBody Achatcredit achatcredit) {
	  try {
		  Achatcredit _achatcredit = repository.save(achatcredit);
		  JsonRequest rep=new <Achatoffre> JsonRequest (200, _achatcredit,"ok");
		  return rep;
	  
	  } catch (Exception e) {
		  ArrayList ax=new ArrayList();
	      new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      JsonRequest rep= new <Achatoffre> JsonRequest(21,ax,"votre achat n a pas ete effectuer");
	      return rep;
	    
	  }
	}
	
	
	@GetMapping("/achatcredit/{id}")
	public JsonRequest getAchatcreditById(@PathVariable("id") int id) {
	  Optional<Achatcredit> achatcreditdata = repository.findById(id);

	  if (achatcreditdata.isPresent()) {
		  JsonRequest rep=new <Achatoffre> JsonRequest (200, achatcreditdata.get(),"ok");
		  return rep;
	  
	  } else {
		  ArrayList ax=new ArrayList();
	      new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      JsonRequest rep= new <Achatoffre> JsonRequest(21,ax,"votre achat n a pas ete effectuer");
	      return rep;
	  }
	}
	
	@GetMapping("/achat")
	public JsonRequest AchatCreditClient(int idClientt){
		List<Achatcredit> liste = repository.findAll();
		JsonRequest rep=new JsonRequest(200,(ArrayList)liste,"ok");
		return rep;
	
	}

}
