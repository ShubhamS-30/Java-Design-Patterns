package org.abstractFactoryDesignPattern;

import org.abstractFactoryDesignPattern.car.Car;
import org.abstractFactoryDesignPattern.factory.CarFactory;

public class Client {
    public static void main(String[] args) {

        String carModelToGet = "BMW";
        CarFactory carFactory = new CarFactory(carModelToGet);

        Car car = carFactory.getCar();

        if(car != null) {
            car.assemble();
        }
        else
            System.out.println("Car Model is not available!!!");
    }
}
