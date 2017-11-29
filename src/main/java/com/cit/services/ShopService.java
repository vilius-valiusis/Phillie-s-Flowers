package com.cit.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cit.entity.Shop;
import com.cit.repositories.ShopRepository;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;

	public ShopService(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}

	public List<Shop> findAll() {

		List<Shop> shopList = shopRepository.findAll();

		return shopList;
	}


	// Here I am updating the Total Orders in the shop
	public void updateTotalOrders() {

		Shop s = shopRepository.getByName("Phillies");

		s.setTotalOrder(s.getTotalOrder() + 1);

		shopRepository.save(s);

	}

	// Here I am updating the Total Revenue in the shop
	public void updateTotalRevenue(Double amount) {

		Shop s = shopRepository.getByName("Phillies");

		s.setTotalRevenue(s.getTotalRevenue() + amount);

		shopRepository.save(s);

	}

	public Shop getByName(String name) {
		return shopRepository.getByName(name);
	}
}
