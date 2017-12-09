package com.cit.services;
//Bundle Service Implementation. Uses autowired bundle repository to make access data base data.
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cit.entities.Bundle;
import com.cit.repositories.BundleRepository;

@Service
public class BundleServiceImpl implements BundleService {

	@Autowired
	private BundleRepository bundleRepository;

	public BundleServiceImpl(BundleRepository productRepository) {
		this.bundleRepository = productRepository;

	}

	public List<Bundle> findAll() {

		List<Bundle> productList = bundleRepository.findAll();

		return productList;
	}

	public Bundle getById(String id) {
		return bundleRepository.getById(id);
	}

	public Bundle getByName(String name) {
		return bundleRepository.getByName(name);
	}

}
