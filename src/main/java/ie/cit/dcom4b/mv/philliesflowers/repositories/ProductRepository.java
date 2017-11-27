package ie.cit.dcom4b.mv.philliesflowers.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ie.cit.dcom4b.mv.philliesflowers.models.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

	@Override
	Product findOne(String id);
}
