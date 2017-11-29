package ie.cit.dcom4b.mv.philliesflowers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ie.cit.dcom4b.mv.philliesflowers.models.Bundle;

public interface BundleRepository extends MongoRepository<Bundle, String>{
	
	@Override
	Bundle findOne(String id);
}
