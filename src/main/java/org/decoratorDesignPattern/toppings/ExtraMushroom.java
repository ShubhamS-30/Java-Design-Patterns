package org.decoratorDesignPattern.toppings;

import org.decoratorDesignPattern.Pizza.BasePizza;

public class ExtraMushroom extends ToppingsDecorator {

    private BasePizza pizza;

    public ExtraMushroom(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() + 30;
    }
}
