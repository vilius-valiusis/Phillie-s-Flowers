package com.cit.controllers.api;
/*
 * API controller for Orders
 * Allowing for get update individual and multiple orders   
 */
import com.cit.entities.api.Order;
import com.cit.repositories.api.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController{
  @Autowired
  OrderRepository orderRepository;
  
  @GetMapping("/api/orders")
  public Iterable<Order> order()
  {
    return this.orderRepository.findAll();
  }
  
  @PostMapping("/api/orders")
  public String save(@RequestBody Order bundle){
    this.orderRepository.save(bundle);
    return bundle.getId();
  }
  
  @GetMapping("/api/orders/{id}")
  public Order show(@PathVariable String id){
    return this.orderRepository.findOne(id);
  }
  
  @PutMapping("/api/orders/{id}")
  public Order update(@PathVariable String id, @RequestBody Order order){
    Order ord = this.orderRepository.findOne(id);
    order.setPaid(order.isPaid());
    ord.setTotalCost(order.getTotalCost());
    this.orderRepository.save(ord);
    return ord;
  }
}
