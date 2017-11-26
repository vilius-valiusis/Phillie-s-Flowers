package com.cit;




import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {

	private ShopRepository shopRepository;
	
	public DbSeeder(ShopRepository shopRepository) {
		
		this.shopRepository=shopRepository;
		
	}
	@Override
	public void run(String... strings) throws Exception {
		
		Shop phillies = new Shop(
				"Phillies",
				new ShopStats(50, 10000, "Valentines Package"),
				Arrays.asList(
						new Package("Valentines","roses", "luxury chocolates", "wine"),
						new Package("Easter","tulips", "easter egg", "small teddy"),
						new Package("xmas","winter flowers", "cookies", "wrapped toy"),
						new Package("birthday","mixed flowers", "wrapped gift", "custom card")
						
						)
				
				
				);
		
		//drop shops because you want to have fresh database each run
		this.shopRepository.deleteAll();
		//add shops
		this.shopRepository.save(phillies);
	}

	
	
}
