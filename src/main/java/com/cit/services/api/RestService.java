package com.cit.services.api;


import com.cit.entities.api.Florist;
import com.cit.entities.api.Order;
import com.cit.entities.api.Product;
import java.util.List;

import org.springframework.stereotype.Service;

public interface RestService
{
  public  List<Product> getProducts();
  
  public  List<Order> getOrders();

  public  List<Florist> getFlorists();
}
