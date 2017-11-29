package com.cit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cit.entity.Product;
import com.cit.repositories.ProductRepository;

@Service
public class CartService {

	int cartCount;
	List<Product> cartList = new ArrayList<Product>();

	public CartService() {

	}

	public int getCartCount() {
		return cartCount;
	}

	public void addCartCount() {

		this.cartCount = cartCount + 1;
	}

	public void resetCartCount() {

		this.cartCount = 0;

	}

	public List<Product> findAll() {

		return cartList;
	}

	public void addProduct(Product p) {

		cartList.add(p);

	}

	public List<Product> getCartList() {

		return cartList;
	}
	
	public void resetCartList() {

		this.cartList = new ArrayList<Product>();
	}
}
