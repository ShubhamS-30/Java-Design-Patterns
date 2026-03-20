package org.decoratorDesignPattern.Pizza;

/**
 * MargharitaPizza - Concrete Component in Decorator Pattern
 *
 * This is a base pizza type that can be decorated with toppings
 * It has its own cost of 250
 *
 * This is the item being decorated, not the decorator itself
 */
public class MargharitaPizza extends BasePizza {
    /**
     * Base cost of margarita pizza
     * Decorators will add to this cost
     */
    @Override
    public int cost() {
        return 250;
    }
}
