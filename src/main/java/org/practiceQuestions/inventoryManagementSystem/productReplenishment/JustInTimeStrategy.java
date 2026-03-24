package org.practiceQuestions.inventoryManagementSystem.productReplenishment;

import org.practiceQuestions.inventoryManagementSystem.product.Product;

/**
 * JustInTimeStrategy class - Implementation of the Strategy Pattern.
 * 
 * This strategy orders products only when they are actually needed (when stock falls
 * below the reorder threshold). It minimizes inventory holding costs but requires
 * reliable and fast suppliers.
 * 
 * Characteristics:
 * - Order Timing: When current stock <= threshold
 * - Order Quantity: Relatively small (just enough for near-term demand)
 * - Holding Costs: LOW (minimal inventory stored)
 * - Ordering Costs: HIGHER (frequent small orders)
 * - Lead Time Dependency: HIGH (requires reliable supplier)
 * - Supplier Coordination: TIGHT (just-in-time delivery required)
 * 
 * Advantages:
 * 1. Reduced warehouse storage costs
 * 2. Less capital tied up in inventory
 * 3. Fresher products with shorter shelf time
 * 4. Reduced obsolescence risk for tech products
 * 5. Better for perishable items
 * 
 * Disadvantages:
 * 1. Higher ordering frequency
 * 2. Risk of stock-outs if supplier fails
 * 3. Higher vulnerability to demand spikes
 * 4. Requires reliable supplier relationships
 * 5. May miss bulk purchase discounts
 * 
 * Best For:
 * - High-value products (laptops, expensive items)
 * - Products with short shelf life (groceries)
 * - Fast-moving inventory with predictable demand
 * - Premium brands with reliable suppliers
 * - Industries where cash flow is critical
 * 
 * Not Suitable For:
 * - Seasonal products with unpredictable demand
 * - Products from unreliable suppliers
 * - Low-value bulk items
 * - Products requiring bulk discounts
 * 
 * Example Scenarios:
 * - Samsung Laptops: Order 5-10 units when stock drops to 5
 * - Fresh produce: Order daily based on sales
 * - Electronics components: Order as needed for assembly
 * 
 * @author Inventory System Team
 * @version 1.0
 */
public class JustInTimeStrategy implements ReplenishmentStrategy {
    
    /**
     * Executes the Just-In-Time replenishment strategy.
     * 
     * This method:
     * 1. Detects when stock has fallen below threshold
     * 2. Initiates an immediate replenishment order
     * 3. Logs the replenishment action with details
     * 4. In production, would contact supplier for small order
     * 
     * In this implementation, we log the action. A real implementation would:
     * - Contact supplier via API
     * - Generate purchase order
     * - Track delivery status
     * - Update inventory upon receipt
     * 
     * @param product The product to be replenished using JIT strategy
     * 
     * JIT Logic:
     * - Current Stock: product.getQuantity()
     * - Reorder Threshold: product.getThreshold()
     * - Trigger: Quantity <= Threshold
     * - Order Size: Based on demand forecast (typically 1-2 weeks of supply)
     */
    @Override
    public void replenishProduct(Product product) {
        System.out.println("\n[REPLENISHMENT] ═══ JUST-IN-TIME STRATEGY ═══");
        System.out.println("[REPLENISHMENT] Strategy Type: Just-In-Time (JIT)");
        System.out.println("[REPLENISHMENT] ─────────────────────────────────");
        
        // Log product details
        System.out.println("[REPLENISHMENT] Product: " + product.getName());
        System.out.println("[REPLENISHMENT] SKU: " + product.getSku());
        System.out.println("[REPLENISHMENT] Current Stock: " + product.getQuantity() + " units");
        System.out.println("[REPLENISHMENT] Reorder Threshold: " + product.getThreshold() + " units");
        
        // Calculate order quantity using JIT approach
        // Typically order just enough for 1-2 weeks of normal demand
        int jitOrderQuantity = calculateJITOrderQuantity(product);
        
        System.out.println("[REPLENISHMENT] ─────────────────────────────────");
        System.out.println("[REPLENISHMENT] JIT Order Details:");
        System.out.println("[REPLENISHMENT]   - Order Quantity: " + jitOrderQuantity + " units");
        System.out.println("[REPLENISHMENT]   - Expected Delivery: 2-3 business days");
        System.out.println("[REPLENISHMENT]   - Supplier Contact: Initiated automatically");
        
        // In production, this would:
        // 1. Create PO (Purchase Order)
        // 2. Send to supplier via EDI/API
        // 3. Track delivery
        // 4. Update inventory upon receipt
        System.out.println("[REPLENISHMENT]   - Action: Sending replenishment request to supplier");
        System.out.println("[REPLENISHMENT]   - Status: ORDER PLACED (waiting for delivery)");
        
        System.out.println("[REPLENISHMENT] Benefits of JIT:");
        System.out.println("[REPLENISHMENT]   ✓ Reduces holding costs");
        System.out.println("[REPLENISHMENT]   ✓ Minimizes warehouse space usage");
        System.out.println("[REPLENISHMENT]   ✓ Reduces product obsolescence risk");
        System.out.println("[REPLENISHMENT]   ✓ Improves cash flow");
        
        System.out.println("[REPLENISHMENT] ═════════════════════════════════\n");
    }
    
    /**
     * Calculates the optimal order quantity for Just-In-Time replenishment.
     * 
     * JIT ordering typically uses:
     * - Base Quantity: Enough for 7-14 days of normal sales
     * - Safety Stock: Small buffer for demand spikes (25-50% of threshold)
     * - Rounding: To nearest supplier packaging size
     * 
     * @param product The product to calculate order quantity for
     * @return The recommended JIT order quantity
     */
    private int calculateJITOrderQuantity(Product product) {
        // JIT approach: Order roughly 1-2 weeks of stock
        // Assume daily demand = threshold / 7 (simplified model)
        int dailyDemand = Math.max(1, product.getThreshold() / 7);
        int jitOrderQuantity = dailyDemand * 10; // Order for ~10 days
        
        // Ensure minimum order quantity of threshold
        if (jitOrderQuantity < product.getThreshold()) {
            jitOrderQuantity = product.getThreshold();
        }
        
        return jitOrderQuantity;
    }
}
