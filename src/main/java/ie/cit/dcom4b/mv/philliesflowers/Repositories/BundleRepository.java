package ie.cit.dcom4b.mv.philliesflowers.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ie.cit.dcom4b.mv.philliesflowers.models.Bundle;

public interface BundleRepository extends MongoRepository<Bundle, String>{
	
	@Override
	Bundle findOne(String id);
}
