package org.abstractFactoryDesignPattern.car;

/**
 * Maruti - Concrete Product (Common/Budget Family)
 *
 * This is a common/budget car product created by the CommonFactory
 * It's part of the "Common Car Family" which includes Maruti and TATA
 */
public class Maruti implements Car {
    /**
     * Implements assembly logic specific to Maruti cars
     */
    @Override
    public void assemble() {
        System.out.println("Assembling a Maruti car...");
    }
}
