package org.abstractFactoryDesignPattern.car;

public class Maruti implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling a Maruti car...");
    }
}
