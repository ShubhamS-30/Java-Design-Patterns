package org.builderDesignPattern;

/**
 * BUILDER DESIGN PATTERN - CAR CLASS
 * 
 * Purpose: Construct complex objects step by step using a fluent and readable API.
 * 
 * Key Characteristics:
 * - Separates construction logic from the object representation
 * - Handles objects with many optional parameters without creating multiple constructors
 * - Provides a fluent API through method chaining for clean, readable code
 * - Each setter returns 'this' to enable chaining: builder.setMake(...).setModel(...).build()
 * 
 * Advantages:
 * - Avoids "telescoping constructor" anti-pattern (multiple overloaded constructors)
 * - Makes code more readable and maintainable
 * - Properties can be set in any order
 * - Easy to set only the properties you need
 * 
 * Real-world use cases: StringBuilder, Hibernate Query objects, Spring's RestTemplate
 */
public class Car {
    
    // Car properties with default values
    private String make = "Default Make";      // Car manufacturer
    private String model = "Default Model";    // Car model name
    private int year = 2000;                   // Manufacturing year
    private String color = "Default Color";    // Car color
    private int weight = 1000;                 // Car weight in kg
    
    /**
     * PRIVATE CONSTRUCTOR - Option 1
     * 
     * This constructor is kept but private.
     * It demonstrates that direct instantiation with all parameters is not allowed.
     * The only way to create a Car is through the CarBuilder.
     * 
     * @param make The car manufacturer
     * @param model The car model
     * @param year The manufacturing year
     * @param color The car color
     * @param weight The car weight
     */
    private Car(String make, String model, int year, String color, int weight) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.weight = weight;
    }

    /**
     * BUILDER CONSTRUCTOR
     * 
     * This constructor is the key link between CarBuilder and Car.
     * It's called by the build() method in CarBuilder to create the final Car object.
     * 
     * How it works:
     * 1. CarBuilder collects all the configuration
     * 2. build() method calls this constructor passing 'this' (the builder)
     * 3. This constructor extracts values from the builder and assigns them to Car
     * 4. A fully constructed Car object is returned
     * 
     * @param carBuilder The CarBuilder instance containing configuration
     */
    public Car(CarBuilder carBuilder){
        this.make = carBuilder.make;
        this.model = carBuilder.model;
        this.year = carBuilder.year;
        this.color = carBuilder.color;
        this.weight = carBuilder.weight;
    }

    /**
     * TO STRING METHOD
     * 
     * Provides a readable representation of the Car object.
     * Useful for debugging and logging.
     */
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

    /**
     * GETTER METHODS
     * 
     * These methods provide read-only access to the car's properties.
     * Since Car is immutable (no setters), once created, properties cannot be changed.
     */
    
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
     * STATIC INNER CLASS - CARBUILDER
     * 
     * Purpose: Build Car objects using a fluent, step-by-step approach.
     * 
     * Key Design Points:
     * - Static inner class: Can be instantiated without a Car instance
     * - Holds the same properties as Car: make, model, year, color, weight
     * - No default values: Properties can be null or 0 until explicitly set
     * - All setters return 'this': Enables method chaining
     * 
     * Usage Example:
     *    Car myCar = new Car.CarBuilder()
     *        .setMake("BMW")
     *        .setModel("X5")
     *        .setYear(2024)
     *        .setColor("Black")
     *        .setWeight(2000)
     *        .build();  // This line actually creates the Car object
     * 
     * Benefits of this approach:
     * - Readable, self-documenting code
     * - Optional parameters (set only what you need)
     * - Immutable final object (Car has no setters)
     * - Constructor complexity is hidden in the builder
     */
    public static class CarBuilder {
        
        // Builder properties - initialized as null/zero
        private String make;       // Car manufacturer
        private String model;      // Car model name
        private int year;          // Manufacturing year
        private String color;      // Car color
        private int weight;        // Car weight in kg

        /**
         * SET MAKE METHOD
         * 
         * Sets the car manufacturer.
         * Returns 'this' to allow method chaining.
         * 
         * Method Chaining: Allows calling multiple setters in sequence:
         * builder.setMake("BMW").setModel("X5").setYear(2024)...
         * 
         * @param make The manufacturer name
         * @return This CarBuilder instance for chaining
         */
        public CarBuilder setMake(String make) {
            this.make = make;
            return this;  // Return builder itself for chaining
        }

        /**
         * SET MODEL METHOD
         * 
         * Sets the car model name.
         * Returns 'this' to allow method chaining.
         * 
         * @param model The model name
         * @return This CarBuilder instance for chaining
         */
        public CarBuilder setModel(String model) {
            this.model = model;
            return this;  // Return builder itself for chaining
        }

        /**
         * SET YEAR METHOD
         * 
         * Sets the manufacturing year.
         * Returns 'this' to allow method chaining.
         * 
         * @param year The manufacturing year
         * @return This CarBuilder instance for chaining
         */
        public CarBuilder setYear(int year) {
            this.year = year;
            return this;  // Return builder itself for chaining
        }

        /**
         * SET COLOR METHOD
         * 
         * Sets the car color.
         * Returns 'this' to allow method chaining.
         * 
         * @param color The car color
         * @return This CarBuilder instance for chaining
         */
        public CarBuilder setColor(String color) {
            this.color = color;
            return this;  // Return builder itself for chaining
        }

        /**
         * SET WEIGHT METHOD
         * 
         * Sets the car weight in kilograms.
         * Returns 'this' to allow method chaining.
         * 
         * @param weight The car weight in kg
         * @return This CarBuilder instance for chaining
         */
        public CarBuilder setWeight(int weight) {
            this.weight = weight;
            return this;  // Return builder itself for chaining
        }

        /**
         * BUILD METHOD - THE FINAL STEP
         * 
         * This method completes the construction process and creates the final Car object.
         * 
         * How it works:
         * 1. Receives all the configuration from this builder's setters
         * 2. Creates a new Car object by passing 'this' to Car's constructor
         * 3. The Car constructor copies all values from the builder
         * 4. Returns the immutable Car object
         * 
         * After calling build():
         * - The Car object is fully constructed and immutable
         * - The builder can still be used to create more Car objects
         * - Or you can discard the builder and just use the Car object
         * 
         * @return A new, fully constructed Car object
         */
        public Car build() {
            return new Car(this);
        }
    }
}
