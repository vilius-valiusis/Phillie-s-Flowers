package com.cit.services;
//Bundle service interface
import java.util.List;

import com.cit.entities.Bundle;

public interface BundleService {

	public List<Bundle> findAll();

	public Bundle getById(String id);

	public Bundle getByName(String name);
}
