package org.practiceQuestions.parkingLotDesign.parkinglot;

import org.practiceQuestions.parkingLotDesign.vehicles.Vehicle;

/**
 * Abstract base class representing a parking spot in the parking lot.
 * Uses the Template Method pattern to define the structure of a parking spot.
 * Subclasses (CarParkingSpot, BikeParkingSpot) implement type-specific parking logic.
 * 
 * Improvement Note: This class uses the Template Method pattern combined with 
 * Factory pattern (for spot creation) to ensure type safety and flexibility.
 */
public abstract class ParkingSpot {
    private String slotType;           // Type of parking spot (Car, Bike, Truck, etc.)
    private boolean isOccupied;        // Current occupancy status
    private Vehicle vehicle;           // Currently parked vehicle
    private int spotNumber;            // Unique identifier for the parking spot

    /**
     * Constructor to initialize a parking spot with a specific type and spot number.
     * 
     * @param slotType The type of slot (Car, Bike, etc.)
     * @param spotNumber The unique spot number within the parking lot
     */
    public ParkingSpot(String slotType, int spotNumber) {
        this.slotType = slotType;
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

    /**
     * Returns the current occupancy status of the parking spot.
     * 
     * @return true if the spot is occupied, false otherwise
     */
    public boolean isOccupied(){
        return isOccupied;
    }

    /**
     * Abstract method to determine if a vehicle can be parked in this spot.
     * Based on vehicle type, dimensions, and spot specifications.
     * Subclasses implement type-specific validation logic.
     * 
     * IMPROVEMENT: Currently only checks vehicle type. Consider adding:
     * - Vehicle size/dimension validation
     * - Spot capacity constraints
     * - Special parking requirement checks (handicap, EV charging, etc.)
     * 
     * @param vehicle The vehicle attempting to park
     * @return true if the vehicle can park in this spot, false otherwise
     */
    public abstract boolean canPark(Vehicle vehicle);

    /**
     * Parks a vehicle in this spot after validation checks.
     * Performs the following checks:
     * 1. Verifies the spot is not already occupied
     * 2. Calls abstract canPark() for type-specific validation
     * 
     * IMPROVEMENT: Consider throwing exceptions instead of returning void to 
     * provide better error handling and caller notification.
     * Example: throw ParkingException with specific reason codes
     * 
     * @param vehicle The vehicle to park
     */
    public void parkVehicle(Vehicle vehicle){
        if(this.isOccupied){
            System.out.println("Spot " + spotNumber + " is already occupied.");
            return;
        }

        if(!canPark(vehicle)){
            System.out.println("Vehicle cannot be parked in this spot.");
            return;
        }

        this.vehicle = vehicle;
        this.isOccupied = true;

        System.out.println("Vehicle with license plate " + vehicle.getLicencePlate() + " parked in spot " + spotNumber);
    }

    /**
     * Vacates a parking spot, freeing it for future use.
     * Checks if the spot is currently occupied before vacating.
     * 
     * IMPROVEMENT: Add parking duration tracking and fee calculation
     * by storing parking start time and calculating duration on vacate.
     */
    public void vacateSpot(){
        if(!isOccupied){
            System.out.println("Spot " + spotNumber + " is already vacant.");
            return;
        }

        System.out.println("Vehicle with license plate " + vehicle.getLicencePlate() + " vacated from spot " + spotNumber);
        this.vehicle = null;
        this.isOccupied = false;
    }

    /**
     * Returns the type of parking spot (Car, Bike, Truck, etc.).
     * 
     * @return the slot type
     */
    public String getSlotType() {
        return slotType;
    }

    /**
     * Returns the unique identifier for this parking spot.
     * 
     * @return the spot number
     */
    public int getSpotNumber() {
        return spotNumber;
    }

    /**
     * Returns the currently parked vehicle in this spot.
     * 
     * @return the parked vehicle, or null if the spot is vacant
     */
    public Vehicle getVehicle() {
        return vehicle;
    }
}
