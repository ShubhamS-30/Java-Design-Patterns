package org.practiceQuestions.parkingLotDesign.vehicles;

import org.practiceQuestions.parkingLotDesign.paymentmethods.ParkingFeeStrategy;

/**
 * Concrete implementation of Vehicle for trucks.
 * 
 * Design Pattern: Concrete Class in Abstract Class Pattern
 * This class represents a specific vehicle type (Truck) and inherits
 * common vehicle functionality from the abstract Vehicle class.
 * 
 * Responsibility:
 * - Initialize a truck vehicle with proper type classification
 * - Inherit all vehicle management functionality
 * 
 * IMPROVEMENTS:
 * 1. Could add truck size classification (mini, standard, large, semi)
 * 2. Could add load capacity and current load tracking
 * 3. Could add special permission requirements (hazmat, oversized)
 * 4. Could add commercial vehicle registration details
 * 5. Should enforce parking in large vehicle spots only
 */
public class Truck extends Vehicle{
    
    /**
     * Constructor to create a truck vehicle instance.
     * Automatically sets vehicle type to "Truck" for spot matching.
     * 
     * @param licencePlate The truck's license plate/registration number
     * @param parkingFeeStrategy The pricing strategy for this truck (typically premium)
     */
    public Truck(String licencePlate, ParkingFeeStrategy parkingFeeStrategy) {
        // Pass "Truck" as the vehicle type for spot classification
        super(licencePlate, "Truck", parkingFeeStrategy);
    }
}
