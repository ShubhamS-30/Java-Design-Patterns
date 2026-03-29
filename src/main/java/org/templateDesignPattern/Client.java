package org.templateDesignPattern;

/**
 * Client Class - Demonstrates the Template Method Design Pattern
 * This class showcases how the Template Method pattern works in a real-world scenario
 * of preparing different types of hot beverages (tea and coffee).
 * Key Concepts Demonstrated:
 * - Both tea and coffee follow the same preparation algorithm structure
 * - Common steps (boiling water, pouring into cup) are inherited and shared
 * - Specific steps (brewing and condiments) are customized per beverage type
 * - The algorithm structure is preserved across different implementations
 * Pattern Benefits in This Example:
 * 1. Code Reuse: Common preparation steps are defined once and reused
 * 2. Consistency: All beverages follow the same preparation sequence
 * 3. Flexibility: Each beverage type can customize its specific steps
 * 4. Maintainability: Changes to common steps affect all beverage types automatically
 * 5. Open/Closed Principle: Open for extension (new beverages), closed for modification
 */
public class Client {
    public static void main(String[] args) {
        // Create instances of different beverage types
        // Both are prepared using the same template algorithm
        Beverage tea = new TeaBeverage();
        Beverage coffee = new CoffeeBeverage();

        // Prepare tea using the inherited template method
        // The prepareRecipe() method calls:
        // 1. boilWater() - inherited common implementation
        // 2. brew() - tea-specific implementation
        // 3. pourInCup() - inherited common implementation
        // 4. addCondiments() - tea-specific implementation
        System.out.println("Making tea...");
        tea.prepareRecipe();

        System.out.println("\n");

        // Prepare coffee using the inherited template method
        // The prepareRecipe() method calls:
        // 1. boilWater() - inherited common implementation
        // 2. brew() - coffee-specific implementation
        // 3. pourInCup() - inherited common implementation
        // 4. addCondiments() - coffee-specific implementation
        System.out.println("Making coffee...");
        coffee.prepareRecipe();
        
        /*
         * Expected Output:
         * Making tea...
         * Boiling water
         * Steeping the tea
         * Pouring into cup
         * Adding Lemon
         * 
         * Making coffee...
         * Boiling water
         * Dripping Coffee through filter
         * Pouring into cup
         * Adding Sugar and Milk
         * 
         * Notice how both beverages follow the same algorithm structure
         * but with different implementations for brewing and condiments.
         */
    }
}
