package org.abstractFactoryDesignPattern.factory;

import org.abstractFactoryDesignPattern.car.Audi;
import org.abstractFactoryDesignPattern.car.BMW;
import org.abstractFactoryDesignPattern.car.Car;

public class LuxuryFactory implements Factory {

    private String carName;

    public LuxuryFactory(String carName) {
        this.carName = carName;
    }

    @Override
    public Car getCar() {
        switch (this.carName) {
            case "BMW":
                return new BMW();
            case "Audi":
                return new Audi();
            default:
                return null;
        }
    }
}
