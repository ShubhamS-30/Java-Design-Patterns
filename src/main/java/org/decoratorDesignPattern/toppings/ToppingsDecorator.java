package org.decoratorDesignPattern.toppings;

import org.decoratorDesignPattern.Pizza.BasePizza;

/**
 * ToppingsDecorator - Abstract Decorator in Decorator Design Pattern
 *
 * Role: Extends BasePizza so it can be used as a wrapper around BasePizza objects
 * This allows decorators to be treated as BasePizza objects
 *
 * Key Insight:
 * - Decorators inherit from the same base class as components
 * - This allows decorator to wrap both original components and other decorators
 * - Enables chaining: new ExtraCheese(new ExtraMushroom(new VeggiePizza()))
 *
 * Concrete decorators (ExtraCheese, ExtraMushroom) extend this class
 */
public abstract class ToppingsDecorator extends BasePizza {
    // This abstract class serves as the base for all topping decorators
}
