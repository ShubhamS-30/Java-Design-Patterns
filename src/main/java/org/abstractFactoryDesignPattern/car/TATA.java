package org.abstractFactoryDesignPattern.car;

/**
 * TATA - Concrete Product (Common/Budget Family)
 *
 * This is a common/budget car product created by the CommonFactory
 * It's part of the "Common Car Family" which includes Maruti and TATA
 */
public class TATA implements Car {
    /**
     * Implements assembly logic specific to TATA cars
     */
    @Override
    public void assemble() {
        System.out.println("Assembling a TATA car...");
    }
}
