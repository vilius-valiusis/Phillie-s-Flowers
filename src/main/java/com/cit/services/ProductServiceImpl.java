package com.cit.services;
//Product Service Implementation
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cit.entities.Product;
import com.cit.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	public List<Product> findAll() {

		List<Product> productList = productRepository.findAll();

		return productList;
	}

	public Product getById(String id) {
		return productRepository.getById(id);
	}

	public Product getByName(String name) {
		return productRepository.getByName(name);
	}

}
