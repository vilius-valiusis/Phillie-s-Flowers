/*package com.cit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cit.entity.Product;
import com.cit.repositories.ProductRepository;

@RestController
@RequestMapping("/Products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
			this.productRepository= productRepository;
						
	};
	
	
	@RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", this.productRepository.listAll());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", this.productRepository.getById(id));
        return "product/show";
    }
	
	
	
}
*/