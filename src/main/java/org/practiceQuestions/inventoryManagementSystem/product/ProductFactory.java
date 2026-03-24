package org.practiceQuestions.inventoryManagementSystem.product;

public class ProductFactory {

    /**
     * Factory method to create products based on category with all required attributes.
     * 
     * @param sku Unique Stock Keeping Unit identifier for the product
     * @param name Product name
     * @param price Product price
     * @param category Product category (ELECTRONICS, CLOTHING, GROCERY)
     * @param threshold Minimum stock level before replenishment is needed
     * @param warrantyPeriod Warranty period for electronics (in months)
     * @param brand Brand name for electronics
     * @param size Size for clothing products
     * @param material Material for clothing products
     * @param expirationDate Expiration date for grocery products
     * @param requiresRefrigeration Whether grocery product requires refrigeration
     * @return A fully initialized Product object
     */
    public Product createProduct(String sku, String name, double price, int threshold,
                                ProductCategory category, Integer warrantyPeriod, String brand,
                                String size, String material, String expirationDate, 
                                boolean requiresRefrigeration) {
        
        Product product = switch (category) {
            case ELECTRONICS -> new ElectronicsProduct(warrantyPeriod, brand);
            case CLOTHING -> new ClothingProduct(size, material);
            case GROCERY -> new GroceryProduct(expirationDate, requiresRefrigeration);
            default -> throw new IllegalArgumentException("Invalid product category: " + category);
        };
        
        // Set common product attributes
        product.setSku(sku);
        product.setName(name);
        product.setPrice(price);
        product.setThreshold(threshold);
        product.setCategory(category);
        
        return product;
    }
}
