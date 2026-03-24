package org.practiceQuestions.inventoryManagementSystem.warehouse;

import org.practiceQuestions.inventoryManagementSystem.inventoryManager.InventoryManager;
import org.practiceQuestions.inventoryManagementSystem.product.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Warehouse class representing a physical warehouse location in the inventory system.
 * 
 * A warehouse serves as a storage location for products and manages inventory at that specific location.
 * Multiple warehouses can exist across different geographic regions to support distributed inventory management.
 * 
 * Key Responsibilities:
 * 1. Store and manage products at a specific location
 * 2. Track product quantities and availability
 * 3. Handle addition and removal of products
 * 4. Provide product information and availability checks
 * 
 * Data Structure:
 * - Uses HashMap<String, Product> for O(1) lookup by SKU
 * - Key: Product SKU (Stock Keeping Unit) - unique identifier
 * - Value: Product object with quantity and details
 * 
 * Properties:
 * - warehouseId: Unique identifier for the warehouse
 * - name: Human-readable warehouse name
 * - location: Geographic location (city, region, country, etc.)
 * - inventory: HashMap storing SKU -> Product mappings
 * 
 * Example Usage:
 * ```
 * Warehouse warehouse = new Warehouse(1, "Central Warehouse", "New York");
 * Product laptop = ... // Create a product
 * warehouse.addProduct(laptop, 10);  // Add 10 laptops
 * warehouse.removeProduct("SKU-001", 2); // Remove 2 units
 * warehouse.getAvailableQuantity("SKU-001"); // Check availability
 * ```
 * 
 * @author Inventory System Team
 * @version 1.0
 * @see Product
 * @see InventoryManager
 */
public class Warehouse {
    // Unique identifier for this warehouse
    private int warehouseId;
    
    // Geographic location of the warehouse
    private String location;
    
    // Human-readable name for this warehouse
    private String name;
    
    // Inventory storage: Maps SKU (Stock Keeping Unit) to Product objects
    // Using HashMap provides O(1) average-case lookup performance
    private Map<String, Product> inventory;

    /**
     * Constructor to initialize a warehouse with identification details and location.
     * 
     * @param warehouseId Unique identifier for the warehouse
     * @param name Human-readable name of the warehouse
     * @param location Geographic location of the warehouse (city, region, etc.)
     * @postcondition Warehouse is initialized with empty inventory HashMap
     */
    public Warehouse(int warehouseId, String name, String location) {
        this.warehouseId = warehouseId;
        this.name = name;
        this.location = location;
        this.inventory = new HashMap<>();
        System.out.println("[DEBUG] Warehouse initialized: ID=" + warehouseId + 
                          ", Name=" + name + ", Location=" + location);
    }

    /**
     * Gets the unique warehouse identifier.
     * 
     * @return The warehouse ID
     */
    public int getWarehouseId() {
        return warehouseId;
    }

    /**
     * Gets the geographic location of the warehouse.
     * 
     * @return The warehouse location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the name of the warehouse.
     * 
     * @return The warehouse name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the complete inventory map (SKU -> Product mapping).
     * 
     * Note: This provides direct access to the internal HashMap.
     * Modifications to the returned map will affect the warehouse inventory.
     * 
     * @return Map of SKU to Product objects
     */
    public Map<String, Product> getInventory() {
        System.out.println("[DEBUG] Inventory map requested for warehouse: " + name);
        return inventory;
    }

    /**
     * Adds a product to the warehouse inventory or increases quantity if already present.
     * 
     * This method implements the add-or-update logic:
     * - If product SKU already exists: increment quantity
     * - If product SKU is new: create new inventory entry
     * 
     * @param product The Product object to add
     * @param quantity The number of units to add
     * @precondition product != null, quantity > 0
     * @postcondition Warehouse inventory is updated and confirmation logged
     */
    public void addProduct(Product product, int quantity) {
        String sku = product.getSku();
        
        if (inventory.containsKey(sku)) {
            // Product already exists in inventory - increment quantity
            Product existingProduct = inventory.get(sku);
            int oldQuantity = existingProduct.getQuantity();
            existingProduct.setQuantity(oldQuantity + quantity);
            System.out.println("[INFO] ✓ Added " + quantity + " units of " + product.getName() + 
                              " to warehouse " + name + 
                              " (Previous: " + oldQuantity + ", New: " + existingProduct.getQuantity() + ")");
        } else {
            // New product - create entry in inventory
            product.setQuantity(quantity);
            inventory.put(sku, product);
            System.out.println("[INFO] ✓ Added " + quantity + " units of " + product.getName() + 
                              " (SKU: " + sku + ", Price: $" + product.getPrice() + 
                              ") to warehouse " + name);
        }
    }

    /**
     * Removes a specified quantity of a product from the warehouse inventory.
     * 
     * This method handles:
     * - Validation that sufficient quantity exists
     * - Decrements product quantity
     * - Removes product from inventory if quantity reaches zero
     * - Logs appropriate messages for success and error cases
     * 
     * @param sku Stock Keeping Unit of the product to remove
     * @param quantity Number of units to remove
     * @precondition quantity > 0 and sufficient stock exists
     * @postcondition Product quantity is decremented or product is removed if qty = 0
     */
    public void removeProduct(String sku, int quantity) {
        if (inventory.containsKey(sku)) {
            Product product = inventory.get(sku);
            int currentQuantity = product.getQuantity();
            
            System.out.println("[DEBUG] Attempting to remove " + quantity + " units of " + 
                              product.getName() + " from warehouse " + name + 
                              " (Available: " + currentQuantity + ")");
            
            if (currentQuantity >= quantity) {
                // Sufficient stock available - proceed with removal
                product.setQuantity(currentQuantity - quantity);
                System.out.println("[INFO] ✓ Removed " + quantity + " units of " + product.getName() + 
                                  " from warehouse " + name + 
                                  " (Remaining: " + product.getQuantity() + " units)");

                // If product is completely sold out, remove from inventory
                if (product.getQuantity() == 0) {
                    inventory.remove(sku);
                    System.out.println("[ALERT] ⚠️  Product '" + product.getName() + 
                                      "' is now OUT OF STOCK and removed from inventory.");
                }
            } else {
                // Insufficient stock - operation cannot proceed
                System.out.println("[ERROR] ✗ INSUFFICIENT STOCK - Cannot remove " + quantity + 
                                  " units of " + product.getName() + 
                                  ". Current quantity: " + currentQuantity);
            }
        } else {
            System.out.println("[ERROR] ✗ Product with SKU '" + sku + 
                              "' not found in warehouse '" + name + "'");
        }
    }

    /**
     * Retrieves the available quantity of a product by SKU.
     * 
     * This is a read-only operation that queries the current stock level.
     * 
     * @param sku Stock Keeping Unit of the product
     * @postcondition Availability information is logged to console
     */
    public void getAvailableQuantity(String sku) {
        if (inventory.containsKey(sku)) {
            Product product = inventory.get(sku);
            System.out.println("[INFO] Available quantity of '" + product.getName() + 
                              "' in warehouse '" + name + "': " + product.getQuantity() + 
                              " units (Price: $" + product.getPrice() + ")");
        } else {
            System.out.println("[WARN] Product with SKU '" + sku + 
                              "' not found in warehouse '" + name + "'");
        }
    }

    /**
     * Retrieves complete product information by SKU.
     * 
     * This method provides a detailed view of a product including:
     * - Product name
     * - SKU (unique identifier)
     * - Price per unit
     * - Current quantity in warehouse
     * 
     * @param sku Stock Keeping Unit to search for
     * @return Product object if found, null otherwise
     */
    public Product getProductBySKU(String sku) {
        if (inventory.containsKey(sku)) {
            Product product = inventory.get(sku);
            System.out.println("[INFO] Product found: " + product.getName() + 
                              " (SKU: " + product.getSku() + 
                              ", Price: $" + product.getPrice() + 
                              ", Quantity: " + product.getQuantity() + 
                              ", Threshold: " + product.getThreshold() + ")");
            return product;
        } else {
            System.out.println("[WARN] Product with SKU '" + sku + 
                              "' not found in warehouse '" + name + "'");
            return null;
        }
    }

    /**
     * Retrieves all products currently stored in this warehouse.
     * 
     * @return Collection of all Product objects in the warehouse
     * @note Returns the values() view of the inventory map
     */
    public Collection<Product> getAllProducts() {
        System.out.println("[DEBUG] Retrieved all " + inventory.size() + 
                          " product types from warehouse: " + name);
        return inventory.values();
    }
}
