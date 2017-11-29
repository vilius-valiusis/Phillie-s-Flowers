package com.cit.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Shop")
public class Shop {

	@Id
	private String id;
	private String name;
	private int totalOrder;
	private Double totalRevenue;
	private String bestProduct;

	public Shop(String name, int totalOrder, Double totalRevenue, String bestProduct) {
		this.name = name;
		this.totalOrder = totalOrder;
		this.totalRevenue = totalRevenue;
		this.bestProduct = bestProduct;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(int totalOrder) {
		this.totalOrder = totalOrder;
	}

	public Double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public String getBestProduct() {
		return bestProduct;
	}

	public void setBestProduct(String bestProduct) {
		this.bestProduct = bestProduct;
	}

}
