package com.cit.controllers.api;

import com.cit.entities.api.Product;
import com.cit.repositories.api.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController
{
  @Autowired
  ProductRepository productRepository;
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/api/products"})
  public Iterable<Product> product()
  {
    return this.productRepository.findAll();
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, value={"/api/products"})
  public String save(@RequestBody Product product)
  {
    this.productRepository.save(product);
    return product.getId();
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/api/products/{id}"})
  public Product show(@PathVariable String id)
  {
    return this.productRepository.findOne(id);
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.PUT}, value={"/api/products/{id}"})
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
