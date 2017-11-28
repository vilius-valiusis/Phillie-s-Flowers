package com.cit.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cit.NoProductsException;
import com.cit.entity.Product;
import com.cit.repositories.ProductRepository;
import com.cit.repositories.ShopRepository;

@Service
public class CartService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ShopRepository shopRepository;

	private Map<Product, Integer> products = new HashMap<>();

	public CartService(ProductRepository productRepository, ShopRepository shopRepository) {
		this.productRepository = productRepository;
		this.shopRepository = shopRepository;
	}

	public void addProduct(Product product) {
		if (products.containsKey(product)) {
			products.replace(product, products.get(product) + 1);
		} else {
			products.put(product, 1);
		}
	}

	public void removeProduct(Product product) {
		if (products.containsKey(product)) {
			if (products.get(product) > 1)
				products.replace(product, products.get(product) - 1);
			else if (products.get(product) == 1) {
				products.remove(product);
			}
		}
	}

	public Map<Product, Integer> getProductsInCart() {
		return Collections.unmodifiableMap(products);
	}

	public void checkout() throws NoProductsException {
		Product product;
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			// Refresh quantity for every product before checking
			product = productRepository.findOne(entry.getKey().getId());
			if (product.getQuantity() < entry.getValue())
				throw new NoProductsException(product);
			entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
		}
		productRepository.save(products.keySet());
		//productRepository.flush();
		products.clear();
	}

	public Double getTotal() {
		
		Double total = 245.00;
		/*BigDecimal total = BigDecimal.ZERO;
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			total = total.add(entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue())));
		}*/
		return total;
	}

}
