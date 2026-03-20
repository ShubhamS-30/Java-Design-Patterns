package org.builderDesignPattern;

/**
 * The Builder Design Pattern is used to construct complex objects step by step.
 * It separates the construction of a complex object from its representation,
 * allowing the same construction process to create different representations.
 * This is particularly useful when an object has many optional parameters,
 * avoiding the need for multiple constructors or telescoping constructors.
 * In this example, the Car class uses a CarBuilder to construct Car objects.
 * The builder allows setting properties in any order and provides a fluent API
 * through method chaining.
 */
public class Car {
    private String make = "Default Make"; // Default value for make
    private String model = "Default Model"; // Default value for model
    private int year = 2000; // Default value for year
    private String color = "Default Color"; // Default value for color
    private int weight = 1000; // Default value for weight

    // Private constructor to prevent direct instantiation
    // Forces the use of the Builder to create Car objects
    private Car(String make, String model, int year, String color, int weight) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.weight = weight;
    }

    // Constructor that takes a CarBuilder and copies its values
    // This is called by the build() method in CarBuilder
    public Car(CarBuilder carBuilder){
        this.make = carBuilder.make;
        this.model = carBuilder.model;
        this.year = carBuilder.year;
        this.color = carBuilder.color;
        this.weight = carBuilder.weight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    // Getters for accessing the properties
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Static inner class that acts as the Builder for constructing Car objects.
     * It holds the same fields as Car and provides methods to set them.
     * Each setter returns 'this' to enable method chaining.
     */
    public static class CarBuilder {
        private String make;
        private String model;
        private int year;
        private String color;
        private int weight;

        // Setter for make, returns this for chaining
        public CarBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        // Setter for model, returns this for chaining
        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        // Setter for year, returns this for chaining
        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        // Setter for color, returns this for chaining
        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        // Setter for weight, returns this for chaining
        public CarBuilder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        // Builds and returns a new Car object using the values set in this builder
        public Car build() {
            return new Car(this);
        }
    }
}
