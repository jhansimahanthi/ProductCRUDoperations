package com.codegnan.model;

public class Product {
	

	    private int productId;
	    private String productName;
	    private double price;
	    private String category;

	    public Product() {}

	    public Product(int productId, String productName, double price, String category) {
	        this.productId = productId;
	        this.productName = productName;
	        this.price = price;
	        this.category = category;
	    }

	    // Getters and Setters
	    public int getProductId() {
	        return productId;
	    }
	    public void setProductId(int productId) {
	        this.productId = productId;
	    }
	    public String getProductName() {
	        return productName;
	    }
	    public void setProductName(String productName) {
	        this.productName = productName;
	    }
	    public double getPrice() {
	        return price;
	    }
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    public String getCategory() {
	        return category;
	    }
	    public void setCategory(String category) {
	        this.category = category;
	    }

	    @Override
	    public String toString() {
	       return "Product [productId=" + productId + ",productName=" + productName + ",price=" +price + ",category=" +category + "]";
	    }

}
