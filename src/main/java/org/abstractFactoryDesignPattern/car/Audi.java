package org.abstractFactoryDesignPattern.car;

public class Audi implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling an Audi car...");
    }
}
