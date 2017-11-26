package com.cit;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
public class ShopController {
	private ShopRepository shopRepository;
	
	
	
	public ShopController(ShopRepository shopRepository) {
			this.shopRepository= shopRepository;
						
	};
	
	
	public List<Shop> getShop(){
		
		List<Shop> shops = this.shopRepository.findAll();
		
		return shops;
	}
}
