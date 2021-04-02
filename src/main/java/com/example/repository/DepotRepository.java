package com.example.repository;



import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.model.Depot;

public interface DepotRepository extends MongoRepository<Depot ,Integer> {
}
