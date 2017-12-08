package com.cit.entities.api;

import javax.persistence.GeneratedValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class Product
{
  @Id
  @GeneratedValue
  @JsonIgnore
  private String id;
  private String name;
  private String description;
  private Double price;
  private Integer quantity;
  
  public Product() {}
  
  public Product(String name, String description, Double price, Integer quantity)
  {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
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
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public Double getPrice()
  {
    return this.price;
  }
  
  public void setPrice(Double price)
  {
    this.price = price;
  }
  
  public int getQuantity()
  {
    return this.quantity.intValue();
  }
  
  public void setQuantity(Integer quantity)
  {
    this.quantity = quantity;
  }
  
  public String toString()
  {
    return 
      "Product [id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", price=" + this.price + ", quantity=" + this.quantity + "]";
  }
}
