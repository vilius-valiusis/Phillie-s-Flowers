package com.cit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cit.entities.api.Product;
import com.cit.repositories.api.ProductRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TestProductRepository {
	@Autowired
    private ProductRepository productRepository;
	
	// Testing product repository for post and get request to embedded mongo instance
	@Test
	public void testSaveAndGetProduct() throws Exception {
		Product p = new Product("dasy", "red", Double.valueOf(5.99D), Integer.valueOf(30));
		this.productRepository.save(p);
		Product find = this.productRepository.findByName("dasy");
		assertEquals(find.getName(), p.getName());
	}
	
}
