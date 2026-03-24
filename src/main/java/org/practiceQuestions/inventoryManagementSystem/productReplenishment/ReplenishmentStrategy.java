package org.practiceQuestions.inventoryManagementSystem.productReplenishment;

import org.practiceQuestions.inventoryManagementSystem.product.Product;

/**
 * ReplenishmentStrategy interface - Part of the Strategy Pattern implementation.
 * 
 * The Strategy Pattern allows different inventory replenishment algorithms to be defined
 * and swapped dynamically at runtime. This provides flexibility in how inventory is managed
 * based on business requirements.
 * 
 * Different Strategies:
 * 1. JustInTimeStrategy: Orders only when stock falls below threshold (minimizes holding costs)
 * 2. BulkOrderStrategy: Orders large quantities at once (reduces ordering costs)
 * 3. SeasonalStrategy: Adjusts quantities based on seasonal demand
 * 4. PredictiveStrategy: Uses forecasting to determine replenishment quantities
 * 
 * Design Pattern: Strategy Pattern
 * - Encapsulates replenishment algorithms
 * - Makes algorithms interchangeable at runtime
 * - Eliminates conditional logic (if-else chains)
 * - Promotes Open/Closed Principle (open for extension, closed for modification)
 * 
 * How It Works:
 * 1. InventoryManager holds a reference to a ReplenishmentStrategy
 * 2. When stock is low, InventoryManager calls strategy.replenishProduct(product)
 * 3. The specific strategy implementation decides how to replenish
 * 4. Strategies can be switched without changing InventoryManager code
 * 
 * Example Usage:
 * ```
 * // Use Just-In-Time replenishment
 * inventoryManager.setReplenishmentStrategy(new JustInTimeStrategy());
 * 
 * // Later, switch to bulk ordering
 * inventoryManager.setReplenishmentStrategy(new BulkOrderStrategy());
 * ```
 * 
 * @author Inventory System Team
 * @version 1.0
 * @see JustInTimeStrategy
 * @see BulkOrderStrategy
 */
public interface ReplenishmentStrategy {
    
    /**
     * Executes the replenishment strategy for a given product.
     * 
     * This method contains the algorithm-specific logic for replenishing inventory.
     * Different implementations will replenish products differently based on their strategy.
     * 
     * @param product The product to be replenished
     * 
     * Responsibilities:
     * 1. Determine replenishment quantity based on strategy
     * 2. Calculate when to order
     * 3. Log replenishment details
     * 4. Potentially trigger supplier notifications
     * 5. Update inventory if replenishment is immediate
     */
    void replenishProduct(Product product);
}
