package com.cit.repositories.api;

import com.cit.entities.api.Florist;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract interface FloristRepository
  extends MongoRepository<Florist, String>
{
  public abstract Florist findOne(String paramString);
}
