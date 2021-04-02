package Modele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import fonction.Postgres_connection;

public class Depot {
	int id;
	double valeur;
	int idclient;
	Date  datedepot;
	String etat;
	public Postgres_connection hlp = new Postgres_connection();
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
    
   
    
    public void insert(double valeur,int idclient  )throws SQLException,Exception{
    	Connection conn=null;
    	PreparedStatement pst=null;
        try{
        	conn = hlp.getSQLServerConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement("INSERT  into depot values (0,?,?,now(),null)");
            pst.setDouble(1,valeur);
            pst.setInt(2,idclient);
            System.out.println("suery insert: "+pst.toString()); 
            
            pst.executeUpdate();
            conn.commit();
        }catch(Exception ex){   
            conn.rollback();
            throw ex;
        }finally{
            if(pst!=null)pst.close();      
        }  
    }

}
