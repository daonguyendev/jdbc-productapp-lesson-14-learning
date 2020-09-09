package com.daonguyen.entity;

public class Product {
	private String id;
	private String name;
	private int amount;
	private float price;
	private String cateId;

	public Product() {
	}

    public Product(String id, String name, int amount, float price, String cateId) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.cateId = cateId;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }
}
