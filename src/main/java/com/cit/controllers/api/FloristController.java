package com.cit.controllers.api;

import com.cit.entities.api.Florist;
import com.cit.repositories.api.FloristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FloristController
{
  @Autowired
  FloristRepository floristRepository;
  
  @GetMapping("/api/florists")
  public Iterable<Florist> florist()
  {
    return this.floristRepository.findAll();
  }
  
  @PostMapping("/api/florists")
  public String save(@RequestBody Florist florist)
  {
    this.floristRepository.save(florist);
    return florist.getId();
  }
  
  @GetMapping("/api/florists/{id}")
  public Florist show(@PathVariable String id)
  {
    return this.floristRepository.findOne(id);
  }
  
  @PutMapping("/api/florists/{id}")
  public Florist update(@PathVariable String id, @RequestBody Florist florist)
  {
    Florist flr = this.floristRepository.findOne(id);
    if (florist.getName() != null) {
      flr.setName(florist.getName());
    }
    if (florist.getOrders() != null) {
      flr.setOrders(florist.getOrders());
    }
    this.floristRepository.save(flr);
    return flr;
  }
}
