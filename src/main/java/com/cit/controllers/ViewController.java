package com.cit.controllers;

import com.cit.entities.Bundle;
import com.cit.services.BundleService;
import com.cit.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"cartCount", "cartTotal", "cartList", "productList"})
public class ViewController
{
  @Autowired
  private BundleService productService;
  @Autowired
  private CartService cartService;
  
  public ViewController(BundleService productService, CartService cartService)
  {
    this.productService = productService;
    this.cartService = cartService;
  }
  
  @RequestMapping({"/"})
  public String index(ModelMap model)
  {
    model.addAttribute("productList", this.productService.findAll());
    model.addAttribute("product", new Bundle());
    model.addAttribute("cartCount", Integer.valueOf(this.cartService.getCartCount()));
    model.addAttribute("cartTotal", Double.valueOf(this.cartService.getCartTotal()));
    model.addAttribute("cartList", this.cartService.getCartList());
    
    return "index";
  }
  
  @RequestMapping({"/about"})
  public String about(ModelMap model)
  {
    return "about";
  }
  
  @RequestMapping({"/specials"})
  public String specials(ModelMap model)
  {
    return "specials";
  }
  
  @RequestMapping({"/contact"})
  public String contact(ModelMap model)
  {
    return "contact";
  }
  
  @RequestMapping({"/cart"})
  public String cart(ModelMap model)
  {
    return "cart";
  }
  
  @GetMapping({"/login"})
  public String login(ModelMap model)
  {
    return "login";
  }
  
  @PostMapping({"/login"})
  public String loginSubmit(ModelMap model)
  {
    return "login";
  }
  
  @RequestMapping("/checkConfirm")
	public String cartConfirm(ModelMap model) {

		return "checkConfirm";
	}
}
