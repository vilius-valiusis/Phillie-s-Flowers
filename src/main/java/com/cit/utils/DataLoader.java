package com.cit.utils;
//This loads all dummy data into the database to be retrieved and updated.
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cit.entities.Product;
import com.cit.entities.Shop;
import com.cit.repositories.ProductRepository;
import com.cit.repositories.ShopRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public DataLoader(ShopRepository shopRepository, ProductRepository productRepository ) {
		
		this.shopRepository=shopRepository;
		this.productRepository=productRepository;
	}
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		
		Shop phillies = new Shop("Phillies", 0, 0.0, "Valentines Package");
		ArrayList<Product> products = new ArrayList<Product>();
		
		Product p1 = new Product("Valentines Package", "roses", "luxury chocolates", "heart teddy", 50.00, 5, "images/prod1.gif");
		Product p2 = new Product("Easter Package", "daffodils", "easter egg", "chick teddy", 45.00, 10, "images/prod2.gif");
		Product p3 = new Product("Christmas Package", "tulips", "pudding", "stocking", 65.00, 3, "images/prod3.gif");
		Product p4 = new Product("Birthday Package", "venus flytrap", "cake", "voucher", 85.00, 22, "images/prod4.gif");
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		
		//drop shops because you want to have fresh database each run
		this.shopRepository.deleteAll();
		this.productRepository.deleteAll();
		//add shops
		this.shopRepository.save(phillies);
		this.productRepository.save(products);
	}

	
	
}
