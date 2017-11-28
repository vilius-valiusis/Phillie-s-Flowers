package com.cit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cit.entity.Product;
import com.cit.repositories.ProductRepository;
import com.cit.services.ProductService;


@Controller
public class ViewController {

	@Autowired
	private ProductService productServiceImpl;

	public ViewController(ProductService productServiceImpl) {
			this.productServiceImpl= productServiceImpl;
						
	};
	
	
	@PostMapping("/")
    public String addProduct(Model model) {
		//@ModelAttribute Product product, 
		int count= 0;
		count++;
		model.addAttribute("cartCount", count+"");
		
        return "index";
    }

	@RequestMapping("/")
	public String index(Model model) {
		
		List<Product> productList = productServiceImpl.findAll();
		model.addAttribute("productList", productList);
		
		Product p = productServiceImpl.getByName("valentines");
		model.addAttribute("product", p);
		//model.addAttribute("productName", p.getName());
		/*model.addAttribute("item1", p.getItem1());
		model.addAttribute("item2", p.getItem2());
		model.addAttribute("item3", p.getItem3());
		model.addAttribute("price", p.getPrice());*/
		return "index";
	}

	@RequestMapping("/about")
	public String about() {

		return "about";
	}

	@RequestMapping("/specials")
	public String specials() {

		return "specials";
	}
	
	@RequestMapping("/contact")
	public String contact() {

		return "contact";
	}

	@RequestMapping("/cart")
	public String cart() {

		return "cart";
	}

}
