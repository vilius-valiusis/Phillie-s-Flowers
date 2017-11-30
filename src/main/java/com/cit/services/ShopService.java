package com.cit.services;

import java.util.List;

import com.cit.entities.Shop;

public interface ShopService {

	public List<Shop> findAll();

	// Here I am updating the Total Orders in the shop
	public void updateTotalOrders();

	// Here I am updating the Total Revenue in the shop
	public void updateTotalRevenue(Double amount);

	public Shop getByName(String name);
}
