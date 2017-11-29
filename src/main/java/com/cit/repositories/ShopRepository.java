package com.cit.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cit.entity.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {

	Shop getById(String id);

	Shop getByName(String name);
	
	
	 
}
