package com.example.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Achatoffre;

public interface AchatoffreRepository extends  MongoRepository<Achatoffre, Integer> {

}
