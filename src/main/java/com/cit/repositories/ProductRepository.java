package com.cit.repositories;
//Our product repo that extends MongoRepo which has all the commands we need
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cit.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	List<Product> findAll();
	
	Product getById(String id);
	
	Product getByName(String name);
	
	
}
