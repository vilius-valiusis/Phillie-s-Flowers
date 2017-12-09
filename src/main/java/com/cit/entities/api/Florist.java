package com.cit.entities.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cit.deserializers.OrderDeserializer;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value = "florist")
@Document 
public class Florist
{
	// Ignoring the id, since jackson strugles inserting it in
	// when converting from JSON back to object.
	// This is not a problem since we are not posting anything
	// to the rest API.
  @Id
  @GeneratedValue
  @JsonIgnore
  private String id;
  
  @JsonProperty("name")
  private String name;
  
	  // Here I am telling jackson to use custom deserializer for the
	  // List of orders, since it cannot convert JSON arrays to java Collections
	  @JsonProperty("orders")
	  @JsonDeserialize(using = OrderDeserializer.class)
	  private List<Order> orders;
	  
	  public Florist() {}
	  public Florist(String name, List<Order> orders)
	  {
	    this.name = name;
	    this.orders = orders;
	  }
	  
	  public String getId()
	  {
	    return this.id;
	  }
	  
	  public void setId(String id)
	  {
	    this.id = id;
	  }
	  
	  public String getName()
	  {
	    return this.name;
	  }
	  
	  public void setName(String name)
	  {
	    this.name = name;
	  }
	  
	  public List<Order> getOrders()
	  {
	    return this.orders;
	  }
	  
	  public void setOrders(List<Order> orders)
	  {
	    this.orders = orders;
	  }
	  
	  public String toString()
	  {
	    return "Florist [id=" + this.id + ", name=" + this.name + ", orders=" + this.orders + "]";
	  }
}	
