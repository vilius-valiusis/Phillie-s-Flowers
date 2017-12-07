package com.cit.services;
//Product Service Implementation
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cit.entities.Bundle;
import com.cit.repositories.BundleRepository;

@Service
public class BundleServiceImpl implements BundleService {

	@Autowired
	private BundleRepository productRepository;

	public BundleServiceImpl(BundleRepository productRepository) {
		this.productRepository = productRepository;

	}

	public List<Bundle> findAll() {

		List<Bundle> productList = productRepository.findAll();

		return productList;
	}

	public Bundle getById(String id) {
		return productRepository.getById(id);
	}

	public Bundle getByName(String name) {
		return productRepository.getByName(name);
	}

}
