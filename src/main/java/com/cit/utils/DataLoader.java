package com.cit.utils;
//This loads all dummy data into the database to be retrieved and updated.
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cit.entities.Bundle;
import com.cit.entities.Shop;
import com.cit.repositories.BundleRepository;
import com.cit.repositories.ShopRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private BundleRepository productRepository;
	
	public DataLoader(ShopRepository shopRepository, BundleRepository productRepository ) {
		
		this.shopRepository=shopRepository;
		this.productRepository=productRepository;
	}
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		
		Shop phillies = new Shop("Phillies", 0, 0.0, "Valentines Package");
		ArrayList<Bundle> bundles = new ArrayList<Bundle>();
		
		Bundle p1 = new Bundle("Valentines Package", "Red Roses", "Luxury Chocolates", "Heart shaped Teddy", 50.00, 5, "images/prod4.gif");
		Bundle p2 = new Bundle("Easter Package", "Selection of Daffodils", "Easter Egg", "Chick shaped Teddy", 45.00, 10, "images/easter.gif");
		Bundle p3 = new Bundle("Christmas Package", "Selection of Tulips", "Xmas Pudding", "Xmas Stocking", 65.00, 3, "images/xmas.gif");
		Bundle p4 = new Bundle("Birthday Package", "Venus Flytrap", "Custom Birthday Cake", "Gift Voucher", 85.00, 22, "images/cake.png");
		bundles.add(p1);
		bundles.add(p2);
		bundles.add(p3);
		bundles.add(p4);
		
		//drop shops because you want to have fresh database each run
		this.shopRepository.deleteAll();
		this.productRepository.deleteAll();
		//add shops
		this.shopRepository.save(phillies);
		this.productRepository.save(bundles);
	}

	
	
}
