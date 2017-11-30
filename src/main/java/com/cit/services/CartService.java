package com.cit.services;
//CartService Interface
import java.util.List;

import com.cit.entities.Product;

public interface CartService {

	public double getCartTotal();

	public void setCartTotal(double cartTotal);

	public int getCartCount();

	public void addCartCount();

	public void resetCartCount();

	public void resetCartTotal();

	public List<Product> findAll();

	public void addProduct(Product p);

	public List<Product> getCartList();

	public void resetCartList();

	public void addToCartTotal(Double amount);

}
