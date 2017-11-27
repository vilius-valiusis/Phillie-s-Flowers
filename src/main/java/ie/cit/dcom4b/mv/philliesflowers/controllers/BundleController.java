package ie.cit.dcom4b.mv.philliesflowers.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.dcom4b.mv.philliesflowers.Repositories.BundleRepository;
import ie.cit.dcom4b.mv.philliesflowers.models.Bundle;

public class BundleController {
	@Autowired
    BundleRepository bundleRepository;
	//Find all products
    @RequestMapping(method=RequestMethod.GET, value="/bundles")
    public Iterable<Bundle> bundle() {
        return bundleRepository.findAll();
    }
    //Add new product
    @RequestMapping(method=RequestMethod.POST, value="/bundles")
    public String save(@RequestBody Bundle bundle) {
        bundleRepository.save(bundle);
        return bundle.getId();
    }

    //Get product by id
    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public Bundle show(@PathVariable String id) {
        return bundleRepository.findOne(id);
    }

    //Update the product 
    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public Bundle update(@PathVariable String id, @RequestBody Bundle bundle) {
    	Bundle bndl = bundleRepository.findOne(id);
    	if(bundle.getName() != null)
    		bndl.setName(bundle.getName());
    	if(bundle.getProducts() != null)
    		bndl.setProducts(bundle.getProducts());

        bundleRepository.save(bndl);
        return bndl;
    }
}
