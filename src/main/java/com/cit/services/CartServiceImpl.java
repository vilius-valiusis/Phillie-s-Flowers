package com.cit.services;
//Cart Service Implmentation
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cit.entities.Bundle;

@Service
public class CartServiceImpl implements CartService {

	/*These variables are stored as sessions attributes and deleted after checkout. Not necessary to add to database if can be kept in
	session as it is short lived data.*/
	
	int cartCount;
	double cartTotal;
	List<Bundle> cartList = new ArrayList<Bundle>();

	public CartServiceImpl() {

	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
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

	public void resetCartTotal() {

		this.cartTotal = 0;

	}

	public List<Bundle> findAll() {

		return cartList;
	}

	public void addProduct(Bundle p) {

		cartList.add(p);

	}

	public List<Bundle> getCartList() {

		return cartList;
	}

	public void resetCartList() {

		this.cartList = new ArrayList<Bundle>();
	}

	public void addToCartTotal(Double amount) {

		cartTotal = cartTotal + amount;

	}
}