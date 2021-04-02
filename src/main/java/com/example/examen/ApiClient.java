package com.example.examen;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import Controller.Login;
import fonction.*;
import Modele.Client;
import Modele.*;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping
public class ApiClient {
	public Postgres_connection hlp = new Postgres_connection();
	
	@GetMapping(path="api/cl")
	public  ArrayList<Client> get_index() throws Exception
	{
		return new Client().findAll();
	}
	
	/*@GetMapping(path="api/clients")
	public ArrayList<Client> get_index()
	{
		ArrayList<Client> liste = new ArrayList<Client>();
		
		try 
		{
			liste.add( new Client(1,"Andria","Patrick","123783267","0343208193","AndriaPatrick",1));
			//liste.add( new Client(1,"Bogossy","GB","noam@gmail.com","123456",12,new Date(26,2,1998)));
			liste= new Client().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}*/
	
	
	@RequestMapping(path="api/client" , method=RequestMethod.POST,produces="application/json" )
	public JsonRequest get_post(@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("identite") String identite,@RequestParam("numero") String numero,@RequestParam("motDePasse") String motDePasse,@RequestParam("idOperateur") int idOperateur) throws SQLException
	{
		//Connection conn=null;
		try 
		{
			//conn = hlp.getSQLServerConnection();
			//conn = new Client().hlp.getSQLServerConnection();
			Client c = new Client();
			c.insert(nom,prenom,identite,numero,motDePasse,idOperateur);
		} catch(Exception exp) {
			exp.printStackTrace();
		}
		/*finally {
			if(conn!=null) conn.close();
		}*/
		return new JsonRequest (200, null, "inscription complete") ;
		
	}
	@PostMapping(path="api/loginclient")
	@CrossOrigin
	    public JsonRequest get_login(@RequestParam("numero") String numero,@RequestParam("motDePasse") String motDePasse) throws Exception
	   {		   
		String n = new Login().controller_login(numero, motDePasse).getToken(); 
		return new JsonRequest(200,n,"ok");
	   }

}
