package com.cit.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cit.NoProductsException;
import com.cit.entity.Product;
import com.cit.services.CartService;
import com.cit.services.ProductService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;
	
	public CartController(CartService cartService, ProductService productService) {
		this.productService= productService;
		this.cartService= cartService;			
};
	
	
	/*@PostMapping("/")
    public String addProduct(Model model) {
		//@ModelAttribute Product product, 
		int count= 0;
		count++;
		model.addAttribute("cartCount", count+"");
		
        return "index";
    }
	*/

	

	/*@GetMapping("/cart")
	public ModelAndView shoppingCart() {
		ModelAndView modelAndView = new ModelAndView("shoppingCart");
		modelAndView.addObject("products", cartService.getProductsInCart());
		modelAndView.addObject("total", cartService.getTotal().toString());
		return modelAndView;
	}

	@GetMapping("/cart/{productId}")
	public ModelAndView addProductToCart(@PathVariable("productId") String productId) {
		cartService.addProduct(productService.getById(productId));
		return "index";
	}

	@GetMapping("/cart/{productId}")
	public ModelAndView removeProductFromCart(@PathVariable("productId") String productId) {
		cartService.removeProduct(productService.getById(productId));
		return shoppingCart();
	}

	@GetMapping("/cart/checkout")
	public ModelAndView checkout() {
		try {
			cartService.checkout();
		} catch (NoProductsException e) {
			return shoppingCart().addObject("outOfStockMessage", e.getMessage());
		}
		return shoppingCart();
	}*/
}
