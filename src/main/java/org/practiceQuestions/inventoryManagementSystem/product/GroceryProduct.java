package org.practiceQuestions.inventoryManagementSystem.product;

public class GroceryProduct extends Product{
    private String expirationDate;
    private boolean requiresRefrigeration;

    public GroceryProduct(String expirationDate, boolean requiresRefrigeration) {
        super();
        this.expirationDate = expirationDate;
        this.requiresRefrigeration = requiresRefrigeration;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public boolean isRequiresRefrigeration() {
        return requiresRefrigeration;
    }

    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }

    public void setRequiresRefrigeration(boolean requiresRefrigeration){
        this.requiresRefrigeration = requiresRefrigeration;
    }
}
