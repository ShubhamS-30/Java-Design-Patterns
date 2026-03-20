package org.decoratorDesignPattern.toppings;

import org.decoratorDesignPattern.Pizza.BasePizza;

/**
 * ExtraMushroom - Concrete Decorator in Decorator Design Pattern
 *
 * Role: Wraps a BasePizza object and adds the functionality of extra mushroom
 *
 * How it works:
 * 1. Takes a BasePizza in constructor (could be a plain pizza or another decorator)
 * 2. Delegates the cost() call to the wrapped pizza
 * 3. Adds the mushroom cost (30) to the wrapped pizza's cost
 *
 * Example:
 * - ExtraMushroom(new VeggiePizza()) -> 300 + 30 = 330
 * - ExtraMushroom(new ExtraCheese(new VeggiePizza())) -> 300 + 50 + 30 = 380
 */
public class ExtraMushroom extends ToppingsDecorator {

    // The wrapped pizza object - can be any BasePizza including other decorators
    private BasePizza pizza;

    /**
     * Constructor wraps a pizza with extra mushroom
     * @param pizza - The pizza to wrap (can be base pizza or another decorated pizza)
     */
    public ExtraMushroom(BasePizza pizza) {
        this.pizza = pizza;
    }

    /**
     * Calculates total cost by adding mushroom cost to wrapped pizza's cost
     * This is the key to chaining decorators!
     */
    @Override
    public int cost() {
        // Call cost() on wrapped pizza first, then add mushroom cost
        return pizza.cost() + 30;
    }
}
