package com.cit.controllers;

/*
 The CartController handles all shopping cart activity making use of
 CartService and ShopService to update the database. */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cit.entities.Bundle;
import com.cit.services.CartService;
import com.cit.services.ShopService;

//Set Controller and Session Annotations. Sessions keeps cartCount on all pages.
@Controller
@SessionAttributes("cartCount")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ShopService shopService;

	public CartController(CartService cartService, ShopService shopService) {
		this.cartService = cartService;
		this.shopService = shopService;
	};

	/*Thymeleaf allows me to send object in post request without having to map it. I
	 Then use cartService to make updates to the cart. I also used a redirect variable 
	 that allows me retrun to previous page and update cartCount.*/
	
	@PostMapping("/cart/add")															
	public String addProduct(Bundle product, ModelMap model, RedirectAttributes redir) {

		cartService.addCartCount();
		cartService.getCartCount();
		cartService.addProduct(product);
		cartService.addToCartTotal(product.getPrice());
		redir.addFlashAttribute("cartCount", cartService.getCartCount());				

		return "redirect:/specials";
	}

	
	@GetMapping("/cart/checkout")
	public String checkout(ModelMap model) {

		cartService.resetCartCount();
		shopService.updateTotalOrders();
		shopService.updateTotalRevenue(cartService.getCartTotal());
		cartService.resetCartList();
		cartService.resetCartTotal();
		model.addAttribute("cartCount", cartService.getCartCount());					

		return "redirect:/checkConfirm";
	}

}