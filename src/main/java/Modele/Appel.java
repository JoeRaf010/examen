package Modele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import fonction.Postgres_connection;

public class Appel {
	int id;
	int temps;
	int idclient1;
	int idclient2;
	Timestamp dateAppel;
	public Postgres_connection hlp = new Postgres_connection();
	
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
    
    public Timestamp getDateAppel() {
        return dateAppel;
    }
 
    public void setDateAppel(Timestamp dateAppel) {
        this.dateAppel = dateAppel;
    }
    
    
   
    public void insert(int temps,int idclient1,int idclient2, Timestamp date)throws SQLException,Exception{
    	Connection conn=null;
    	PreparedStatement pst=null;
        try{
        	conn = hlp.getSQLServerConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement("INSERT INTO Appel values (DEFAULT,?,?,?,?)");
            pst.setInt(1,temps);
            pst.setInt(2,idclient1);
            pst.setInt(3,idclient2);
            pst.setTimestamp(4,date);
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
