package Modele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import fonction.Postgres_connection;

public class AchatOffre {
	private int id;
	private int idclient;
	private int idoffre;
	private Timestamp dateachatoffre;
	
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
	    
	    public int getIdoffre() {
	        return idoffre;
	    }
	 
	    public void setIdoffre(int idoffre) {
	        this.idoffre = idoffre;
	    }
	    
	    public Timestamp getDateachatoffre() {
	        return dateachatoffre;
	    }
	 
	    public void setdAteachatoffre(Timestamp dateachatcredit) {
	        this.dateachatoffre = dateachatcredit;
	    }
	    
	    

	    public void insert(int idclient,int idOffre,int payement)throws SQLException,Exception{
	    	Connection conn=null;
	    	PreparedStatement pst=null;
	        try{
	        	conn = hlp.getSQLServerConnection();
	            conn.setAutoCommit(false);
	            pst = conn.prepareStatement("INSERT  into achatoffre values (0,?,?,CURRENT_TIMESTAMP+'2 hour'::INTERVAL),?");
	            pst.setInt(1,idclient);
	            pst.setInt(2,idOffre);
	            pst.setInt(3,payement);
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
