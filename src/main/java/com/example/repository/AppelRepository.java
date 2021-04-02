package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.w3c.dom.Entity;

import com.example.model.Appel;

public interface AppelRepository extends MongoRepository<Appel,Integer> {
	
	/*public static final Entity em = null;
	/static List<Appel> findAppelByIdclient1(int idclient1){
		Criteria cb = ((Object) em).getCriteriaBuilder();
      CriteriaQuery<Appel> cq = ((Object) cb).createQuery(Appel.class);

      Root<Appel> appel = cq.from(Appel.class);
      Predicate idclients = cb.equal(appel.get("idclient1"), idclient1);
      cq.where(authorNamePredicate, titlePredicate);

      TypedQuery<Appel> query = em.createQuery(cq);
      return query.getResultList();
	}*/
}



