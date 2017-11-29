package com.cit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cit.entity.Product;
import com.cit.entity.Shop;
import com.cit.repositories.ProductRepository;
import com.cit.repositories.ShopRepository;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public ShopService(ShopRepository shopRepository, ProductRepository productRepository) {
		this.shopRepository = shopRepository;
		this.productRepository = productRepository;
	}

	public List<Shop> findAll() {

		List<Shop> shopList = shopRepository.findAll();

		return shopList;
	}

	public Shop getById(String id) {
		return shopRepository.getById(id);
	}

	//Here I am updating the Total Orders in the shop
	public void update() {

		Shop s = shopRepository.getByName("Phillies");
		
		s.setTotalOrder(s.getTotalOrder() + 1);
		
		
		shopRepository.save(s);

	}

	public Shop getByName(String name) {
		return shopRepository.getByName(name);
	}
}
