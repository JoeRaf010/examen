package com.example.model;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.lang.NonNull;

import com.example.examen.ConnectMongoDB;


@EntityScan
@Document(collection = "depot")

public class Depot {
	@Id 
	@javax.annotation.processing.Generated(value = { "id" })
	int id;
	@NonNull
	double valeur;
	double frais;
	@NonNull
	int idclient;
	@NonNull
	Date  datedepot;
	String etat;
	
	 public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    public int getIdclient() {
	        return idclient;
	    }
	 
	    public void setIdclient(int idclient) {
	        this.idclient = idclient;
	    }
	    
	    public double getValeur() {
	        return valeur;
	    }
	 
	    public void setPrix(Double valeur) {
	        this.valeur = valeur;
	    }
	    
	    public Date getDatedepot() {
	        return datedepot;
	    }
	 
	    public void setDatepot(Date datedepot) {
	        this.datedepot = datedepot;
	    }
	    
	    public String getEtat() {
	        return etat;
	    }
	 
	    public void setEtat(String etat) {
	        this.etat = etat;
	    }
	    
	   /* public static List<Depot> findByIdclient(int idClient, ConnectMongoDB db){
	    	Bson filter = new BasicDBObject().append("idClient",idClient);
	    	MongoCollection collection = db.getMongoDatabase().getCollection("depot");
	    	DBObject object = collection.find(query);
	    	
	    	
	    	
	    }*/
	    @Override
	    public String toString() {
	      return "[id=" + id  + ", valeur=" + valeur +", idclient=" + idclient  + ", datedepot" + datedepot +", etat" + etat + "]";
	    }

}
