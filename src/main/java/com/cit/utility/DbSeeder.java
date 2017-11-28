package com.cit.utility;




import java.math.BigDecimal;
import java.util.ArrayList;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cit.entity.Product;
import com.cit.entity.Shop;
import com.cit.repositories.ProductRepository;
import com.cit.repositories.ShopRepository;

@Component
public class DbSeeder implements CommandLineRunner {

	private ShopRepository shopRepository;
	private ProductRepository productRepository;
	
	public DbSeeder(ShopRepository shopRepository, ProductRepository productRepository ) {
		
		this.shopRepository=shopRepository;
		this.productRepository=productRepository;
	}
	@Override
	public void run(String... strings) throws Exception {
		
		Shop phillies = new Shop("Phillies", 0, 0, "");
		ArrayList<Product> products = new ArrayList<Product>();
		
		Product p1 = new Product("valentines", "roses", "luxury chocolates", "heart teddy", 50.00, 5);
		Product p2 = new Product("easter", "daffodils", "easter egg", "chick teddy", 45.00, 10);
		Product p3 = new Product("xmas", "tulips", "pudding", "stocking", 65.00, 3);
		Product p4 = new Product("birthday", "venus flytrap", "cake", "voucher", 85.00, 22);
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
