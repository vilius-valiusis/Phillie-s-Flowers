package com.cit.entities.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cit.deserializers.ProductDeserializer;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName(value = "order")
@Document 
public class Order
{
	// Ignoring the id, since jackson strugles inserting it in
	// when converting from JSON back to object.
	// This is not a problem since we are not posting anything
	// to the rest API.
@Id
@GeneratedValue
@JsonIgnore
private String id;

private boolean paid;
private double totalCost;

	//Here I am telling jackson to use custom deserializer for the
	// List of products, since it cannot convert JSON arrays to java Collections
	@JsonProperty("products")
	@JsonDeserialize(using = ProductDeserializer.class)
	private List<Product> products;
	
	public Order() {}
	
	public Order(boolean paid, double totalCost, List<Product> products)
	{
	  this.paid = paid;
	  this.totalCost = totalCost;
	  this.products = products;
	}
	
	public String getId()
	{
	  return this.id;
	}
	
	public void setId(String id)
	{
	  this.id = id;
	}
	
	public boolean isPaid()
	{
	  return this.paid;
	}
	
	public void setPaid(boolean paid)
	{
	  this.paid = paid;
	}
	
	public double getTotalCost()
	{
	  return this.totalCost;
	}
	
	public void setTotalCost(double totalCost)
	{
	  this.totalCost = totalCost;
	}
	
	public List<Product> getProducts()
	{
	  return this.products;
	}
	
	public void setProducts(List<Product> products)
	{
	  this.products = products;
	}
	
	
	public String toString()
	{
	  return 
	    "Order [id=" + this.id + ", paid=" + this.paid + ", amount=" + this.totalCost + ", products=" + this.products + "]";
	}
}
