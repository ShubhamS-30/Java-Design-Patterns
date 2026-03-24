package org.practiceQuestions.inventoryManagementSystem.inventoryObserver;

import org.practiceQuestions.inventoryManagementSystem.product.Product;

/**
 * SupplierNotifier class - Implementation of the Observer Pattern.
 * 
 * This class monitors inventory changes and automatically notifies suppliers
 * when their products fall below the minimum stock threshold. This enables
 * just-in-time replenishment and automated supply chain management.
 * 
 * Features:
 * - Automatic supplier notifications when stock is low
 * - Email-based communication with suppliers
 * - Product-specific supplier relationships
 * - Real-time inventory monitoring
 * 
 * Benefits:
 * 1. Reduces manual inventory management work
 * 2. Enables automated replenishment workflows
 * 3. Improves supply chain visibility and coordination
 * 4. Reduces stock-out risks and lost sales
 * 5. Optimizes inventory holding costs
 * 
 * Example Scenario:
 * When Samsung Laptop stock falls below 5 units:
 * 1. InventoryManager detects low stock
 * 2. Calls notifyObservers(samsungLaptop)
 * 3. SupplierNotifier.update() is triggered
 * 4. Email sent to supplier: "Electronics Supplier Inc. at supplier@example.com"
 * 5. Supplier receives order to replenish stock
 * 
 * @author Inventory System Team
 * @version 1.0
 */
public class SupplierNotifier implements InventoryObserver {

    // Supplier organization name
    private String supplierName;
    
    // Supplier email address for notifications
    private String supplierEmail;

    /**
     * Constructs a SupplierNotifier for a specific supplier.
     * 
     * @param supplierName The name of the supplier organization
     * @param supplierEmail The email address for supplier notifications
     */
    public SupplierNotifier(String supplierName, String supplierEmail) {
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        System.out.println("[INFO] SupplierNotifier initialized for supplier: " + 
                          supplierName + " (" + supplierEmail + ")");
    }

    /**
     * Responds to inventory change notifications from InventoryManager.
     * 
     * When a product's inventory falls below its threshold, this method sends
     * a notification to the configured supplier to initiate replenishment.
     * 
     * In a real application, this could:
     * - Send automated emails to supplier
     * - Make API calls to supplier's ordering system
     * - Generate purchase orders in ERP systems
     * - Send EDI (Electronic Data Interchange) messages
     * 
     * @param product The product whose inventory has changed
     */
    @Override
    public void update(Product product) {
        // Check if product stock has fallen below the reorder threshold
        if (product.isLowStock()) {
            System.out.println("[INFO] ═══ SUPPLIER NOTIFICATION ═══");
            System.out.println("[INFO] Supplier: " + supplierName);
            System.out.println("[INFO] Email: " + supplierEmail);
            System.out.println("[INFO] ─────────────────────────────────");
            
            // Log notification details
            System.out.println("[INFO] Notification Type: Replenishment Request");
            System.out.println("[INFO] Product Name: " + product.getName());
            System.out.println("[INFO] Product SKU: " + product.getSku());
            System.out.println("[INFO] Current Stock: " + product.getQuantity() + " units");
            System.out.println("[INFO] Reorder Threshold: " + product.getThreshold() + " units");
            System.out.println("[INFO] Stock Status: LOW - REPLENISHMENT NEEDED");
            
            // Simulate sending email to supplier
            System.out.println("[INFO] → Email being sent to supplier at: " + supplierEmail);
            System.out.println("[INFO]   Subject: Urgent: Stock Replenishment Required for " + 
                              product.getName());
            System.out.println("[INFO]   Body: Please replenish stock for " + product.getName() + 
                              " (SKU: " + product.getSku() + 
                              "). Current level: " + product.getQuantity() + 
                              " units, Threshold: " + product.getThreshold() + " units");
            
            System.out.println("[INFO] ════════════════════════════════");
        } else {
            System.out.println("[DEBUG] SupplierNotifier: Product stock is sufficient: " + 
                              product.getName() + 
                              " (Current: " + product.getQuantity() + 
                              ", Threshold: " + product.getThreshold() + ")");
        }
    }
}
