package org.decoratorDesignPattern.Pizza;

/**
 * BasePizza - Abstract Component in Decorator Design Pattern
 *
 * Purpose: Defines the interface for objects that can be decorated
 *
 * Decorator Design Pattern Key Concepts:
 * - Adds new functionality to objects dynamically
 * - Alternative to subclassing for extending functionality
 * - Maintains Open/Closed Principle (open for extension, closed for modification)
 *
 * In this example:
 * - BasePizza is the component that can be decorated
 * - Decorators (toppings) wrap the pizza and add to its cost
 * - You can wrap a decorator with another decorator (chain them)
 *
 * Real-world analogy:
 * Base pizza is like a simple cup of coffee
 * Toppings are like adding milk, sugar, whipped cream, etc.
 * You can add multiple toppings to build up the final product
 */
public abstract class BasePizza {
    /**
     * Abstract method to calculate the cost of pizza
     * Each concrete pizza type implements this differently
     * Each decorator adds to this cost
     */
    public abstract int cost();
}
