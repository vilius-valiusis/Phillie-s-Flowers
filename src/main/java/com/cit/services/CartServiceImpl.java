package com.cit.services;
//Cart Service Implmentation
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cit.entities.Product;

@Service
public class CartServiceImpl implements CartService {

	//These variables are stored as sessions attributes and deleted after checkout
	int cartCount;
	double cartTotal;
	List<Product> cartList = new ArrayList<Product>();

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

	public void addToCartTotal(Double amount) {

		cartTotal = cartTotal + amount;

	}
}
