package org.practiceQuestions.parkingLotDesign.parkinglot;

import org.practiceQuestions.parkingLotDesign.vehicles.Vehicle;

/**
 * Concrete implementation of ParkingSpot for car vehicles.
 * 
 * Design Pattern: Template Method pattern (inherited from ParkingSpot)
 * This class provides concrete implementation of the abstract canPark() method
 * for car-type vehicles.
 * 
 * Improvement Note: This class could be extended to support:
 * - SUV vs regular car classification
 * - Compact vs standard size validation
 * - Reserved spots (VIP, handicap accessible, etc.)
 */
public class CarParkingSpot extends ParkingSpot {

    /**
     * Constructor to create a car parking spot with a specific spot number.
     * 
     * @param spotNumber The unique identifier for this car spot
     */
    public CarParkingSpot(int spotNumber) {
        super("Car", spotNumber);
    }

    /**
     * Validates if a vehicle can be parked in this car spot.
     * Currently performs a simple type-based check.
     * 
     * IMPROVEMENT: Enhance validation to include:
     * - Vehicle size/dimensions vs spot dimensions
     * - Weight capacity checks
     * - Special feature compatibility (e.g., EV charging availability)
     * 
     * @param vehicle The vehicle to validate for parking
     * @return true if the vehicle is of type "Car", false otherwise
     */
    @Override
    public boolean canPark(Vehicle vehicle) {
        // Type-based validation: only cars can park in car spots
        return vehicle.getType().equalsIgnoreCase("Car");
    }
}
