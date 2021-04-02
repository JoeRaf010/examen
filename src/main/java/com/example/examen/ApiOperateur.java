package com.example.examen;
import java.util.ArrayList;


import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Modele.Oper;
//import service.Devise;
import Modele.Operateur;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping
public class ApiOperateur {
	@GetMapping(path="api/operateur")
	public  ArrayList<Oper> get_index() throws Exception
	{
		return new Oper().findAll();
	}
	

}
