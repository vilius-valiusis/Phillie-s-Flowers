package com.cit;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="Shops")
public class Shop {

	@Id
	private String id;
	private String name;
	private ShopStats shopStats;
	@Field
	private List<Package> packages;
	

	public Shop(String name, ShopStats shopStats, List<Package> packages) {
		this.name = name;
		this.shopStats = shopStats;
		this.packages = packages;
	
	}

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ShopStats getShopStats() {
		return shopStats;
	}


	public void setShopStats(ShopStats shopStats) {
		this.shopStats = shopStats;
	}


	public List<Package> getPackages() {
		return this.packages;
	}
	
	
	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}
	
	
}

