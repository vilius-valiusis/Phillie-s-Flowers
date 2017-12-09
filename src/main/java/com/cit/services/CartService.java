package com.cit.services;
//CartService Interface that has all methods we need to keeping the cart updated.
import java.util.List;

import com.cit.entities.Bundle;

public interface CartService {

	public double getCartTotal();

	public void setCartTotal(double cartTotal);

	public int getCartCount();

	public void addCartCount();

	public void resetCartCount();

	public void resetCartTotal();

	public List<Bundle> findAll();

	public void addProduct(Bundle p);

	public List<Bundle> getCartList();

	public void resetCartList();

	public void addToCartTotal(Double amount);

}