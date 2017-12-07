package com.cit.services;

import com.cit.entities.api.Order;
import com.cit.entities.api.Product;
import java.util.List;

public abstract interface RestService
{
  public abstract List<Product> getProducts();
  
  public abstract List<Order> getOrders();
}
