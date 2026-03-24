package org.practiceQuestions.inventoryManagementSystem.inventoryManager;

import org.practiceQuestions.inventoryManagementSystem.inventoryObserver.InventoryObserver;
import org.practiceQuestions.inventoryManagementSystem.product.Product;
import org.practiceQuestions.inventoryManagementSystem.product.ProductFactory;
import org.practiceQuestions.inventoryManagementSystem.productReplenishment.ReplenishmentStrategy;
import org.practiceQuestions.inventoryManagementSystem.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * InventoryManager class implementing the Singleton Pattern.
 * 
 * This class serves as the central hub for managing the entire inventory system:
 * - Manages multiple warehouses across different locations
 * - Handles product factory for creating products
 * - Implements Observer Pattern for inventory notifications
 * - Manages replenishment strategies dynamically
 * - Provides centralized inventory checking and replenishment operations
 * 
 * The Singleton pattern ensures only ONE instance of InventoryManager exists throughout
 * the application lifecycle, preventing inconsistent inventory states.
 * 
 * Key Responsibilities:
 * 1. Warehouse Management: Add/remove warehouses, retrieve warehouse information
 * 2. Product Management: Use factory to create standardized products
 * 3. Observer Notification: Notify observers (Dashboard, Suppliers) of inventory changes
 * 4. Strategy Management: Configure and use different replenishment strategies
 * 5. Inventory Operations: Check stock levels, trigger replenishment, find products by SKU
 * 
 * @author Inventory System Team
 * @version 1.0
 */
public class InventoryManager {

    // Static reference to the single instance (Singleton)
    private static InventoryManager instance;

    // Collection of all warehouses managed by the system
    private List<Warehouse> warehouses;
    
    // Factory for creating products with proper initialization
    private ProductFactory productFactory;
    
    // Strategy for replenishing inventory (can be changed dynamically)
    private ReplenishmentStrategy replenishmentStrategy;
    
    // Observers that monitor inventory changes (Observer Pattern)
    private List<InventoryObserver> observers;

    /**
     * Private constructor to prevent instantiation from outside.
     * Initializes all collections and the product factory.
     */
    private InventoryManager() {
        this.warehouses = new ArrayList<>();
        this.productFactory = new ProductFactory();
        this.observers = new ArrayList<>();
        System.out.println("[DEBUG] InventoryManager instance created with empty warehouse list and observer list");
    }

    /**
     * Synchronized method to ensure thread-safe singleton instantiation.
     * 
     * The 'synchronized' keyword ensures that only one thread can execute this method
     * at a time, preventing race conditions when multiple threads try to create
     * the singleton instance simultaneously.
     * 
     * @return The single instance of InventoryManager
     */
    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
            System.out.println("[INFO] InventoryManager singleton created for the first time");
        } else {
            System.out.println("[DEBUG] InventoryManager singleton already exists, returning existing instance");
        }
        return instance;
    }

    /**
     * Adds a new warehouse to the inventory system.
     * 
     * @param warehouse The warehouse to be added
     * @postcondition The warehouse is added to the system and a confirmation message is logged
     */
    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
        System.out.println("[INFO] ✓ Warehouse '" + warehouse.getName() + 
                          "' (ID: " + warehouse.getWarehouseId() + 
                          ", Location: " + warehouse.getLocation() + 
                          ") added to inventory management system.");
    }

    /**
     * Removes a warehouse from the inventory system.
     * 
     * @param warehouse The warehouse to be removed
     * @postcondition The warehouse is removed and a confirmation message is logged
     */
    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
        System.out.println("[INFO] ✓ Warehouse '" + warehouse.getName() + 
                          "' removed from inventory management system.");
    }

    /**
     * Returns all warehouses managed by the system.
     * 
     * @return List of all warehouses
     */
    public List<Warehouse> getWarehouses() {
        System.out.println("[DEBUG] Retrieved list of " + warehouses.size() + " warehouses");
        return warehouses;
    }

    /**
     * Sets the replenishment strategy used by the system.
     * 
     * This allows dynamic switching between different replenishment strategies
     * (Just-In-Time, Bulk Order, etc.) without changing the core logic.
     * This is the Strategy Pattern in action.
     * 
     * @param replenishmentStrategy The strategy to be used for replenishment
     */
    public void setReplenishmentStrategy(ReplenishmentStrategy replenishmentStrategy) {
        this.replenishmentStrategy = replenishmentStrategy;
        System.out.println("[DEBUG] Replenishment strategy set to: " + 
                          replenishmentStrategy.getClass().getSimpleName());
    }

    /**
     * Returns the current replenishment strategy.
     * 
     * @return The current ReplenishmentStrategy
     */
    public ReplenishmentStrategy getReplenishmentStrategy() {
        return replenishmentStrategy;
    }

    /**
     * Returns the ProductFactory instance used by the system.
     * 
     * @return The ProductFactory
     */
    public ProductFactory getProductFactory() {
        System.out.println("[DEBUG] ProductFactory instance requested");
        return productFactory;
    }

    /**
     * Registers an observer to receive inventory change notifications.
     * This is part of the Observer Pattern implementation.
     * 
     * @param observer The observer to be registered
     * @postcondition Observer is added to the notification list
     */
    public void addObserver(InventoryObserver observer) {
        observers.add(observer);
        System.out.println("[INFO] ✓ Observer registered: " + observer.getClass().getSimpleName());
    }

    /**
     * Unregisters an observer from receiving inventory notifications.
     * 
     * @param observer The observer to be removed
     * @postcondition Observer is removed from the notification list
     */
    public void removeObserver(InventoryObserver observer) {
        observers.remove(observer);
        System.out.println("[INFO] ✓ Observer removed: " + observer.getClass().getSimpleName());
    }

    /**
     * Notifies all registered observers about a product's inventory change.
     * This implements the Observer Pattern - "push" notification approach.
     * 
     * @param product The product whose inventory has changed
     */
    public void notifyObservers(Product product) {
        System.out.println("[DEBUG] Notifying " + observers.size() + 
                          " observer(s) about product: " + product.getName());
        for (InventoryObserver observer : observers) {
            System.out.println("  → Notifying: " + observer.getClass().getSimpleName());
            observer.update(product);
        }
    }

    /**
     * Searches for a product across all warehouses by its SKU.
     * 
     * This method performs a linear search through all warehouses to find a product
     * with the matching SKU.
     * 
     * @param sku The Stock Keeping Unit of the product to find
     * @return The Product if found, null otherwise
     * @complexity O(n*m) where n = number of warehouses, m = average inventory size
     */
    public Product getProductBySku(String sku) {
        System.out.println("[DEBUG] Searching for product with SKU: " + sku);
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getInventory().containsKey(sku)) {
                Product product = warehouse.getInventory().get(sku);
                System.out.println("[DEBUG]  → Found in warehouse: " + warehouse.getName());
                return product;
            }
        }
        System.out.println("[WARN] Product with SKU '" + sku + "' not found in any warehouse");
        return null;
    }

    /**
     * Checks if a product's stock is below threshold and replenishes if needed.
     * 
     * This method finds a product by SKU and triggers replenishment if the current
     * quantity falls below the threshold. If no replenishment strategy is set,
     * this operation cannot proceed.
     * 
     * @param sku The Stock Keeping Unit of the product to check
     * @precondition A replenishment strategy must be set via setReplenishmentStrategy()
     */
    public void checkAndReplenishStock(String sku) {
        if (replenishmentStrategy == null) {
            System.out.println("[ERROR] No replenishment strategy set. Cannot check and replenish stock.");
            return;
        }

        Product product = getProductBySku(sku);
        if (product == null) {
            System.out.println("[ERROR] Product with SKU '" + sku + "' not found in inventory.");
            return;
        }

        System.out.println("[INFO] Checking stock for product: " + product.getName() + 
                          " (Current: " + product.getQuantity() + 
                          ", Threshold: " + product.getThreshold() + ")");
        
        if (product.getQuantity() < product.getThreshold()) {
            System.out.println("[ALERT] Stock for product '" + product.getName() + 
                              "' is below threshold (" + product.getQuantity() + 
                              " < " + product.getThreshold() + "). Initiating replenishment...");
            replenishmentStrategy.replenishProduct(product);
        } else {
            System.out.println("[INFO] ✓ Stock for product '" + product.getName() + 
                              "' is sufficient. No replenishment needed.");
        }
    }

    /**
     * Performs a comprehensive inventory check across all warehouses.
     * 
     * This method:
     * 1. Iterates through all warehouses
     * 2. For each warehouse, checks all products
     * 3. Notifies observers if any product is below threshold
     * 4. Initiates replenishment for low-stock items
     * 5. Logs status for products with sufficient stock
     * 
     * This is a critical operation that should be called periodically to ensure
     * adequate stock levels across all locations.
     * 
     * @precondition A replenishment strategy must be configured
     * @postcondition All low-stock products are flagged and replenishment is initiated
     */
    public void performInventoryCheck() {
        System.out.println("[INFO] Starting comprehensive inventory check across all warehouses...");
        int checkCount = 0;
        int lowStockCount = 0;
        
        for (Warehouse warehouse : warehouses) {
            System.out.println("\n[INFO] Scanning warehouse: '" + warehouse.getName() + "'");
            
            for (Product product : warehouse.getAllProducts()) {
                checkCount++;
                
                // Log current inventory status
                System.out.println("[DEBUG]   - Product: " + product.getName() + 
                                  " (SKU: " + product.getSku() + 
                                  ", Qty: " + product.getQuantity() + 
                                  ", Threshold: " + product.getThreshold() + ")");
                
                if (product.getQuantity() < product.getThreshold()) {
                    lowStockCount++;
                    System.out.println("[ALERT]   ⚠️  STOCK LOW - Notifying observers and triggering replenishment");
                    
                    // Notify all observers about the low stock situation
                    notifyObservers(product);
                    
                    // Trigger replenishment using the configured strategy
                    replenishmentStrategy.replenishProduct(product);
                } else {
                    System.out.println("[INFO]   ✓ Stock level is sufficient. No action needed.");
                }
            }
        }
        
        // Summary statistics
        System.out.println("\n[INFO] ═══ INVENTORY CHECK SUMMARY ═══");
        System.out.println("[INFO] Total products checked: " + checkCount);
        System.out.println("[INFO] Products with low stock: " + lowStockCount);
        System.out.println("[INFO] Inventory check completed successfully");
    }
}
