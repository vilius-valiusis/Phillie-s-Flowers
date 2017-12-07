package com.cit.repositories.api;

import com.cit.entities.api.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract interface OrderRepository
  extends MongoRepository<Order, String>
{
  public abstract Order findOne(String paramString);
}
