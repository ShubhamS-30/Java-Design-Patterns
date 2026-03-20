package org.abstractFactoryDesignPattern.car;

/**
 * Car Interface - Abstract Product in Abstract Factory Pattern
 *
 * Purpose: Defines the contract for all car products
 * Each concrete car (BMW, Audi, Maruti, TATA) implements this interface
 *
 * Abstract Product: The interface that defines the behavior of products
 * that a factory can create
 */
public interface Car {
    /**
     * Assembles the car
     * Each concrete car will have its own assembly process
     */
    public void assemble();
}
