package org.factoryDesignPattern.Shapes;

/**
 * Concrete Triangle Shape - Concrete Product in Factory Pattern
 * Role: Implements the Shape interface for a Triangle
 * The factory will create this object when client requests "Triangle"
 */
public class Triangle implements Shape{
    /**
     * Concrete implementation of draw() for Triangle
     */
    @Override
    public void draw() {
        System.out.println("Drawing Triangle...");
    }
}
