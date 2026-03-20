package org.decoratorDesignPattern.Pizza;

/**
 * VeggiePizza - Concrete Component in Decorator Pattern
 *
 * This is a base pizza type that can be decorated with toppings
 * It has its own cost of 300
 *
 * This is the item being decorated, not the decorator itself
 */
public class VeggiePizza extends BasePizza {
    /**
     * Base cost of veggie pizza
     * Decorators will add to this cost
     */
    @Override
    public int cost() {
        return 300;
    }
}
