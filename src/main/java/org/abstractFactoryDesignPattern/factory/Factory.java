package org.abstractFactoryDesignPattern.factory;

import org.abstractFactoryDesignPattern.car.Car;

/**
 * Factory Interface - Abstract Factory in Abstract Factory Design Pattern
 *
 * Purpose: Defines the interface for creating families of related objects
 *
 * Abstract Factory Pattern Key Concepts:
 * - Creates families of related/dependent objects without specifying concrete classes
 * - Provides an interface to create objects of different families
 * - Each concrete factory produces a specific family of products
 *
 * In this example:
 * - Families: Luxury cars (BMW, Audi) and Common cars (Maruti, TATA)
 * - Related objects: Different car brands belong to the same family
 */
public interface Factory {
    /**
     * Abstract method to get a car object
     * Each concrete factory will implement this to return a specific car
     *
     * @return Car object from the factory's product family
     */
    public Car getCar();
}
