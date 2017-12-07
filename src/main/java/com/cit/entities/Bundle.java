package com.cit.entities;
//Product entity with @Document adn @Id for database use
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Bundle {

	@Id
	private String id;
	private String name;
	private String item1;
	private String item2;
	private String item3;
	private Double price;
	private int quantity;
	private String imageUrl;
	public Bundle() {

		

	}

	public Bundle(String name, String item1, String item2, String item3, Double price, int quantity, String imageUrl) {

		this.price = price;
		this.name = name;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.quantity = quantity;
		this.imageUrl=imageUrl;
	}
	
	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
