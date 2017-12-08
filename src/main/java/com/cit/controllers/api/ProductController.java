package com.cit.controllers.api;
/*
 * API controller for products
 * Allowing for get update individual and multiple products   
 */
import com.cit.entities.api.Product;
import com.cit.repositories.api.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController
{
  @Autowired
  ProductRepository productRepository;
  
  @GetMapping("/api/products")
  public Iterable<Product> product()
  {
    return this.productRepository.findAll();
  }
  
  @PostMapping("/api/products")
  public String save(@RequestBody Product product)
  {
    this.productRepository.save(product);
    return product.getId();
  }
  
  @GetMapping("/api/products/{id}")
  public Product show(@PathVariable String id)
  {
    return this.productRepository.findOne(id);
  }
  
  @PutMapping("/api/products/{id}")
  public Product update(@PathVariable String id, @RequestBody Product product)
  {
    Product prod = this.productRepository.findOne(id);
    if (product.getName() != null) {
      prod.setName(product.getName());
    }
    if (product.getDescription() != null) {
      prod.setDescription(product.getDescription());
    }
    if (product.getPrice() != null) {
      prod.setPrice(product.getPrice());
    }
    prod.setQuantity(Integer.valueOf(product.getQuantity()));
    this.productRepository.save(prod);
    return prod;
  }
}
