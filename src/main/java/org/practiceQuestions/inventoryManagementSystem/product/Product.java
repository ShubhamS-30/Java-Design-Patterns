package org.practiceQuestions.inventoryManagementSystem.product;

public abstract class Product {
    private String sku;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    private ProductCategory category;

    protected Product() {}

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public boolean isLowStock() {
        return quantity <= threshold;
    }

    public void restock(int amount) {
        this.quantity += amount;
    }

    public void removeStock(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough stock to remove");
        }
        this.quantity -= amount;
    }
}
