package org.practiceQuestions.inventoryManagementSystem.inventoryObserver;

import org.practiceQuestions.inventoryManagementSystem.product.Product;

/**
 * InventoryObserver interface - Part of the Observer Pattern implementation.
 * 
 * The Observer Pattern allows multiple observers to be notified automatically when
 * inventory state changes occur (e.g., products fall below threshold).
 * 
 * This interface defines the contract that all inventory observers must implement:
 * - DashboardAlertSystem: Notifies administrators via dashboard alerts
 * - SupplierNotifier: Notifies suppliers of stock replenishment needs
 * - Other implementations: Email notifications, SMS alerts, API calls, etc.
 * 
 * Design Pattern: Observer Pattern
 * - Provides loose coupling between the InventoryManager (Subject) and observers
 * - New observers can be added without modifying existing code
 * - Automatic notifications when inventory changes occur
 * 
 * How it Works:
 * 1. Observer registers itself with InventoryManager via addObserver()
 * 2. When product stock changes, InventoryManager calls notifyObservers(product)
 * 3. Each observer's update(product) method is called with the product information
 * 4. Observers can perform custom actions (send alerts, update dashboards, etc.)
 * 
 * @author Inventory System Team
 * @version 1.0
 * @see org.practiceQuestions.inventoryManagementSystem.inventoryManager.InventoryManager
 */
public interface InventoryObserver {
    
    /**
     * Called when inventory state changes (e.g., product stock becomes low).
     * 
     * This method is invoked by InventoryManager whenever a product's inventory status changes.
     * The implementing class should handle the notification appropriately (send alert, log event, etc.)
     * 
     * @param product The product whose inventory has changed
     */
    void update(Product product);
}
