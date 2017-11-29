package com.cit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cit.entity.Product;
import com.cit.services.CartService;
import com.cit.services.ProductService;
import com.cit.services.ShopService;

@Controller
@SessionAttributes("cartCount")
public class ViewController {

	int count = 0;

	@Autowired
	private ProductService productServiceImpl;

	@Autowired
	private CartService cartService;

	@Autowired
	private ShopService shopService;

	public ViewController(ProductService productServiceImpl, CartService cartService, ShopService shopService) {
		this.productServiceImpl = productServiceImpl;
		this.cartService = cartService;
		this.shopService = shopService;
	};

	
	
	@RequestMapping("/")
	public String index(ModelMap model) {

		model.addAttribute("productList", productServiceImpl.findAll());
		model.addAttribute("product", new Product());
		model.addAttribute("cartCount", cartService.getCartCount());

		return "index";
	}

	
	@RequestMapping("/about")
	public String about(ModelMap model) {
		
		return "about";
	}

	@RequestMapping("/specials")
	public String specials(ModelMap model) {
		
		return "specials";
	}

	@RequestMapping("/contact")
	public String contact(ModelMap model) {
		
		return "contact";
	}

	@RequestMapping("/cart")
	public String cart(ModelMap model) {

		
		model.addAttribute("cartList", cartService.getCartList());

		return "cart";
	}
	
	@RequestMapping("/cart/confirm")
	public String cartConfirm(ModelMap model) {
		
		//model.addAttribute("cartCount", cartService.getCartCount());
		return "checkConfirm";
	}

}
