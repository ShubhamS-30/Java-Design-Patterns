package org.practiceQuestions.parkingLotDesign.vehicles;

import org.practiceQuestions.parkingLotDesign.paymentmethods.ParkingFeeStrategy;

/**
 * Factory class for creating vehicle instances.
 * 
 * Design Pattern: Factory Method / Simple Factory Pattern
 * Centralizes the object creation logic for different vehicle types.
 * Encapsulates the complexity of vehicle instantiation and ensures
 * consistent object creation throughout the application.
 * 
 * Benefits:
 * 1. Decouples client code from concrete Vehicle implementations
 * 2. Centralizes vehicle type validation and creation logic
 * 3. Easy to add new vehicle types without modifying client code
 * 4. Provides single point of maintenance for vehicle creation
 * 
 * IMPROVEMENTS:
 * 1. Could throw custom exceptions for invalid vehicle types instead of defaulting
 * 2. Could implement caching for frequently created vehicles
 * 3. Could add validation for license plate format
 * 4. Could add logging for vehicle creation events
 * 5. Could support vehicle configuration through a properties file
 */
public class VehicleFactory {

    /**
     * Creates a vehicle instance of the specified type.
     * Uses a switch expression to map vehicle types to their concrete classes.
     * 
     * Supported types (case-insensitive):
     * - "car": Creates a Car instance
     * - "bike": Creates a Bike instance
     * - "truck": Creates a Truck instance
     * - default: Creates an OtherVehicle instance
     * 
     * IMPROVEMENT: Consider throwing exceptions for unknown types:
     * throw new IllegalArgumentException("Unknown vehicle type: " + type);
     * 
     * @param type The vehicle type (e.g., "car", "bike", "truck")
     * @param licencePlate The vehicle's unique license plate identifier
     * @param parkingFeeStrategy The pricing strategy to apply to this vehicle
     * @return A Vehicle instance of the appropriate type
     * @throws IllegalArgumentException if type is null
     */
    public static Vehicle createVehicle(String type, String licencePlate, ParkingFeeStrategy parkingFeeStrategy) {
        // Use switch expression (Java 14+) for cleaner type mapping
        return switch (type.toLowerCase()) {
            case "car" -> new Car(licencePlate, parkingFeeStrategy);
            case "bike" -> new Bike(licencePlate, parkingFeeStrategy);
            case "truck" -> new Truck(licencePlate, parkingFeeStrategy);
            // Default case for unknown vehicle types
            default -> new OtherVehicle(licencePlate, parkingFeeStrategy);
        };
    }
}
