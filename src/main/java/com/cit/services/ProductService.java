package com.cit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cit.entity.Product;
import com.cit.entity.Shop;
import com.cit.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	public List<Product> findAll() {
		/*List<Product> productList = new ArrayList<>();
		productRepository.listAll().forEach(productList::add); */
		
		List<Product> productList = productRepository.findAll();
		
		return productList;
	}
	
	public Product getById(String id) {
		return productRepository.getById(id);
	}

	public Product getByName(String name) {
		return productRepository.getByName(name);
	}
	
	/*public void update(ArrayList<Product> cartList) {

		List<Product> productList = productRepository.findAll();
		for (Product p : productList) {

			productRepository.fin
		}

		productRepository.save();
	}*/
	
	

}
