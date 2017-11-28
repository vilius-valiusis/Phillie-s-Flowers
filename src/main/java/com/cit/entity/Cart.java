/*package com.cit.entity;


public class Cart {
    private int id;
    private String name;
    private Double price;
    private int quantity;
 
    public Cart() {
    }
 
    public Cart(int id, String name, Double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Double getPrice() {
        return price;
    }
 
    public void setPrice(Double price) {
        this.price = price;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    @Override
    public int hashCode() {
        return super.hashCode();
    }
 
    @Override
    public boolean equals(Object obj) {
        return this.getId() == ((Cart) obj).getId();
    }
 
    public void ToCart(Package p) {
        this.id = p.getId();
        this.name = p.getName();
        this.price = p.getPrice();
        this.quantity = 1;
    }
}*/