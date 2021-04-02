package com.example.examen;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fonction.JsonRequest;
import fonction.Postgres_connection;
import Modele.*;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping

public class ApiAppel {
	@PostMapping(value = "api/Appel")
	public JsonRequest get_post(@RequestParam("temps") int temps,@RequestParam("idclient1") int idclient1,@RequestParam("idclient2") int idclient2,@RequestParam("dateAppel") Timestamp dateAppel) throws Exception
	{
	           
		String a= "Simulation appel reussi";
		Connection conn=null;
		try {			
			conn = new Postgres_connection().getSQLServerConnection();
			Appel of=new Appel();
			
			of.insert(temps,idclient1,idclient2, dateAppel);			
			return new JsonRequest(200,"reussi",a);
		}
		catch(Exception exp) { 
					ArrayList axp=new ArrayList();
				 axp.add(new ResponseEntity<>(HttpStatus.NOT_FOUND));
				 return new JsonRequest(21,axp,"error");
			} finally {
				if(conn!=null) conn.close();
			}
		
	    }

}
