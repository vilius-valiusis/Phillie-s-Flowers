package com.cit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cit.entity.Product;
import com.cit.services.CartService;
import com.cit.services.ProductService;

@Controller

public class ViewController {

	int count = 0;

	@Autowired
	private ProductService productServiceImpl;

	@Autowired
	private CartService cartService;

	public ViewController(ProductService productServiceImpl, CartService cartService) {
		this.productServiceImpl = productServiceImpl;
		this.cartService = cartService;
	};

	@PostMapping("/")
	public String addProduct(Product product, Model model) {

		count++;
		cartService.addProduct(product);
		//System.out.println(product.getName());

		return index(model);
	}

	@RequestMapping("/")
	public String index(Model model) {

		//List<Product> productList = productServiceImpl.findAll();
		// List<Product> cartList = cartService.findAll();
		model.addAttribute("productList", productServiceImpl.findAll());
		model.addAttribute("product", new Product());
		model.addAttribute("cartCount", count + "");

		return "index";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("cartCount", count + "");
		return "about";
	}

	@RequestMapping("/specials")
	public String specials(Model model) {
		model.addAttribute("cartCount", count + "");
		return "specials";
	}

	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("cartCount", count + "");
		return "contact";
	}

	@RequestMapping("/cart")
	public String cart(Model model) {

		model.addAttribute("cartCount", count + "");
		model.addAttribute("cartList", cartService.getCartList());

		return "cart";
	}

}
