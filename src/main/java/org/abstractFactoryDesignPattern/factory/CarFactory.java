package org.abstractFactoryDesignPattern.factory;

import org.abstractFactoryDesignPattern.car.Car;

public class CarFactory implements Factory {

    private String carName;

    public CarFactory(String carName) {
        this.carName = carName;
    }

    @Override
    public Car getCar() {
        switch (this.carName) {
            case "BMW", "Audi":
                return new LuxuryFactory(this.carName).getCar();
            case "Maruti", "TATA":
                return new CommonFactory(this.carName).getCar();
            default:
                return null;
        }
    }
}
