package org.templateDesignPattern;

/**
 * Beverage Abstract Class - Template Method Pattern
 * This abstract class defines the Template Method pattern for preparing beverages.
 * The template method outlines the common steps for preparing any hot beverage,
 * while allowing subclasses to override specific steps.
 * Key Concepts:
 * - Defines the skeleton of an algorithm in a method (prepareRecipe)
 * - Defers some steps to subclasses (brew and addCondiments)
 * - Uses abstract methods for steps that vary between beverages
 * - Uses concrete methods for steps that are common to all beverages
 * Benefits:
 * - Promotes code reuse by extracting common behavior
 * - Ensures consistent algorithm structure across implementations
 * - Allows flexibility in specific steps while maintaining overall structure
 * - Follows the Hollywood Principle: "Don't call us, we'll call you"
 */
public abstract class Beverage {
    
    /**
     * Template Method - The overall algorithm structure for preparing a beverage.
     * This method defines the exact steps and order in which a beverage is prepared.
     * It is marked as final to prevent subclasses from changing the algorithm structure.
     * The sequence is:
     * 1. Boil water (common to all beverages)
     * 2. Brew the beverage (varies by beverage type)
     * 3. Pour into cup (common to all beverages)
     * 4. Add condiments (varies by beverage type)
     * Subclasses must implement the brew() and addCondiments() methods
     * to customize these specific steps while maintaining the overall flow.
     */
    final void prepareRecipe() {
        boilWater();      // Step 1: Common behavior
        brew();           // Step 2: Specific behavior (implemented by subclasses)
        pourInCup();      // Step 3: Common behavior
        addCondiments();  // Step 4: Specific behavior (implemented by subclasses)
    }

    /**
     * Concrete Method - Boiling water is common to all beverages.
     * This method implements the same behavior for all beverage types.
     * It is not abstract because all beverages use the same boiling process.
     */
    void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * Concrete Method - Pouring into a cup is common to all beverages.
     * This method implements the same behavior for all beverage types.
     */
    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * Abstract Method - Brewing process varies by beverage type.
     * Subclasses must implement this method to define how their specific beverage is brewed.
     * Examples:
     * - Tea: Steeping the tea leaves
     * - Coffee: Dripping through filter
     */
    abstract void brew();
    
    /**
     * Abstract Method - Adding condiments varies by beverage type.
     * Subclasses must implement this method to define what condiments to add.
     * Examples:
     * - Tea: Adding lemon
     * - Coffee: Adding sugar and milk
     */
    abstract void addCondiments();
}
