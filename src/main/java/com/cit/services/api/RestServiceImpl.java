package com.cit.services.api;
/*
 * Main service used to receive data from the REST API.
 * This JSON data is converted back into java objects using the rest template
 * to be used on the front end.
 */
import com.cit.entities.api.Florist;
import com.cit.entities.api.Order;
import com.cit.entities.api.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceImpl implements RestService{

  RestTemplate restTemplate;
  
  public RestServiceImpl(){this.restTemplate = new RestTemplate();}

  public List<Product> getProducts(){
    String getUrl = "http://localhost:8080/api/products";
    
    Product[] getResponse = this.restTemplate.getForObject(getUrl, Product[].class);
    if (getResponse != null) 
      return Arrays.asList(getResponse);
    System.out.println("Response for Get Request: NULL");
    
    return new ArrayList<Product>();
  }
  
  public List<Order> getOrders(){
    String getUrl = "http://localhost:8080/api/orders";
    Order[] getResponse = this.restTemplate.getForObject(getUrl, Order[].class);
    if (getResponse != null) 
      return Arrays.asList(getResponse);
    System.out.println("Response for Get Request: NULL");
    
    return new ArrayList<Order>();
  }
  
  public List<Florist> getFlorists(){
    String getUrl = "http://localhost:8080/api/florists";
    Florist[] getResponse = this.restTemplate.getForObject(getUrl, Florist[].class);
    if (getResponse != null) 
      return Arrays.asList(getResponse);
    System.out.println("Response for Get Request: NULL");
    
    return new ArrayList<Florist>();
  }
}
