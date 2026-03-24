package org.practiceQuestions.inventoryManagementSystem.product;

public class ElectronicsProduct extends Product{
    private int warrantyPeriod; // in months
    private String brand;

    public ElectronicsProduct(int warrantyPeriod, String brand) {
        super();
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod){
        this.warrantyPeriod = warrantyPeriod;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
}
