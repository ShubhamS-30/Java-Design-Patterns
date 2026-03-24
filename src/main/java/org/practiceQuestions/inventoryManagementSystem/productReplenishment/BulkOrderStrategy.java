package org.practiceQuestions.inventoryManagementSystem.productReplenishment;

import org.practiceQuestions.inventoryManagementSystem.product.Product;

/**
 * BulkOrderStrategy class - Implementation of the Strategy Pattern.
 * 
 * This strategy orders large quantities of products at once to take advantage of
 * bulk purchasing discounts and reduce ordering costs. It increases inventory holding
 * costs but reduces the frequency and cost of ordering.
 * 
 * Characteristics:
 * - Order Timing: Less frequent, when stock is significantly below threshold
 * - Order Quantity: Large (bulk orders for discounts)
 * - Holding Costs: HIGHER (more inventory stored)
 * - Ordering Costs: LOWER (fewer, larger orders)
 * - Lead Time Dependency: MEDIUM (can buffer with larger order)
 * - Storage Requirements: LARGER warehouse space needed
 * 
 * Advantages:
 * 1. Better unit pricing (bulk discounts)
 * 2. Lower ordering costs per unit
 * 3. Fewer supplier interactions
 * 4. Reduced administrative overhead
 * 5. Better protection against supply disruptions
 * 6. Consistent supply availability
 * 
 * Disadvantages:
 * 1. Higher inventory carrying costs
 * 2. More warehouse space required
 * 3. Higher risk of product obsolescence
 * 4. More capital tied up in inventory
 * 5. Risk of overstocking
 * 6. Spoilage risk for perishables
 * 
 * Best For:
 * - Low-value, high-volume products
 * - Clothing and textiles
 * - Non-perishable goods
 * - Products with stable demand
 * - Suppliers offering significant bulk discounts
 * - When warehouse space is available
 * 
 * Not Suitable For:
 * - High-value items (expensive products)
 * - Perishable goods
 * - Products with obsolescence risk
 * - Limited warehouse capacity
 * - Highly seasonal products
 * 
 * Example Scenarios:
 * - Levis Jeans: Order 500-1000 units at bulk rate
 * - Office supplies: Order quarterly in large quantities
 * - Components for manufacturing: Order for 1-2 months of production
 * 
 * Cost-Benefit Analysis:
 * - Bulk Discount: Typically 10-30% savings per unit
 * - Holding Cost: ~20-30% of product value annually
 * - Ordering Cost: Fixed cost per order
 * 
 * When to Use Bulk vs. JIT:
 * - Bulk: If (bulk discount %) > (annual holding cost %)
 * - JIT: If supplier is very reliable and holding costs are very high
 * 
 * @author Inventory System Team
 * @version 1.0
 */
public class BulkOrderStrategy implements ReplenishmentStrategy {
    
    /**
     * Executes the Bulk Order replenishment strategy.
     * 
     * This method:
     * 1. Determines the optimal bulk order quantity
     * 2. Takes advantage of bulk purchasing discounts
     * 3. Logs detailed replenishment information
     * 4. In production, would contact supplier for large order
     * 
     * Bulk Order Calculation:
     * - Base Quantity: Enough for 3-6 months of sales
     * - Safety Stock: Additional buffer for demand variability
     * - Discount Brackets: Orders in quantities that maximize discounts
     * 
     * In a real implementation, this would:
     * - Query supplier pricing tiers
     * - Find optimal quantity for maximum savings
     * - Negotiate delivery schedules
     * - Arrange warehouse preparation
     * - Schedule receiving and quality checks
     * 
     * @param product The product to be replenished using bulk order strategy
     * 
     * Bulk Logic:
     * - Current Stock: product.getQuantity()
     * - Reorder Threshold: product.getThreshold()
     * - Trigger: Quantity <= Threshold (but with more conservative approach)
     * - Order Size: Based on quarterly/seasonal demand (3-6 months of supply)
     */
    @Override
    public void replenishProduct(Product product) {
        System.out.println("\n[REPLENISHMENT] ═══ BULK ORDER STRATEGY ═══");
        System.out.println("[REPLENISHMENT] Strategy Type: Bulk Ordering");
        System.out.println("[REPLENISHMENT] ─────────────────────────────────");
        
        // Log product details
        System.out.println("[REPLENISHMENT] Product: " + product.getName());
        System.out.println("[REPLENISHMENT] SKU: " + product.getSku());
        System.out.println("[REPLENISHMENT] Current Stock: " + product.getQuantity() + " units");
        System.out.println("[REPLENISHMENT] Reorder Threshold: " + product.getThreshold() + " units");
        
        // Calculate bulk order quantity
        int bulkOrderQuantity = calculateBulkOrderQuantity(product);
        
        System.out.println("[REPLENISHMENT] ─────────────────────────────────");
        System.out.println("[REPLENISHMENT] Bulk Order Details:");
        System.out.println("[REPLENISHMENT]   - Order Quantity: " + bulkOrderQuantity + " units");
        System.out.println("[REPLENISHMENT]   - Expected Lead Time: 7-14 business days");
        System.out.println("[REPLENISHMENT]   - Bulk Discount: 15-25% savings");
        System.out.println("[REPLENISHMENT]   - Warehouse Space Required: LARGE");
        
        // In production, this would:
        // 1. Query supplier bulk pricing
        // 2. Calculate total cost with discounts
        // 3. Get approval for bulk purchase
        // 4. Create large PO
        // 5. Arrange logistics and warehousing
        System.out.println("[REPLENISHMENT]   - Action: Sending bulk purchase order to supplier");
        System.out.println("[REPLENISHMENT]   - Status: ORDER PLACED (bulk delivery in progress)");
        System.out.println("[REPLENISHMENT]   - Expected Inventory Increase: " + 
                          bulkOrderQuantity + " units in 7-14 days");
        
        System.out.println("[REPLENISHMENT] Benefits of Bulk Ordering:");
        System.out.println("[REPLENISHMENT]   ✓ Significant cost savings through bulk discounts");
        System.out.println("[REPLENISHMENT]   ✓ Reduced ordering frequency and administration");
        System.out.println("[REPLENISHMENT]   ✓ Better protection against supply disruptions");
        System.out.println("[REPLENISHMENT]   ✓ Consistent availability for longer periods");
        
        System.out.println("[REPLENISHMENT] Considerations:");
        System.out.println("[REPLENISHMENT]   ⚠ Requires significant warehouse space");
        System.out.println("[REPLENISHMENT]   ⚠ Higher inventory carrying costs");
        System.out.println("[REPLENISHMENT]   ⚠ More capital tied up initially");
        
        System.out.println("[REPLENISHMENT] ═════════════════════════════════\n");
    }
    
    /**
     * Calculates the optimal bulk order quantity.
     * 
     * Bulk ordering typically uses:
     * - Base Quantity: Enough for 3-6 months of normal sales
     * - Safety Stock: Significant buffer (100-200% of threshold)
     * - Supplier Minimums: Must meet supplier minimum order quantities
     * - Storage Constraints: Limited by warehouse capacity
     * 
     * Economic Order Quantity (EOQ) Formula:
     * EOQ = √(2 * D * S / H)
     * Where:
     *   D = Demand per period
     *   S = Fixed cost per order
     *   H = Holding cost per unit per period
     * 
     * @param product The product to calculate bulk order quantity for
     * @return The recommended bulk order quantity
     */
    private int calculateBulkOrderQuantity(Product product) {
        // Bulk order approach: Order for 3-6 months of stock
        // Assume quarterly demand cycle
        int quarterlyDemand = product.getThreshold() * 3; // Simplified model
        
        // Add safety stock (50% buffer on top of quarterly demand)
        int safetyStock = (int) (quarterlyDemand * 0.5);
        int bulkOrderQuantity = quarterlyDemand + safetyStock;
        
        // Round to nearest 50 units (typical supplier packaging)
        bulkOrderQuantity = ((bulkOrderQuantity + 25) / 50) * 50;
        
        return bulkOrderQuantity;
    }
}
