package com.cit.controllers;
/*This controller sets up all views, model attributes and main request mappings for webpage naviagtion*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.cit.entities.Product;
import com.cit.services.CartService;
import com.cit.services.ProductService;

//Similar to cart controller with more session attributes to keep persistency
@Controller
@SessionAttributes({ "cartCount", "cartTotal", "cartList", "productList" })
public class ViewController {


	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	public ViewController(ProductService productService, CartService cartService) {
		this.productService = productService;
		this.cartService = cartService;

	};
 
	@RequestMapping("/")
	public String index(ModelMap model) {

		model.addAttribute("productList", productService.findAll());
		model.addAttribute("product", new Product());
		model.addAttribute("cartCount", cartService.getCartCount());
		model.addAttribute("cartTotal", cartService.getCartTotal());
		model.addAttribute("cartList", cartService.getCartList());

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

		return "cart";
	}

	@RequestMapping("/cart/confirm")
	public String cartConfirm(ModelMap model) {

		return "checkConfirm";
	}

}
