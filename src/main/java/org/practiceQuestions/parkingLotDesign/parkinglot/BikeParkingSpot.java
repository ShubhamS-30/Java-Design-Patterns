package org.practiceQuestions.parkingLotDesign.parkinglot;

import org.practiceQuestions.parkingLotDesign.vehicles.Vehicle;

/**
 * Concrete implementation of ParkingSpot for bike vehicles.
 * 
 * Design Pattern: Template Method pattern (inherited from ParkingSpot)
 * This class provides concrete implementation of the abstract canPark() method
 * for bike-type vehicles.
 * 
 * Improvement Note: This class could be extended to support:
 * - Motorcycle vs bicycle differentiation
 * - Secure/covered vs open spot classification
 * - Charging capability for electric bikes
 */
public class BikeParkingSpot extends ParkingSpot {

    /**
     * Constructor to create a bike parking spot with a specific spot number.
     * 
     * @param spotNumber The unique identifier for this bike spot
     */
    public BikeParkingSpot(int spotNumber) {
        super("Bike", spotNumber);
    }

    /**
     * Validates if a vehicle can be parked in this bike spot.
     * Currently performs a simple type-based check.
     * 
     * IMPROVEMENT: Enhance validation to include:
     * - Motorcycle vs bicycle size constraints
     * - Weight capacity verification
     * - Special equipment requirements (e.g., charging for electric bikes)
     * 
     * @param vehicle The vehicle to validate for parking
     * @return true if the vehicle is of type "Bike", false otherwise
     */
    @Override
    public boolean canPark(Vehicle vehicle) {
        // Type-based validation: only bikes can park in bike spots
        return vehicle.getType().equalsIgnoreCase("Bike");
    }
}
