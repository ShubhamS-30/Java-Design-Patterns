package org.abstractFactoryDesignPattern.car;

/**
 * Audi - Concrete Product (Luxury Family)
 *
 * This is a luxury car product created by the LuxuryFactory
 * It's part of the "Luxury Car Family" which includes BMW and Audi
 */
public class Audi implements Car {
    /**
     * Implements assembly logic specific to Audi cars
     */
    @Override
    public void assemble() {
        System.out.println("Assembling an Audi car...");
    }
}
