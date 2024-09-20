package org.abstractFactoryDesignPattern.factory;

import org.abstractFactoryDesignPattern.car.Car;
import org.abstractFactoryDesignPattern.car.Maruti;
import org.abstractFactoryDesignPattern.car.TATA;

public class CommonFactory implements Factory {

    private String carName;

    public CommonFactory(String carName) {
        this.carName = carName;
    }

    @Override
    public Car getCar() {
        switch (this.carName) {
            case "Maruti":
                return new Maruti();
            case "TATA":
                return new TATA();
            default:
                return null;
        }
    }
}
