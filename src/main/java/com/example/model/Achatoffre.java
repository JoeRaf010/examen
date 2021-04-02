package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "achatoffre")

public class Achatoffre {
	@Id
	private int id;
	@Field(value = "idclient")
	private int idclient;
	@Field(value = "idoffre")
	private int idoffre;
	@Field(value = "dateachatoffre")
	private Date dateachatoffre;
	
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
	    
	    public int getIdoffre() {
	        return idoffre;
	    }
	 
	    public void setIdoffre(int idoffre) {
	        this.idoffre = idoffre;
	    }
	    
	    public Date getDateachatoffre() {
	        return dateachatoffre;
	    }
	 
	    public void setdAteachatoffre(Date dateachatcredit) {
	        this.dateachatoffre = dateachatcredit;
	    }
	    

	    @Override
	    public String toString() {
	      return "Achatoffre [id=" + id + ", idclient=" + idclient + ", idoffre=" + idoffre + ", dateachatoffre" + dateachatoffre + "]";
	    }

}
