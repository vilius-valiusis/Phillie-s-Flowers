package com.cit.controllers.api;

import com.cit.entities.api.Order;
import com.cit.repositories.api.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController
{
  @Autowired
  OrderRepository orderRepository;
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/api/orders"})
  public Iterable<Order> order()
  {
    return this.orderRepository.findAll();
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, value={"/api/orders"})
  public String save(@RequestBody Order bundle)
  {
    this.orderRepository.save(bundle);
    return bundle.getId();
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/api/orders/{id}"})
  public Order show(@PathVariable String id)
  {
    return this.orderRepository.findOne(id);
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.PUT}, value={"/api/orders/{id}"})
  public Order update(@PathVariable String id, @RequestBody Order order)
  {
    Order ord = this.orderRepository.findOne(id);
    order.setPaid(order.isPaid());
    ord.setTotalCost(order.getTotalCost());
//    if (order.getProducts() != null) {
//      ord.setProducts(order.getProducts());
//    }
    this.orderRepository.save(ord);
    return ord;
  }
}
