package org.factoryDesignPattern.Shapes;

/**
 * Concrete Circle Shape - Concrete Product in Factory Pattern
 * Role: Implements the Shape interface for a Circle
 * The factory will create this object when client requests "Circle"
 */
public class Circle implements Shape {
    /**
     * Concrete implementation of draw() for Circle
     */
    @Override
    public void draw() {
        System.out.println("Drawing Circle...");
    }
}
