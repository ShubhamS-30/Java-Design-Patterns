package org.builderDesignPattern;

/**
 * Client class demonstrating the usage of the Builder Design Pattern.
 * The Builder pattern allows for flexible object construction by setting
 * properties step by step in any order, using method chaining.
 * This avoids the need for multiple constructors and makes the code more readable.
 */
public class Client {

    public static void main(String[] args) {
        // Create a new CarBuilder instance to start building a Car
        // The builder provides a fluent API for setting properties
        Car car = new Car.CarBuilder()
                .setMake("Toyota")    // Set the make of the car
                .setModel("Camry")    // Set the model
                .setYear(2020)        // Set the year
                .setColor("Red")      // Set the color
                .build();             // Finally, build the Car object

        // Print the constructed Car object
        System.out.println(car);
    }
}
