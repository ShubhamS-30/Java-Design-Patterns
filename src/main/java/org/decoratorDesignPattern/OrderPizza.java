package org.decoratorDesignPattern;

import org.decoratorDesignPattern.Pizza.BasePizza;
import org.decoratorDesignPattern.Pizza.MargharitaPizza;
import org.decoratorDesignPattern.Pizza.VeggiePizza;
import org.decoratorDesignPattern.toppings.ExtraCheese;
import org.decoratorDesignPattern.toppings.ExtraMushroom;

public class OrderPizza {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new ExtraMushroom(new VeggiePizza()));
        System.out.println("Cost of extra cheese + mushrooms + veggie pizza = " + pizza.cost());

        BasePizza pizza1 = new ExtraCheese(new ExtraCheese(new ExtraCheese(new ExtraMushroom(new MargharitaPizza()))));
        System.out.println("Cost of extra cheese X 3 + mushrooms + margarita pizza = " + pizza1.cost());
    }
}
