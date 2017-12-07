package com.cit.repositories.api;

import com.cit.entities.api.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract interface ProductRepository
  extends MongoRepository<Product, String>
{
  public abstract Product findOne(String paramString);
}
