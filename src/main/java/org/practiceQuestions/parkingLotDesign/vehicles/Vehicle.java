package org.practiceQuestions.parkingLotDesign.vehicles;

import org.practiceQuestions.parkingLotDesign.paymentmethods.ParkingFeeStrategy;

/**
 * Abstract base class representing a vehicle in the parking lot system.
 * 
 * Design Patterns Used:
 * 1. Abstract Class Pattern: Defines common interface for all vehicles
 * 2. Strategy Pattern: Uses pluggable ParkingFeeStrategy for dynamic fee calculation
 * 3. Composition Pattern: Contains a ParkingFeeStrategy to calculate parking fees
 * 
 * Responsibilities:
 * - Store vehicle identification (license plate)
 * - Identify vehicle type (Car, Bike, Truck, etc.)
 * - Associate a parking fee strategy with the vehicle
 * 
 * IMPROVEMENTS IDENTIFIED:
 * 1. Add vehicle dimensions/size properties for better spot matching
 * 2. Add parking entry/exit timestamp tracking
 * 3. Add parking history/log for audit trails
 * 4. Consider adding equals() and hashCode() overrides based on license plate
 * 5. Add vehicle condition status (active, suspended, etc.)
 */
public abstract class Vehicle {
    /** License plate/registration number of the vehicle */
    private String licencePlate;
    
    /** Type of vehicle (Car, Bike, Truck, etc.) */
    private String type;
    
    /** Strategy for calculating parking fees for this vehicle */
    private ParkingFeeStrategy parkingFeeStrategy;

    /**
     * Constructor to initialize a vehicle with its identification and fee strategy.
     * 
     * @param licencePlate The vehicle's license plate number (should be unique)
     * @param type The type of vehicle (e.g., "Car", "Bike", "Truck")
     * @param parkingFeeStrategy The pricing strategy to apply for this vehicle
     */
    public Vehicle(String licencePlate, String type, ParkingFeeStrategy parkingFeeStrategy) {
        this.licencePlate = licencePlate;
        this.type = type;
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    /**
     * Returns the license plate of this vehicle.
     * License plates should be unique identifiers within the parking system.
     * 
     * @return the vehicle's license plate
     */
    public String getLicencePlate() {
        return licencePlate;
    }

    /**
     * Returns the type classification of this vehicle.
     * Used for determining compatible parking spot types.
     * 
     * @return the vehicle type (e.g., "Car", "Bike")
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the parking fee strategy associated with this vehicle.
     * Strategy pattern enables dynamic fee calculation algorithms.
     * 
     * IMPROVEMENT: Consider adding Optional wrapper to handle null strategy gracefully
     * 
     * @return the ParkingFeeStrategy for this vehicle
     */
    public ParkingFeeStrategy getParkingFeeStrategy() {
        return parkingFeeStrategy;
    }
}
