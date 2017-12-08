package com.cit.utils;

import com.cit.entities.Bundle;
import com.cit.entities.Shop;
import com.cit.entities.api.Florist;
import com.cit.entities.api.Order;
import com.cit.entities.api.Product;
import com.cit.repositories.BundleRepository;
import com.cit.repositories.ShopRepository;
import com.cit.repositories.api.FloristRepository;
import com.cit.repositories.api.OrderRepository;
import com.cit.repositories.api.ProductRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader
  implements ApplicationRunner
{
  @Autowired
  private ShopRepository shopRepository;
  @Autowired
  private BundleRepository bundleRepository;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private FloristRepository floristRepository;
  
  public void run(ApplicationArguments arg0)
    throws Exception
  {
    Shop phillies = new Shop("Phillies", 0, Double.valueOf(0.0D), "Valentines Package");
    
    List<Product> philliesProd = new ArrayList<Product>();
    
  
    philliesProd.add(new Product("rose", "red rose", Double.valueOf(5.99D), Integer.valueOf(300)));
    philliesProd.add(new Product("lily", "red lily", Double.valueOf(6.99D), Integer.valueOf(400)));
    philliesProd.add(new Product("Narcissus", "red Narcissus", Double.valueOf(4.99D), Integer.valueOf(200)));
    philliesProd.add(new Product("Daisy", "red Daisy", Double.valueOf(2.99D), Integer.valueOf(500)));
    philliesProd.add(new Product("Amaryllis", "red Amaryllis", Double.valueOf(2.99D), Integer.valueOf(700)));
    
    Product op1 = new Product("rose", "red rose", Double.valueOf(5.99D), Integer.valueOf(30));
    Product op2 = new Product("lily", "red lily", Double.valueOf(6.99D), Integer.valueOf(24));
    Product op3 = new Product("Narcissus", "red Narcissus", Double.valueOf(4.99D), Integer.valueOf(22));
    Product op4 = new Product("Daisy", "red Daisy", Double.valueOf(2.99D), Integer.valueOf(50));
    Product op5 = new Product("Amaryllis", "red Amaryllis", Double.valueOf(2.99D), Integer.valueOf(60));
    
    
    ArrayList<Bundle> bundles = new ArrayList<Bundle>();
    Bundle p1 = new Bundle("Valentines Package", "Red Roses", "Luxury Chocolates", "Heart shaped Teddy", 50.00, 5, "images/prod4.gif");
	Bundle p2 = new Bundle("Easter Package", "Selection of Daffodils", "Easter Egg", "Chick shaped Teddy", 45.00, 10, "images/easter.gif");
	Bundle p3 = new Bundle("Christmas Package", "Selection of Tulips", "Xmas Pudding", "Xmas Stocking", 65.00, 3, "images/xmas.gif");
	Bundle p4 = new Bundle("Birthday Package", "Venus Flytrap", "Custom Birthday Cake", "Gift Voucher", 85.00, 22, "images/cake.png");
	
	bundles.add(p1);
	bundles.add(p2);
	bundles.add(p3);
	bundles.add(p4);
    
    Order or1 = new Order(true, 26.98D, Arrays.asList(new Product[] { op1,op2,op3}));
    Order or2 = new Order(true, 32.98D, Arrays.asList(new Product[] { op2,op4,op1}));
    Order or3 = new Order(false, 43.98D, Arrays.asList(new Product[] {op5,op4,op1}));
    Order or4 = new Order(true, 52.98D, Arrays.asList(new Product[] { op2}));
    Order or5 = new Order(true, 52.98D, Arrays.asList(new Product[] { op5}));
    
    Florist fl1 = new Florist("Dave", Arrays.asList(new Order[] { or1, or2 }));
    Florist fl2 = new Florist("Smith", Arrays.asList(new Order[] { or3, or4 }));
    Florist fl3 = new Florist("Anna", Arrays.asList(new Order[] { or2, or1 , or3}));
    Florist fl4 = new Florist("Bob", Arrays.asList(new Order[] { or2, or1 , or3}));
    
    List<Bundle> philliesBundle = new ArrayList<Bundle>();
    philliesBundle.add(p1);
    philliesBundle.add(p2);
    philliesBundle.add(p3);
    philliesBundle.add(p4);
    
    List<Order> philliesOrder = new ArrayList<Order>();
    philliesOrder.add(or1);
    philliesOrder.add(or2);
    philliesOrder.add(or3);
    philliesOrder.add(or4);
    philliesOrder.add(or5);
    
    List<Florist> philliesFlorist = new ArrayList<Florist>();
    philliesFlorist.add(fl1);
    philliesFlorist.add(fl2);
    philliesFlorist.add(fl3);
    philliesFlorist.add(fl4);
    
    repositoriesDeleteAll();
    
    this.shopRepository.save(phillies);
    this.bundleRepository.save(bundles);
    this.productRepository.save(philliesProd);
    this.orderRepository.save(philliesOrder);
    this.floristRepository.save(philliesFlorist);
  }
  
  private void repositoriesDeleteAll()
  {
    this.shopRepository.deleteAll();
    this.productRepository.deleteAll();
    this.bundleRepository.deleteAll();
    this.orderRepository.deleteAll();
    this.floristRepository.deleteAll();
  }
}
