package ie.cit.dcom4b.mv.philliesflowers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ie.cit.dcom4b.mv.philliesflowers.models.Bundle;
import ie.cit.dcom4b.mv.philliesflowers.models.Florist;
import ie.cit.dcom4b.mv.philliesflowers.models.Order;
import ie.cit.dcom4b.mv.philliesflowers.models.Product;
import ie.cit.dcom4b.mv.philliesflowers.repositories.BundleRepository;
import ie.cit.dcom4b.mv.philliesflowers.repositories.FloristRepository;
import ie.cit.dcom4b.mv.philliesflowers.repositories.OrderRepository;
import ie.cit.dcom4b.mv.philliesflowers.repositories.ProductRepository;
@Component
public class DbSeeder implements CommandLineRunner{
	
	private ProductRepository productRepository;
	private BundleRepository bundleRepository;
	private OrderRepository orderRepository;
	private FloristRepository floristRepository;
	
	public DbSeeder(ProductRepository productRepository,BundleRepository bundleRepository, OrderRepository orderRepository, FloristRepository floristRepository) {
		this.productRepository = productRepository;
		this.bundleRepository = bundleRepository;
		this.orderRepository = orderRepository;
		this.floristRepository = floristRepository;
	}
	public void run(String... strings) throws Exception {
		
		List<Product> philliesProd = new ArrayList<Product>();
		philliesProd.add(new Product("rose","red rose",5.99, 300));
		philliesProd.add(new Product("lily","red lily",6.99, 400));
		philliesProd.add(new Product("Narcissus","red Narcissus",4.99, 200));
		philliesProd.add(new Product("Daisy","red Daisy",2.99, 500));
		philliesProd.add(new Product("Amaryllis","red Amaryllis",2.99, 700));
		
		Bundle b1 = new Bundle("bundle 1", Arrays.asList(philliesProd.get(0),philliesProd.get(1),philliesProd.get(2),philliesProd.get(3)));
		Bundle b2 = new Bundle("bundle 2", Arrays.asList(philliesProd.get(1),philliesProd.get(2),philliesProd.get(3),philliesProd.get(4)));
		Bundle b3 = new Bundle("bundle 3", Arrays.asList(philliesProd.get(2),philliesProd.get(3),philliesProd.get(4),philliesProd.get(0)));
		Bundle b4 = new Bundle("bundle 4", Arrays.asList(philliesProd.get(3),philliesProd.get(4),philliesProd.get(0),philliesProd.get(1)));
		
		Order or1 = new Order(true, 26.98, Arrays.asList(philliesProd.get(0),philliesProd.get(1),philliesProd.get(2),philliesProd.get(3)), Arrays.asList(b4));
		Order or2 = new Order(true, 32.98, Arrays.asList(philliesProd.get(1),philliesProd.get(2),philliesProd.get(3),philliesProd.get(4)), Arrays.asList(b3));
		Order or3 = new Order(false, 43.98, Arrays.asList(philliesProd.get(2),philliesProd.get(3),philliesProd.get(4),philliesProd.get(0)), Arrays.asList(b2));
		Order or4 = new Order(true, 52.98,  Arrays.asList(philliesProd.get(3),philliesProd.get(4),philliesProd.get(0),philliesProd.get(1)), Arrays.asList(b1));
		Order or5 = new Order(true, 52.98,  Arrays.asList(philliesProd.get(4),philliesProd.get(0),philliesProd.get(1),philliesProd.get(2)), Arrays.asList(b1,b2,b1));
		
		Florist fl1 = new Florist("Dave", Arrays.asList(or1,or2));
		Florist fl2 = new Florist("Smith", Arrays.asList(or3,or4));
		
		
		
		List<Bundle> philliesBundle = new ArrayList<Bundle>();
		philliesBundle.add(b1);
		philliesBundle.add(b2);
		philliesBundle.add(b3);
		philliesBundle.add(b4);
		
		List<Order> philliesOrder = new ArrayList<Order>();
		philliesOrder.add(or1);
		philliesOrder.add(or2);
		philliesOrder.add(or3);
		philliesOrder.add(or4);
		philliesOrder.add(or5);
		
		List<Florist> philliesFlorist = new ArrayList<Florist>();
		philliesFlorist.add(fl1);
		philliesFlorist.add(fl2);
		
		//drop shops because you want to have fresh database each run
		this.productRepository.deleteAll();
		this.bundleRepository.deleteAll();
		this.orderRepository.deleteAll();
		this.floristRepository.deleteAll();
		
		//add shops
		for(Product p : philliesProd)
			this.productRepository.save(p);
		
		for(Bundle b : philliesBundle)
			this.bundleRepository.save(b);
		
		for(Order o : philliesOrder)
			this.orderRepository.save(o);
		
		for(Florist f : philliesFlorist)
			this.floristRepository.save(f);
	}

}
