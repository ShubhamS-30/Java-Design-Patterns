package org.decoratorDesignPattern;

import org.decoratorDesignPattern.Pizza.BasePizza;
import org.decoratorDesignPattern.Pizza.MargharitaPizza;
import org.decoratorDesignPattern.Pizza.VeggiePizza;
import org.decoratorDesignPattern.toppings.ExtraCheese;
import org.decoratorDesignPattern.toppings.ExtraMushroom;

/**
 * OrderPizza - Client demonstrating Decorator Design Pattern
 *
 * Key Insight: Look at the nested constructor calls!
 * Instead of creating subclasses like "VeggiePizzaWithCheeseAndMushroom",
 * we DYNAMICALLY compose behavior by wrapping objects
 *
 * Decorator Pattern Benefits:
 * 1. Single Responsibility: Each class has one job
 *    - VeggiePizza: just the base pizza
 *    - ExtraCheese: just adds cheese
 *    - ExtraMushroom: just adds mushroom
 *
 * 2. Open/Closed Principle: Open for extension, closed for modification
 *    - Add new toppings without modifying existing classes
 *
 * 3. Flexible Composition: Create any combination at runtime
 *
 * 4. Avoids Class Explosion: No need for classes like:
 *    - VeggiePizzaWithCheese
 *    - VeggiePizzaWithMushroom
 *    - VeggiePizzaWithCheeseAndMushroom
 *    - etc.
 */
public class OrderPizza {
    public static void main(String[] args) {
        // Example 1: Veggie Pizza + Extra Mushroom + Extra Cheese
        // Read from inside out:
        // - Start with VeggiePizza (base: 300)
        // - Wrap it with ExtraMushroom (adds 30)
        // - Wrap that with ExtraCheese (adds 50)
        // Total: 300 + 30 + 50 = 380
        BasePizza pizza = new ExtraCheese(new ExtraMushroom(new VeggiePizza()));
        System.out.println("Cost of extra cheese + mushrooms + veggie pizza = " + pizza.cost());

        // Example 2: Margarita Pizza + Extra Mushroom + Extra Cheese X 3
        // Read from inside out:
        // - Start with MargharitaPizza (base: 250)
        // - Wrap it with ExtraMushroom (adds 30)
        // - Wrap that with ExtraCheese (adds 50) - first cheese
        // - Wrap that with ExtraCheese (adds 50) - second cheese
        // - Wrap that with ExtraCheese (adds 50) - third cheese
        // Total: 250 + 30 + 50 + 50 + 50 = 430
        BasePizza pizza1 = new ExtraCheese(new ExtraCheese(new ExtraCheese(new ExtraMushroom(new MargharitaPizza()))));
        System.out.println("Cost of extra cheese X 3 + mushrooms + margarita pizza = " + pizza1.cost());

        // Notice: We never created specialized classes for combinations
        // We simply composed them at runtime!
    }
}
