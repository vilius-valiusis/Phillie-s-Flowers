package com.cit;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
public class ShopController {
	private ShopRepository shopRepository;
	
	
	
	public ShopController(ShopRepository shopRepository) {
			this.shopRepository= shopRepository;
						
	};
	
	@GetMapping("/all")
	public List<Shop> getShop(){
		
		List<Shop>shop= this.shopRepository.findAll();
		
		return shop;
	}
	
	
	
	
}
