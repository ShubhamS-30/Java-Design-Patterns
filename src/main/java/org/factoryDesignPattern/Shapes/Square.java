package org.factoryDesignPattern.Shapes;

/**
 * Concrete Square Shape - Concrete Product in Factory Pattern
 * Role: Implements the Shape interface for a Square
 * The factory will create this object when client requests "Square"
 */
public class Square implements Shape {
    /**
     * Concrete implementation of draw() for Square
     */
    @Override
    public void draw() {
        System.out.println("Drawing Square...");
    }
}
