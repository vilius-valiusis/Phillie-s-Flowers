package com.cit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cit.entity.Product;
import com.cit.services.CartService;
import com.cit.services.ProductService;
import com.cit.services.ShopService;

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

	@PostMapping("/cart/add")
	public String addProduct(Product product, ModelMap model, RedirectAttributes redir) {

		cartService.addCartCount();
		cartService.getCartCount();
		cartService.addProduct(product);
		System.out.println(product.getPrice());
		cartService.addToCartTotal(product.getPrice());
		redir.addFlashAttribute("cartCount", cartService.getCartCount());

		return "redirect:/";
	}

	@GetMapping("/cart/checkout")
	public String checkout(ModelMap model) {

		cartService.resetCartCount();
		shopService.updateTotalOrders();
		shopService.updateTotalRevenue(cartService.getCartTotal());
		cartService.resetCartList();
		cartService.resetCartTotal();
		model.addAttribute("cartCount", cartService.getCartCount());

		return "checkConfirm";
	}

}
