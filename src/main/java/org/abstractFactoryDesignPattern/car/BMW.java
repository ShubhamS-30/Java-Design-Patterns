package org.abstractFactoryDesignPattern.car;

/**
 * BMW - Concrete Product (Luxury Family)
 *
 * This is a luxury car product created by the LuxuryFactory
 * It's part of the "Luxury Car Family" which includes BMW and Audi
 */
public class BMW implements Car {
    /**
     * Implements assembly logic specific to BMW cars
     */
    @Override
    public void assemble() {
        System.out.println("Assembling a BMW car...");
    }
}
