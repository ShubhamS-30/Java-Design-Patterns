package org.builderDesignPattern;

/**
 * CLIENT CLASS - BUILDER DESIGN PATTERN DEMONSTRATION
 * 
 * Purpose: Demonstrate how the Builder pattern creates complex objects
 * in a clean, readable, and flexible manner.
 * 
 * Key Benefits Demonstrated:
 * 1. FLUENT API: Method chaining makes code read like natural language
 * 2. FLEXIBILITY: Set only the properties you need (no mandatory parameters)
 * 3. READABILITY: Each line clearly shows what property is being set
 * 4. IMMUTABILITY: Once built, the Car object cannot be changed
 * 
 * This is much better than:
 *    // BAD: Unclear what each parameter means (telescoping constructor)
 *    Car car = new Car("Toyota", "Camry", 2020, "Red", 1500);
 * 
 * Or even worse:
 *    // BAD: Need multiple constructors for different combinations
 *    Car car1 = new Car("Toyota", "Camry");
 *    Car car2 = new Car("Toyota", "Camry", 2020);
 *    Car car3 = new Car("Toyota", "Camry", 2020, "Red");
 *    // etc... (telescope effect)
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("===== BUILDER DESIGN PATTERN DEMONSTRATION =====\n");
        
        // EXAMPLE 1: Basic usage - Setting all properties
        System.out.println("--- Example 1: Full Car Configuration ---");
        demonstrateFullConfiguration();
        
        // EXAMPLE 2: Partial configuration - Setting only some properties
        System.out.println("\n--- Example 2: Partial Configuration (only make and model) ---");
        demonstratePartialConfiguration();
        
        // EXAMPLE 3: Different order - Properties can be set in any order
        System.out.println("\n--- Example 3: Properties in Different Order ---");
        demonstrateDifferentOrder();
    }
    
    /**
     * EXAMPLE 1: FULL CONFIGURATION
     * 
     * Demonstrates the typical use case where we set all car properties.
     * The builder provides a fluent interface through method chaining.
     * Each setter returns 'this', allowing the next setter to be called on the result.
     * 
     * Execution flow:
     * 1. new Car.CarBuilder() - Create a new builder instance
     * 2. .setMake("Toyota") - Sets make and returns the builder (this)
     * 3. .setModel("Camry") - Sets model on the returned builder
     * 4. .setYear(2020) - Sets year on the returned builder
     * 5. .setColor("Red") - Sets color on the returned builder
     * 6. .build() - Creates and returns the final immutable Car object
     */
    private static void demonstrateFullConfiguration() {
        // Create a Car using the Builder with method chaining
        // This is the fluent API in action: very readable!
        Car car = new Car.CarBuilder()
                .setMake("Toyota")    // Manufacturer
                .setModel("Camry")    // Model name
                .setYear(2020)        // Manufacturing year
                .setColor("Red")      // Exterior color
                .setWeight(1500)      // Weight in kg
                .build();             // Construct the final Car object
        
        // Print the constructed Car
        System.out.println("Car created: " + car);
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Color: " + car.getColor());
        System.out.println("Weight: " + car.getWeight());
    }
    
    /**
     * EXAMPLE 2: PARTIAL CONFIGURATION
     * 
     * One of the key advantages of the Builder pattern:
     * You can set only the properties you care about.
     * Other properties will have their default values (null or 0).
     * 
     * This is impossible with a traditional constructor that requires all parameters,
     * and it avoids the "telescoping constructor" problem (multiple overloaded constructors).
     */
    private static void demonstratePartialConfiguration() {
        // Only set make and model - other properties use defaults
        // This is much cleaner than creating 5 different constructors!
        Car simpleCar = new Car.CarBuilder()
                .setMake("Honda")
                .setModel("Civic")
                // Note: We didn't set year, color, or weight
                // They remain at their default values
                .build();
        
        System.out.println("Partially configured car: " + simpleCar);
        System.out.println("Notice: Year=" + simpleCar.getYear() + 
                         " (default), Color='" + simpleCar.getColor() + 
                         "' (default), Weight=" + simpleCar.getWeight() + " (default)");
    }
    
    /**
     * EXAMPLE 3: PROPERTIES IN DIFFERENT ORDER
     * 
     * One of the beautiful aspects of the Builder pattern:
     * You can set properties in ANY order.
     * The order doesn't matter - only which properties you set.
     * 
     * With traditional constructors:
     *    new Car("BMW", "X5", 2024, "Black", 2000)
     *    // Oops! Was that color first or weight first? Easy to mix up!
     * 
     * With Builder, it's clear and self-documenting:
     */
    private static void demonstrateDifferentOrder() {
        // Set properties in a different order - it doesn't matter!
        // The builder doesn't care about the order of setters
        Car luxuryCar = new Car.CarBuilder()
                .setColor("Black")         // Start with color
                .setWeight(2000)           // Then weight
                .setMake("BMW")            // Then make
                .setYear(2024)             // Then year
                .setModel("X5")            // Then model
                .build();                  // Order doesn't matter!
        
        System.out.println("Luxury car (properties set in different order): " + luxuryCar);
        System.out.println("All properties set correctly regardless of order!");
    }
}
