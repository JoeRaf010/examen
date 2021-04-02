package Modele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fonction.Postgres_connection;


public class Operateur {
	int id;
	String nom_operateur;
	String ref;
	int valeur;
	int key_numero;
	int cout_numero;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNom_operateur() {
		return nom_operateur;
	}



	public void setNom_operateur(String nom_operateur) {
		this.nom_operateur = nom_operateur;
	}



	public String getRef() {
		return ref;
	}



	public void setRef(String ref) {
		this.ref = ref;
	}



	public int getValeur() {
		return valeur;
	}



	public void setValeur(int valeur) {
		this.valeur = valeur;
	}



	public int getKey_numero() {
		return key_numero;
	}



	public void setKey_numero(int key_numero) {
		this.key_numero = key_numero;
	}



	public int getCout_numero() {
		return cout_numero;
	}



	public void setCout_numero(int cout_numero) {
		this.cout_numero = cout_numero;
	}



	public ArrayList<Operateur>  findOperateur() throws Exception{
		Connection conn=null;
		PreparedStatement pst=null;
        ResultSet result = null;
        ArrayList<Operateur> liste = new ArrayList<Operateur>();
        try {
        	conn = new Postgres_connection().getSQLServerConnection();
        	pst=conn.prepareStatement("SELECT * FROM Operateur",result.TYPE_SCROLL_INSENSITIVE,result.CONCUR_READ_ONLY);           
            result = pst.executeQuery();
	            while(result.next()) 
	            {
	            	Operateur op=new Operateur();
	            	op.setId(result.getInt(1));
	            	op.setNom_operateur(result.getString(2));
	            	op.setRef(result.getString(3));
	            	op.setValeur(result.getInt(4));
	            	op.setKey_numero(result.getInt(5));
	            	op.setCout_numero(result.getInt(6));
	            	liste.add(op);
	            }
            } catch(Exception ex) {
            	 System.out.println(" Operateur findAll error: "+ex.getMessage());
 	            throw ex;
            }finally{
	            if(result!=null)result.close();
	            if(pst!=null)pst.close();   
	            if(conn!=null)conn.close();
        }
        return liste;
	}

}
