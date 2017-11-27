package ie.cit.dcom4b.mv.philliesflowers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ie.cit.dcom4b.mv.philliesflowers.Repositories.BundleRepository;
import ie.cit.dcom4b.mv.philliesflowers.Repositories.ProductRepository;
import ie.cit.dcom4b.mv.philliesflowers.models.Bundle;
import ie.cit.dcom4b.mv.philliesflowers.models.Product;
@Component
public class DbSeeder implements CommandLineRunner{
	
	private ProductRepository productRepository;
	private BundleRepository bundleRepository;
	
	public DbSeeder(ProductRepository productRepository,BundleRepository bundleRepository) {
		this.productRepository = productRepository;
		this.bundleRepository = bundleRepository;
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
		
		List<Bundle> philliesBundle = new ArrayList<Bundle>();
		philliesBundle.add(b1);
		philliesBundle.add(b2);
		philliesBundle.add(b3);
		philliesBundle.add(b4);
		
		//drop shops because you want to have fresh database each run
		this.productRepository.deleteAll();
		this.bundleRepository.deleteAll();
		
		//add shops
		for(Product p : philliesProd)
			this.productRepository.save(p);
		
		for(Bundle b : philliesBundle)
			this.bundleRepository.save(b);
	}

}
