package fonction;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Find {

	public static Document findByID(String id,String type,String nomId) {
		MongoClient mongoClient = null;
		MongoDatabase database = null;
		try {		
			mongoClient = MongoClients.create("mongodb://localhost:27017");
			database = mongoClient.getDatabase("mobilemoney");
			MongoCollection<Document> collection = database.getCollection(type);
			Document query = new Document();
			query.append(nomId, id);
			FindIterable<Document> res = collection.find(query);
			Document doc = null;
			for(Document document : res) {
				doc = document;
				break;
			}
			return doc;
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			if(mongoClient != null) {
				mongoClient.close();
			}
		}
    }
	
	public static MongoCollection<org.bson.Document> mongo(String collection) {
		MongoClient mongoClient = null;
		MongoDatabase database = null;
		MongoCollection<org.bson.Document> col;
		try {
			mongoClient = MongoClients.create("mongodb://localhost:27017");
			database = mongoClient.getDatabase("mobilemoney");
			col=database.getCollection(collection);
			mongoClient.close();
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			if(mongoClient != null) {
				mongoClient.close();
			}
		}
		return col;
	}
	
	public static List<Document> findAll(String type) {
    	MongoClient mongoClient = null;
		MongoDatabase database = null;
		try {		
			mongoClient = MongoClients.create("mongodb://localhost:27017");
			database = mongoClient.getDatabase("mobilemoney");
			MongoCollection<Document> collection = database.getCollection("offre");
			FindIterable<Document> res = collection.find();
			List<Document> doc = new ArrayList<Document>();
			for(Document document : res) {
				doc.add(document);
			}
			return doc;
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			if(mongoClient != null) {
				mongoClient.close();
			}
		}
    }
    public static Document login(String user,String mdp) {
		MongoClient mongoClient = null;
		MongoDatabase database = null;
		try {		
			mongoClient = MongoClients.create("mongodb://localhost:27017");
			database = mongoClient.getDatabase("mobilemoney");
			MongoCollection<Document> collection = database.getCollection("utilisateur");
			Document query = new Document();
			query.append("email", user);
			query.append("password", mdp);
			FindIterable<Document> res = collection.find(query);
			Document doc = null;
			for(Document document : res) {
				doc = document;
				break;
			}
			return doc;
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			if(mongoClient != null) {
				mongoClient.close();
			}
		}
    }
    
	public static Document depot(String numero,String somme) {
		MongoClient mongoClient = null;
		MongoDatabase database = null;
		try {		
			mongoClient = MongoClients.create("mongodb://localhost:27017");
			database = mongoClient.getDatabase("mobilemoney");
			MongoCollection<Document> collection = database.getCollection("puce");
			Document query = new Document();
			query.append("numero", numero);
			FindIterable<Document> res = collection.find(query);
			Document puce = null;
			System.out.println("somme");
			for(Document document : res) {
				System.out.println("tonga");
				System.out.println(document.getString("credit"));
				document.put("credit", somme);
				puce = document;
				break;
			}
			return puce;
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			if(mongoClient != null) {
				mongoClient.close();
			}
		}
    }
}

