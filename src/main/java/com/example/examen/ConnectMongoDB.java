package com.example.examen;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDatabaseFactory;

import com.example.repository.AchatcreditRepository;

public class ConnectMongoDB {
	private final MongoDatabaseFactory mongo;


    @Autowired
    private AchatcreditRepository repository;

    @Autowired
    public ConnectMongoDB(MongoDatabaseFactory mongo) throws ClassNotFoundException, SQLException {
        this.mongo = mongo;
        
    }
    

}
