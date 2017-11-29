package com.cit.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cit.NoProductsException;
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
	private ProductService productService;

	@Autowired
	private ShopService shopService;

	public CartController(CartService cartService, ProductService productService, ShopService shopService) {
		this.productService = productService;
		this.cartService = cartService;
		this.shopService = shopService;
	};

	@PostMapping("/cart/add")
	public String addProduct(Product product, ModelMap model, RedirectAttributes redir) {

		cartService.addCartCount();
		cartService.getCartCount();
		cartService.addProduct(product);
		redir.addFlashAttribute("cartCount",cartService.getCartCount());
		
		return "redirect:/";
	}

	@GetMapping("/cart/checkout")
	public String checkout(ModelMap model) {
		
		cartService.resetCartCount();
		shopService.update();
		cartService.resetCartList();
		model.addAttribute("cartCount", cartService.getCartCount()); 
		
		return "checkConfirm";
	}

}
