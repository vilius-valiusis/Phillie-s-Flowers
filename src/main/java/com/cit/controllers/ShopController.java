package com.cit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cit.entity.Shop;
import com.cit.repositories.ShopRepository;

@RestController
@RequestMapping("/shops")
public class ShopController {

	@Autowired
	private ShopRepository shopRepository;

	public ShopController(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;

	};

	/*@RequestMapping("/shop/show/{id}")
	public String getProduct(@PathVariable String id, Model model) {
		model.addAttribute("shop", this.shopRepository.getById(id));
		return "shop/show";
	}*/
	
	

}
