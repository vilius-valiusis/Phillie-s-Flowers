package com.cit.repositories.api;

import com.cit.entities.api.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends MongoRepository<Product, String>
{
  Product findOne(String paramString);
  
  Product findByName(String name);

}
