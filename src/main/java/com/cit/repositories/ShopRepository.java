package com.cit.repositories;
//Our Shop repo that extends MongoRepo which has all the commands we need
//You do not have to include all methods here such as save()
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cit.entities.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {

	Shop getById(String id);

	Shop getByName(String name);
	
	
	 
}
