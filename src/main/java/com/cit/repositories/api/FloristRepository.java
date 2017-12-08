package com.cit.repositories.api;

import com.cit.entities.api.Florist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloristRepository extends MongoRepository<Florist, String>
{
	Florist findOne(String paramString);
	
	Florist findByName(String name);
}
