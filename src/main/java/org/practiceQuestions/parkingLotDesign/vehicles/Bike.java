package org.practiceQuestions.parkingLotDesign.vehicles;

import org.practiceQuestions.parkingLotDesign.paymentmethods.ParkingFeeStrategy;

/**
 * Concrete implementation of Vehicle for bikes.
 * 
 * Design Pattern: Concrete Class in Abstract Class Pattern
 * This class represents a specific vehicle type (Bike) and inherits
 * common vehicle functionality from the abstract Vehicle class.
 * 
 * Responsibility:
 * - Initialize a bike vehicle with proper type classification
 * - Inherit all vehicle management functionality
 * 
 * IMPROVEMENTS:
 * 1. Could add bike sub-type (bicycle, motorcycle, scooter, etc.)
 * 2. Could add vehicle status (active, under maintenance, suspended)
 * 3. Could add owner information and contact details
 * 4. Could add insurance/registration status tracking
 */
public class Bike extends Vehicle{
    
    /**
     * Constructor to create a bike vehicle instance.
     * Automatically sets vehicle type to "Bike" for spot matching.
     * 
     * @param licencePlate The bike's license plate/registration number
     * @param parkingFeeStrategy The pricing strategy for this bike
     */
    public Bike(String licencePlate, ParkingFeeStrategy parkingFeeStrategy) {
        // Pass "Bike" as the vehicle type to match with BikeParkingSpot
        super(licencePlate, "Bike", parkingFeeStrategy);
    }
}
