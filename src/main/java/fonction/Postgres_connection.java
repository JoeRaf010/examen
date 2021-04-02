package fonction;

import java.sql.Connection;
import java.sql.DriverManager;

public class Postgres_connection {
	public Connection getSQLServerConnection() throws Exception
  	{
          Connection conn = null;
        try{
           Class.forName("org.postgresql.Driver"); // Facultatif
     
       //     String driver = "postgresql.Driver";
            String url = "jdbc:postgresql://localhost:5433/operateur";
             String username = "mobilemoney";
            String password = "123456";
              
            conn = DriverManager.getConnection(url, username, password); 
            System.out.println("Connecter");
        }catch(Exception ex){
            throw ex;
        }
        return conn;
  	}

}
