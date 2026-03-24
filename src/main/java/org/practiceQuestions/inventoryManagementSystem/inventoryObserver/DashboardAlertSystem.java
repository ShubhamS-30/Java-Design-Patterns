package org.practiceQuestions.inventoryManagementSystem.inventoryObserver;

import org.practiceQuestions.inventoryManagementSystem.product.Product;

import java.util.List;

/**
 * DashboardAlertSystem class - Implementation of the Observer Pattern.
 * 
 * This class monitors inventory changes and sends alerts to system administrators
 * through a dashboard system. When products fall below their stock threshold,
 * this observer notifies all registered admin users about the inventory situation.
 * 
 * Features:
 * - Alert Level Classification: HIGH, MEDIUM, LOW severity levels
 * - Multi-Admin Support: Can notify multiple administrators
 * - Real-time Notifications: Immediately alerts admins when inventory is low
 * 
 * Alert Levels:
 * - HIGH: Critical inventory shortage requiring immediate action
 * - MEDIUM: Moderate inventory reduction, needs attention soon
 * - LOW: Inventory below threshold, routine replenishment needed
 * 
 * Use Cases:
 * 1. Notify inventory managers when stock is critically low
 * 2. Alert warehouse supervisors of replenishment needs
 * 3. Escalate issues to C-level management if inventory reaches critical levels
 * 4. Track and audit inventory alert history
 * 
 * @author Inventory System Team
 * @version 1.0
 */
public class DashboardAlertSystem implements InventoryObserver {
    
    // Alert severity level
    private String alertLevel;
    
    // List of admin users who should receive alerts
    private List<String> adminUsers;

    /**
     * Constructs a DashboardAlertSystem with specified alert level and admin users.
     * 
     * @param alertLevel The severity level of alerts (HIGH, MEDIUM, LOW)
     * @param adminUsers List of administrator names who will receive notifications
     */
    public DashboardAlertSystem(String alertLevel, List<String> adminUsers) {
        this.alertLevel = alertLevel;
        this.adminUsers = adminUsers;
        System.out.println("[INFO] DashboardAlertSystem initialized with alert level: " + alertLevel);
    }

    /**
     * Notifies all registered admin users about an inventory issue.
     * 
     * This method simulates sending alerts to administrators through a dashboard system.
     * In a real application, this could send:
     * - HTTP requests to a dashboard server
     * - Email notifications
     * - Push notifications
     * - SMS alerts
     * 
     * @param product The product with inventory issues
     * @param message The alert message describing the issue
     */
    private void notifyAdmins(Product product, String message) {
        System.out.println("[ALERT] ═══ DASHBOARD ALERT SYSTEM ═══");
        System.out.println("[ALERT] Alert Level: " + alertLevel);
        System.out.println("[ALERT] Message: " + message);
        
        for (String admin : adminUsers) {
            // Simulate sending alert to dashboard for each admin
            System.out.println("[ALERT]   → Notifying Dashboard User '" + admin + 
                              "': " + product.getName() + 
                              " (Current Stock: " + product.getQuantity() + 
                              ", Threshold: " + product.getThreshold() + ")");
        }
        System.out.println("[ALERT] ═════════════════════════════════");
    }

    /**
     * Responds to inventory change notifications from InventoryManager.
     * 
     * When a product's inventory falls below its threshold, this method is called
     * to alert system administrators through the dashboard.
     * 
     * @param product The product whose inventory has changed
     */
    @Override
    public void update(Product product) {
        // Check if product is running low on stock
        if (product.getQuantity() < product.getThreshold()) {
            // Generate alert message with product details
            String alertMessage = "Inventory Low for product: " + product.getName() + 
                                 " (SKU: " + product.getSku() + 
                                 ", Current: " + product.getQuantity() + 
                                 ", Threshold: " + product.getThreshold() + ")";
            
            System.out.println("[DEBUG] DashboardAlertSystem detected low stock for: " + product.getName());
            
            // Notify all registered administrators
            notifyAdmins(product, alertMessage);
        } else {
            System.out.println("[DEBUG] Product stock is sufficient: " + product.getName());
        }
    }
}
