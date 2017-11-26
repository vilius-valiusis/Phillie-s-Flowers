package com.cit;
//retrieve/add stats to database
public class ShopStats {
	
	private int totalOrders;
	private int totalRevenue;
	private String bestPackage;
	
	

	public ShopStats(int totalOrders, int totalRevenue, String bestPackage) {
		this.totalOrders = totalOrders;
		this.totalRevenue = totalRevenue;
		this.bestPackage = bestPackage;
	}

	public int getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}

	public int getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public String getBestPackage() {
		return bestPackage;
	}

	public void setBestPackage(String bestPackage) {
		this.bestPackage = bestPackage;
	}

	@Override
	public String toString() {
		return "ShopStats [totalOrders=" + totalOrders + ", totalRevenue=" + totalRevenue + ", bestPackage="
				+ bestPackage + "]";
	}
	
	
	

}
