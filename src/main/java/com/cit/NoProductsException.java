package com.cit;

import com.cit.entity.Product;

/**
 * Created by reljicd on 2/2/17.
 */
public class NoProductsException extends Exception {

    private Product product;
    private static final String DEFAULT_MESSAGE = "Not enough products in stock";

    public NoProductsException() {
        super(DEFAULT_MESSAGE);
    }

    public NoProductsException(Product product) {
        super("Not enough " + product.getName() + " products in stock. Only " + product.getQuantity() + " left");

        this.product = product;
    }

}