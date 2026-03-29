package org.templateDesignPattern;

/**
 * TeaBeverage Class - Concrete Template Method Implementation
 * This class is a concrete implementation of the Beverage template.
 * It inherits the overall beverage preparation algorithm from the Beverage class
 * and provides tea-specific implementations for brewing and adding condiments.
 * The class demonstrates how the Template Method pattern allows:
 * - Code reuse of common steps (boiling water, pouring into cup)
 * - Customization of beverage-specific steps (brewing and condiments)
 * - Consistency in the overall algorithm structure
 * Inheritance Structure:
 * TeaBeverage extends Beverage
 *   └─ Inherits: prepareRecipe(), boilWater(), pourInCup()
 *   └─ Implements: brew(), addCondiments()
 */
public class TeaBeverage extends Beverage {
    
    /**
     * Implementation of the brew() abstract method for tea.
     * This method provides tea-specific brewing logic.
     * When the inherited prepareRecipe() method is called,
     * it will use this specific implementation for the brewing step.
     * Tea brewing involves steeping the tea leaves in hot water.
     */
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    /**
     * Implementation of the addCondiments() abstract method for tea.
     * This method provides tea-specific condiment additions.
     * When the inherited prepareRecipe() method is called,
     * it will use this specific implementation for the condiments step.
     * For tea, we add lemon as the condiment.
     */
    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
