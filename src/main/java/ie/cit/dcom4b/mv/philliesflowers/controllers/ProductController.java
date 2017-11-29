package ie.cit.dcom4b.mv.philliesflowers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.dcom4b.mv.philliesflowers.models.Product;
import ie.cit.dcom4b.mv.philliesflowers.repositories.ProductRepository;

public class ProductController {
	@Autowired
    ProductRepository productRepository;
	//Find all products
    @RequestMapping(method=RequestMethod.GET, value="/products")
    public Iterable<Product> product() {
        return productRepository.findAll();
    }
    //Add new product
    @RequestMapping(method=RequestMethod.POST, value="/products")
    public String save(@RequestBody Product product) {
        productRepository.save(product);
        return product.getId();
    }

    //Get product by id
    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public Product show(@PathVariable String id) {
        return productRepository.findOne(id);
    }

    //Update the product 
    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        Product prod = productRepository.findOne(id);
        if(product.getName() != null)
            prod.setName(product.getName());
        if(product.getDescription() != null)
            prod.setDescription(product.getDescription());
        if(product.getPrice() != null)
            prod.setPrice(product.getPrice());
        prod.setQuantity(product.getQuantity());
        productRepository.save(prod);
        return prod;
    }
}
