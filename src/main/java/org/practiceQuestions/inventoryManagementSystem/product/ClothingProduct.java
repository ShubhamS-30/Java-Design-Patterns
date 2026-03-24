package org.practiceQuestions.inventoryManagementSystem.product;

public class ClothingProduct extends Product{
    private String size;
    private String material;

    public ClothingProduct(String size, String material) {
        super();
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public void setSize(String size){
        this.size = size;
    }

    public void setMaterial(String material){
        this.material = material;
    }
}
