package org.abstractFactoryDesignPattern.car;

public class BMW implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling a BMW car...");
    }
}
