package com.cit.repositories;
//Our Bundle repo that extends MongoRepo which has all the commands we need for accessing our bundles from database
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