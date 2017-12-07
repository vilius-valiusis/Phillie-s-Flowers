package com.cit.controllers;

import com.cit.services.RestServiceImpl;
import com.cit.services.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController
{
  private RestServiceImpl restfulClient;
  @Autowired
  private ShopService shopService;
  
  public DashboardController()
  {
    this.restfulClient = new RestServiceImpl();
  }
  
  @RequestMapping({"/dashboard"})
  public String dashboard(ModelMap model)
  {
    return "/dashboard";
  }
  
  @RequestMapping({"/dashboard/products"})
  public String products(Model model)
  {
    model.addAttribute("products", this.restfulClient.getProducts());
    return "/dashboard";
  }
  
  @RequestMapping({"/dashboard/orders"})
  public String florists(Model model)
  {
	model.addAttribute("orders", this.restfulClient.getFlorists());
    return "/dashboard";
  }
  
  @RequestMapping({"/dashboard/statistics"})
  public String statistics(ModelMap model)
  {
	model.addAttribute("statistics", this.shopService.getByName("Phillies"));
    return "/dashboard";
  }
}
