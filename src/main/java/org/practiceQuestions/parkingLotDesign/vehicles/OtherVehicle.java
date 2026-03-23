package org.practiceQuestions.parkingLotDesign.vehicles;

import org.practiceQuestions.parkingLotDesign.paymentmethods.ParkingFeeStrategy;

/**
 * Concrete implementation of Vehicle for unclassified vehicles.
 * 
 * Design Pattern: Concrete Class in Abstract Class Pattern
 * Acts as a catch-all vehicle type for any vehicles that don't fit into
 * standard categories (Car, Bike, Truck).
 * 
 * Responsibility:
 * - Handle miscellaneous vehicle types
 * - Provide default behavior and pricing for unclassified vehicles
 * 
 * Use Cases:
 * - Scooters, motorcycles, RVs, buses, etc.
 * - Temporary or guest vehicles
 * - Vehicles from less common manufacturers
 * 
 * IMPROVEMENTS:
 * 1. Consider adding specific vehicle type enumeration for better classification
 * 2. Could add sub-type specification in constructor
 * 3. Should be avoided in production - prefer explicit type classes
 * 4. Consider creating additional concrete classes for common "Other" types
 */
public class OtherVehicle extends Vehicle{
    
    /**
     * Constructor to create an unclassified vehicle instance.
     * Sets vehicle type to "Other" as a catch-all category.
     * 
     * NOTE: This class should ideally be used minimally. Consider creating
     * explicit vehicle type classes for common vehicle types instead.
     * 
     * @param licencePlate The vehicle's license plate/registration number
     * @param parkingFeeStrategy The pricing strategy for this vehicle
     */
    public OtherVehicle(String licencePlate, ParkingFeeStrategy parkingFeeStrategy) {
        // Pass "Other" as a catch-all vehicle type for unclassified vehicles
        super(licencePlate, "Other", parkingFeeStrategy);
    }
}
