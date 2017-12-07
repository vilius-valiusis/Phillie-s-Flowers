package com.cit.repositories;
//Our product repo that extends MongoRepo which has all the commands we need
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cit.entities.Bundle;

@Repository
public interface BundleRepository extends MongoRepository<Bundle, String>{
	
	List<Bundle> findAll();
	
	Bundle getById(String id);
	
	Bundle getByName(String name);
	
	
}
