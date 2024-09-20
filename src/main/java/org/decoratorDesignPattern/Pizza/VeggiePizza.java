package org.decoratorDesignPattern.Pizza;

public class VeggiePizza extends BasePizza {
    @Override
    public int cost() {
        return 300;
    }
}
