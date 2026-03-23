package org.practiceQuestions.parkingLotDesign.vehicles;

import org.practiceQuestions.parkingLotDesign.paymentmethods.ParkingFeeStrategy;

/**
 * Concrete implementation of Vehicle for cars.
 * 
 * Design Pattern: Concrete Class in Abstract Class Pattern
 * This class represents a specific vehicle type (Car) and inherits
 * common vehicle functionality from the abstract Vehicle class.
 * 
 * Responsibility:
 * - Initialize a car vehicle with proper type classification
 * - Inherit all vehicle management functionality
 * 
 * IMPROVEMENTS:
 * 1. Could add specific car properties (sedan, SUV, color, model year)
 * 2. Could add fuel type classification (gas, electric, hybrid)
 * 3. Could add parking space size requirements based on model
 * 4. Could add special features flag (handicap, reserved, EV charging)
 */
public class Car extends Vehicle{
    
    /**
     * Constructor to create a car vehicle instance.
     * Automatically sets vehicle type to "Car" for spot matching.
     * 
     * @param licencePlate The car's license plate number
     * @param parkingFeeStrategy The pricing strategy for this car (can vary by car type)
     */
    public Car(String licencePlate, ParkingFeeStrategy parkingFeeStrategy) {
        // Pass "Car" as the vehicle type to match with CarParkingSpot
        super(licencePlate, "Car", parkingFeeStrategy);
    }
}
