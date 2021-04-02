package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "achatcredit")

public class Achatcredit {
	@Id
	private int id;
	@Field(value = "idclient")
	private int idclient;
	@Field(value = "prix")
	private double  prix;
	@Field(value = "dateachatcredit")
	private Date dateachatcredit;
	
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
	    
	    public double getPrix() {
	        return prix;
	    }
	 
	    public void setPrix(Double prix) {
	        this.prix = prix;
	    }
	    
	    public Date getDateachatcredit() {
	        return dateachatcredit;
	    }
	 
	    public void setdAteachatcredit(Date dateachatcredit) {
	        this.dateachatcredit = dateachatcredit;
	    }
	    

	    @Override
	    public String toString() {
	      return "Achatcredit [id=" + id + ", idclient=" + idclient + ", prix=" + prix + ", dateachatcredit" + dateachatcredit + "]";
	    }

}
