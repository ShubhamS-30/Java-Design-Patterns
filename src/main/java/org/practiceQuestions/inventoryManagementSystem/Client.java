package org.practiceQuestions.inventoryManagementSystem;

import org.practiceQuestions.inventoryManagementSystem.inventoryManager.InventoryManager;
import org.practiceQuestions.inventoryManagementSystem.inventoryObserver.DashboardAlertSystem;
import org.practiceQuestions.inventoryManagementSystem.inventoryObserver.SupplierNotifier;
import org.practiceQuestions.inventoryManagementSystem.product.Product;
import org.practiceQuestions.inventoryManagementSystem.product.ProductCategory;
import org.practiceQuestions.inventoryManagementSystem.product.ProductFactory;
import org.practiceQuestions.inventoryManagementSystem.productReplenishment.JustInTimeStrategy;
import org.practiceQuestions.inventoryManagementSystem.productReplenishment.ReplenishmentStrategy;
import org.practiceQuestions.inventoryManagementSystem.warehouse.Warehouse;

import java.util.List;

/**
 * Client class for the Inventory Management System.
 * 
 * This class demonstrates a complete workflow of the inventory management system using
 * multiple design patterns:
 * - Singleton Pattern: InventoryManager ensures single instance
 * - Factory Pattern: ProductFactory creates products by category
 * - Observer Pattern: DashboardAlertSystem & SupplierNotifier monitor inventory changes
 * - Strategy Pattern: Different replenishment strategies (JustInTime, BulkOrder)
 * 
 * The system performs these key operations:
 * 1. Initialize warehouses across multiple locations
 * 2. Register observer systems for inventory monitoring
 * 3. Create products with different categories and attributes
 * 4. Stock warehouses with inventory
 * 5. Configure replenishment strategies
 * 6. Monitor inventory and trigger replenishment when stock is low
 * 7. Simulate sales transactions
 * 8. Re-check inventory and trigger replenishment as needed
 * 
 * @author Inventory System Team
 * @version 1.0
 */
public class Client {

    public static void main(String[] args) {
        // Display system header
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║    INVENTORY MANAGEMENT SYSTEM - COMPLETE WORKFLOW DEMO      ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        // ==================== STEP 1: System Initialization ====================
        System.out.println("📦 [STEP 1] Initializing Inventory Manager and Warehouses...");
        System.out.println("─".repeat(60));
        
        // Get singleton instance of InventoryManager
        // This ensures only one inventory system exists throughout the application
        InventoryManager inventoryManager = InventoryManager.getInstance();
        System.out.println("  ✓ InventoryManager singleton initialized");
        
        // Create warehouse instances for different geographic locations
        Warehouse warehouse1 = new Warehouse(1, "Central Warehouse", "New York");
        Warehouse warehouse2 = new Warehouse(2, "West Coast Warehouse", "Los Angeles");
        System.out.println("  ✓ Warehouse instances created");

        // Register warehouses with the inventory manager
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);
        System.out.println("  ✓ Warehouses registered with InventoryManager\n");

        // ==================== STEP 2: Register Observers ====================
        System.out.println("👁️  [STEP 2] Registering Observer Systems...");
        System.out.println("─".repeat(60));
        
        // Add Dashboard Alert System observer
        // This observer will notify dashboard admins of low stock alerts
        DashboardAlertSystem dashboardAlerts = new DashboardAlertSystem("HIGH", 
                                                    List.of("Owner", "Inventory Manager"));
        inventoryManager.addObserver(dashboardAlerts);
        System.out.println("  ✓ DashboardAlertSystem registered (HIGH alert level)");
        
        // Add Supplier Notifier observer
        // This observer will notify suppliers when products need replenishment
        SupplierNotifier supplierNotifier = new SupplierNotifier("Best Supplier Inc.", 
                                                "bestSupplier@gmail.com");
        inventoryManager.addObserver(supplierNotifier);
        System.out.println("  ✓ SupplierNotifier registered for automatic supplier notifications\n");

        // ==================== STEP 3: Create Products ====================
        System.out.println("🏭 [STEP 3] Creating Products using ProductFactory...");
        System.out.println("─".repeat(60));
        
        ProductFactory productFactory = inventoryManager.getProductFactory();
        
        // Create Electronics Product: Samsung Laptop
        // SKU is a unique identifier, threshold triggers replenishment at quantity <= 5
        Product laptop = productFactory.createProduct(
            "ELEC-001",                      // Stock Keeping Unit
            "Samsung Laptop",                // Product name
            999.99,                          // Price per unit (USD)
            5,                               // Reorder point: replenish when qty <= 5
            ProductCategory.ELECTRONICS,     // Product category
            24,                              // Warranty period: 24 months
            "Samsung",                       // Brand name
            null, null, null, false          // N/A for electronics: size, material, expiration, refrigeration
        );
        System.out.println("  ✓ Electronics Product Created: Samsung Laptop (SKU: ELEC-001, Price: $999.99)");
        
        // Create Clothing Product: Levis Jeans
        // Size and material are specific to clothing products
        Product jeans = productFactory.createProduct(
            "CLTH-001",                      // Stock Keeping Unit
            "Levis Jeans",                   // Product name
            49.99,                           // Price per unit (USD)
            10,                              // Reorder point: replenish when qty <= 10
            ProductCategory.CLOTHING,        // Product category
            null, null,                      // N/A for clothing: warranty, brand
            "L",                             // Size: Large
            "Wool",                          // Material composition
            null, false                      // N/A for clothing: expiration, refrigeration
        );
        System.out.println("  ✓ Clothing Product Created: Levis Jeans (SKU: CLTH-001, Price: $49.99)");
        
        // Create Grocery Product: Chocolate Bar
        // Expiration date and refrigeration requirements are specific to grocery items
        Product chocolate = productFactory.createProduct(
            "GROC-001",                      // Stock Keeping Unit
            "Chocolate Bar",                 // Product name
            5.99,                            // Price per unit (USD)
            20,                              // Reorder point: replenish when qty <= 20
            ProductCategory.GROCERY,         // Product category
            null, null, null, null,          // N/A for grocery: warranty, brand, size, material
            "2026-05-31",                    // Expiration date (YYYY-MM-DD format)
            true                             // Requires refrigeration: Yes
        );
        System.out.println("  ✓ Grocery Product Created: Chocolate Bar (SKU: GROC-001, Price: $5.99)\n");

        // ==================== STEP 4: Stock Warehouses ====================
        System.out.println("📥 [STEP 4] Stocking Products into Warehouses...");
        System.out.println("─".repeat(60));
        
        // Add products to Central Warehouse (New York)
        warehouse1.addProduct(laptop, 10);  // 10 Samsung Laptops
        warehouse1.addProduct(jeans, 20);   // 20 Levis Jeans
        System.out.println("  ✓ Central Warehouse stocked with laptops and jeans");
        
        // Add products to West Coast Warehouse (Los Angeles)
        warehouse2.addProduct(chocolate, 15); // 15 Chocolate Bars
        System.out.println("  ✓ West Coast Warehouse stocked with chocolate bars\n");

        // ==================== STEP 5: Configure Replenishment ====================
        System.out.println("⚙️  [STEP 5] Configuring Replenishment Strategy...");
        System.out.println("─".repeat(60));
        
        // Set Just-In-Time replenishment strategy
        // This strategy orders products only when needed to minimize storage costs
        ReplenishmentStrategy replenishmentStrategy = new JustInTimeStrategy();
        inventoryManager.setReplenishmentStrategy(replenishmentStrategy);
        System.out.println("  ✓ Replenishment Strategy: Just-In-Time (minimize holding costs)\n");

        // ==================== STEP 6: Initial Inventory Check ====================
        System.out.println("📊 [STEP 6] Performing Initial Inventory Check...");
        System.out.println("─".repeat(60));
        
        // Check all warehouses and initiate replenishment for low stock items
        // This will trigger observer notifications if any products fall below threshold
        inventoryManager.performInventoryCheck();
        System.out.println("─".repeat(60));
        System.out.println("  ✓ Initial inventory check completed\n");

        // ==================== STEP 7: Simulate Sales Transactions ====================
        System.out.println("💰 [STEP 7] Simulating Customer Purchases (Sales)...");
        System.out.println("─".repeat(60));
        
        // Customer 1: Purchases 5 Samsung Laptops
        warehouse1.removeProduct(laptop.getSku(), 5);
        System.out.println("  → Customer 1 purchased 5 Samsung Laptops");
        
        // Customer 2: Purchases 15 Levis Jeans
        warehouse1.removeProduct(jeans.getSku(), 15);
        System.out.println("  → Customer 2 purchased 15 Levis Jeans\n");

        // ==================== STEP 8: Re-check Inventory After Sales ====================
        System.out.println("📊 [STEP 8] Re-checking Inventory After Sales...");
        System.out.println("─".repeat(60));
        
        // Perform comprehensive inventory check after sales
        // This will trigger replenishment for products that fall below threshold
        inventoryManager.performInventoryCheck();
        System.out.println("─".repeat(60));
        System.out.println("  ✓ Post-sales inventory check completed\n");

        // ==================== STEP 9: Explicit Replenishment Check ====================
        System.out.println("🔄 [STEP 9] Checking and Replenishing Specific Products...");
        System.out.println("─".repeat(60));
        
        // Manually check and replenish electronics and clothing
        inventoryManager.checkAndReplenishStock("ELEC-001");
        inventoryManager.checkAndReplenishStock("CLTH-001");
        System.out.println("─".repeat(60));
        System.out.println("  ✓ Specific product replenishment checks completed\n");
        
        // Display completion message
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║      WORKFLOW DEMONSTRATION COMPLETED SUCCESSFULLY          ║");
        System.out.println("║  All inventory operations executed and logged above         ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}
