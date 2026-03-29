package org.templateDesignPattern;

/**
 * CoffeeBeverage Class - Concrete Template Method Implementation
 * This class is a concrete implementation of the Beverage template.
 * It inherits the overall beverage preparation algorithm from the Beverage class
 * and provides coffee-specific implementations for brewing and adding condiments.
 * The class demonstrates how the Template Method pattern allows:
 * - Code reuse of common steps (boiling water, pouring into cup)
 * - Customization of beverage-specific steps (brewing and condiments)
 * - Consistency in the overall algorithm structure
 * Inheritance Structure:
 * CoffeeBeverage extends Beverage
 *   └─ Inherits: prepareRecipe(), boilWater(), pourInCup()
 *   └─ Implements: brew(), addCondiments()
 */
public class CoffeeBeverage extends Beverage {
    
    /**
     * Implementation of the brew() abstract method for coffee.
     * 
     * This method provides coffee-specific brewing logic.
     * When the inherited prepareRecipe() method is called,
     * it will use this specific implementation for the brewing step.
     * 
     * Coffee brewing involves dripping hot water through ground coffee beans
     * using a filter to extract the coffee essence.
     */
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    /**
     * Implementation of the addCondiments() abstract method for coffee.
     * 
     * This method provides coffee-specific condiment additions.
     * When the inherited prepareRecipe() method is called,
     * it will use this specific implementation for the condiments step.
     * 
     * For coffee, we add both sugar and milk as condiments.
     */
    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
