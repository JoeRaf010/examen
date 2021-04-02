package Modele;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import fonction.Postgres_connection;

public class AchatCredit {
	private int id;
	private int idclient;
	private double  prix;
	private Timestamp dateachatcredit;
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
	    
	    public double getPrix() {
	        return prix;
	    }
	 
	    public void setPrix(Double prix) {
	        this.prix = prix;
	    }
	    
	    public Timestamp getDateachatcredit() {
	        return dateachatcredit;
	    }
	 
	    public void setdAteachatcredit(Timestamp dateachatcredit) {
	        this.dateachatcredit = dateachatcredit;
	    }
	    

	    public void insert(int idclient,double prix)throws SQLException,Exception{
	    	Connection conn=null;
	    	PreparedStatement pst=null;
	        try{
	        	conn = hlp.getSQLServerConnection();
	            conn.setAutoCommit(false);
	            pst = conn.prepareStatement("INSERT  into achatcredit values (0,?,?,CURRENT_TIMESTAMP+'2 hour'::INTERVAL)");
	            pst.setInt(1,idclient);
	            pst.setDouble(2,prix);
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
