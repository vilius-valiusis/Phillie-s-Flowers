package com.cit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cit.entities.api.Florist;
import com.cit.entities.api.Order;
import com.cit.entities.api.Product;
import com.cit.repositories.api.FloristRepository;
import com.cit.repositories.api.ProductRepository;
import com.cit.services.api.RestService;
import com.cit.services.api.RestServiceImpl;

@RunWith(SpringRunner.class)
@DataMongoTest
@RestClientTest(RestService.class)
public class TestRestServiceImpl {
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public RestService employeeService() {
            return new RestServiceImpl();
        }
    }
	@Autowired
	private RestService restService;

	@Autowired
	private FloristRepository floristRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void tesRestServiceGetFlorists() {
		Florist fl1 = new Florist("David", Arrays.asList(new Order[] {}));
		this.floristRepository.save(fl1);
		List<Florist> florists = this.restService.getFlorists();
		for(Florist f: florists) {
			if(f.getName().equals(fl1.getName()))
				assertEquals(f.getName(), fl1.getName());
		}
	}
	
	@Test
	public void tesRestServiceGetProducts() {
		Product prod = new Product("chocolate", "dark", 3.15, 5);
		this.productRepository.save(prod);
		List<Product> products = this.restService.getProducts();
		for(Product p: products) {
			if(p.getName().equals(prod.getName()))
				assertEquals(prod.getName(), p.getName());
		}
	}
	
	
}
