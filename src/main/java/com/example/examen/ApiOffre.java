package com.example.examen;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import fonction.JsonRequest;
import fonction.Postgres_connection;
import Modele.Client;
import Modele.DetailsOffre;
import Modele.Offre;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping
public class ApiOffre {
	@GetMapping(path="api/alloffre/")
	public JsonRequest  offre() throws Exception {
        List<Offre> offre=new Offre().findAllOffre();
        JsonRequest rep=new JsonRequest(200,(ArrayList) offre,"ok");
	return rep;
    }
	
	
	@GetMapping("api/offre/{id}")
    public JsonRequest  achatAll(@PathVariable String id) throws Exception {
        List<Offre> offre=new Offre().findOffre(id);
        JsonRequest rep=new JsonRequest(200,(ArrayList) offre,"ok");
	return rep;
    }
	
	
	@DeleteMapping(path="api/deleteOffre/{id}")
	public JsonRequest deleteoffre(@PathVariable int id) {
		JsonRequest rep=new JsonRequest();
		try 
		{
			Offre c = new Offre();
			c.deleteOffre(id);
			rep=new JsonRequest(200,null,"ok");
			//return rep;
			
		} catch(Exception exp) {
			exp.printStackTrace();
		}
		return rep;
	}
	
	@PostMapping(value = "api/Offre")
	public JsonRequest get_post(Offre imput) throws Exception
	{
	           
		String a= "create  Offre Succes";
		Connection conn=null;
		try {			
			conn = new Postgres_connection().getSQLServerConnection();
			Offre of=new Offre();
			of.insertOffre(conn,imput);			
			return new JsonRequest(200,of,"Offre created");
		}
		catch(Exception exp) { 
					ArrayList axp=new ArrayList();
				 axp.add(new ResponseEntity<>(HttpStatus.NOT_FOUND));
				 return new JsonRequest(21,axp,"error");
			} finally {
				if(conn!=null) conn.close();
			}
		
	    }
	 
	  @PutMapping(value = "api/Offre/{id}")
	    public JsonRequest get_put(@PathVariable int id,Offre imput) throws Exception
	 	{           
			String[] a= {"put nom: Offre Succes"};
			Connection conn=null;
			try 
			{				
				conn = new Postgres_connection().getSQLServerConnection();
				new Offre().updateOffre(conn,imput,id);
				return new JsonRequest(200,a,"Offre modifile");
			}
			catch(Exception exp) 
			{ 				
				ArrayList axp=new ArrayList();
				  axp.add(new ResponseEntity<>(HttpStatus.NOT_FOUND));
				  return new JsonRequest(21,axp,"error");
			} finally 
			{
				if(conn!=null) conn.close();
			}
			
	    }



}
