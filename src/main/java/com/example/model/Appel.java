package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appel")

public class Appel {
	@Id
	int id;
	int temps;
	int idclient1;
	int idclient2;
	
	public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public int getTemps() {
        return temps;
    }
 
    public void setTemps(int temps) {
        this.temps = temps;
    }
    
    public int getIdclient1() {
        return idclient1;
    }
 
    public void setIdclient1(int idclient1) {
        this. idclient1 =  idclient1;
    }
    
    public int getIdclient2() {
        return idclient2;
    }
 
    public void setIdclient2(int idclient2) {
        this.idclient2 = idclient2;
    }
    
	

    @Override
    public String toString() {
      return "[id=" + id  + ", temps" + temps +", idclient1=" + idclient1  + ",idclient2=" + idclient2 + "]";
    }

}
