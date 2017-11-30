package com.cit.services;

import java.util.List;

import com.cit.entities.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product getById(String id);

	public Product getByName(String name);
}
