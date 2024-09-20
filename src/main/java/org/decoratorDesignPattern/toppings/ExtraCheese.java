package org.decoratorDesignPattern.toppings;

import org.decoratorDesignPattern.Pizza.BasePizza;

public class ExtraCheese extends ToppingsDecorator {

    private BasePizza pizza;

    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() + 50;
    }
}
