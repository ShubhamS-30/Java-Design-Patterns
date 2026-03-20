package org.decoratorDesignPattern.toppings;

import org.decoratorDesignPattern.Pizza.BasePizza;

/**
 * ExtraCheese - Concrete Decorator in Decorator Design Pattern
 *
 * Role: Wraps a BasePizza object and adds the functionality of extra cheese
 *
 * How it works:
 * 1. Takes a BasePizza in constructor (could be a plain pizza or another decorator)
 * 2. Delegates the cost() call to the wrapped pizza
 * 3. Adds the cheese cost (50) to the wrapped pizza's cost
 *
 * Example:
 * - ExtraCheese(new VeggiePizza()) -> 300 + 50 = 350
 * - ExtraCheese(new ExtraCheese(new VeggiePizza())) -> 300 + 50 + 50 = 400
 */
public class ExtraCheese extends ToppingsDecorator {

    // The wrapped pizza object - can be any BasePizza including other decorators
    private BasePizza pizza;

    /**
     * Constructor wraps a pizza with extra cheese
     * @param pizza - The pizza to wrap (can be base pizza or another decorated pizza)
     */
    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }

    /**
     * Calculates total cost by adding cheese cost to wrapped pizza's cost
     * This is the key to chaining decorators!
     */
    @Override
    public int cost() {
        // Call cost() on wrapped pizza first, then add cheese cost
        return pizza.cost() + 50;
    }
}
