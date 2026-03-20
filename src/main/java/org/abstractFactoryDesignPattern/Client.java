package org.abstractFactoryDesignPattern;

import org.abstractFactoryDesignPattern.car.Car;
import org.abstractFactoryDesignPattern.factory.CarFactory;

/**
 * Client - Demonstrates Abstract Factory Design Pattern
 * Key Points:
 * 1. Client creates a CarFactory with a desired car model
 * 2. CarFactory automatically routes to the correct family factory
 *    (LuxuryFactory for BMW/Audi, CommonFactory for Maruti/TATA)
 * 3. Client works with Car interface, not aware of car families
 * 4. Easy to add new car families without changing client code
 * Differences from Simple Factory:
 * - Abstract Factory: Creates families of related objects
 * - Simple Factory: Creates individual objects
 */
public class Client {
    public static void main(String[] args) {

        // Step 1: User requests a specific car model
        String carModelToGet = "BMW";

        // Step 2: Create the main factory with the requested car model
        // The factory will internally determine which concrete factory to use
        CarFactory carFactory = new CarFactory(carModelToGet);

        // Step 3: Get the car from the factory
        // The factory handles all the routing logic internally
        Car car = carFactory.getCar();

        // Step 4: Use the car through the Car interface
        // Client doesn't know if it's luxury or common family
        if(car != null) {
            car.assemble();  // BMW gets assembled via LuxuryFactory
        }
        else
            System.out.println("Car Model is not available!!!");

        // Example: Change "BMW" to "Maruti" and the code automatically
        // creates a car from the CommonFactory family instead!
    }
}
