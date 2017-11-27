package ie.cit.dcom4b.mv.philliesflowers.models;

import java.util.List;

import javax.persistence.Id;

public class Bundle {
	
	@Id
	private String id;
	
	private String name;
	private List<Product> products;
	
	public Bundle(String name, List<Product> products) {
		this.name = name;
		this.products = products;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bundle [id=" + id + ", products=" + products + "]";
	}
	
}
