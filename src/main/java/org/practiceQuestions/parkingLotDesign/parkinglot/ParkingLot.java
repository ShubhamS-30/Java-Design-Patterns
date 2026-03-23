package org.practiceQuestions.parkingLotDesign.parkinglot;

import org.practiceQuestions.parkingLotDesign.vehicles.Vehicle;

import java.util.List;

/**
 * ParkingLot class manages the entire parking lot and its operations.
 * 
 * Design Patterns Used:
 * 1. Facade Pattern: Provides a simple interface to complex parking spot management
 * 2. Strategy Pattern: Uses different pricing strategies via ParkingFeeStrategy
 * 3. Factory Pattern: Creates vehicles and spots dynamically
 * 
 * Responsibilities:
 * - Find available parking spots based on vehicle type
 * - Park vehicles in appropriate spots
 * - Manage vehicle vacation (removing parked vehicles)
 * - Track all parking spots and their status
 * 
 * IMPROVEMENTS IDENTIFIED:
 * 1. Thread Safety: Add synchronization for concurrent access in real parking lots
 *    Consider using ConcurrentHashMap or synchronized blocks.
 * 
 * 2. Statistics & Reporting: Add methods to:
 *    - Get occupancy rate
 *    - Get revenue statistics
 *    - Get spot utilization metrics
 * 
 * 3. Reservation System: Add pre-booking functionality for spots
 * 
 * 4. Pricing Display: Add methods to display available spots with pricing
 * 
 * 5. Event Logging: Track all parking/vacation events for audit trail
 */
public class ParkingLot {
    /** List of all parking spots available in the lot */
    private List<ParkingSpot> parkingSpots;

    /**
     * Constructor to initialize a parking lot with specific parking spots.
     * 
     * @param parkingSpots List of ParkingSpot objects representing the parking lot structure
     */
    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    /**
     * Finds the first available parking spot for a specific vehicle type.
     * Iterates through all spots to find one that is:
     * 1. Not occupied
     * 2. Matches the vehicle type
     * 
     * IMPROVEMENT: Consider optimizing with:
     * - HashMap of Lists for O(1) lookup by type instead of O(n)
     * - Priority-based spot selection (prefer nearest, preferred spots, etc.)
     * - Spot reservation system to prevent race conditions
     * 
     * @param vehicleType The type of vehicle (Car, Bike, Truck, etc.)
     * @return Available ParkingSpot if found, null otherwise
     */
    public ParkingSpot findAvailableSpot(String vehicleType) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getSlotType().equals(vehicleType)) {
                return spot;
            }
        }
        return null; // No available spot found for the requested vehicle type
    }

    /**
     * Parks a vehicle in an available spot matching its type.
     * Attempts to:
     * 1. Find an available spot suitable for the vehicle
     * 2. Park the vehicle in that spot
     * 
     * IMPROVEMENT: Return detailed result object containing:
     * - Success/failure status
     * - Reason for failure (if applicable)
     * - Parking spot details and fee information
     * - Parking duration estimation
     * 
     * @param vehicle The vehicle to park
     * @return The ParkingSpot where vehicle is parked, or null if parking failed
     */
    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getType());
        if (spot != null) {
            spot.parkVehicle(vehicle);
            return spot;
        } else {
            System.out.println("No available spot for vehicle type: " + vehicle.getType() + " with license plate: " + vehicle.getLicencePlate());
            return null;
        }
    }

    /**
     * Vacates a parking spot, freeing it for future use.
     * Validates that the vehicle actually belongs to the spot before vacating.
     * 
     * IMPROVEMENT: 
     * - Calculate parking duration and apply fees
     * - Log vacation event with timestamp
     * - Update occupancy statistics
     * - Handle concurrent vacation requests
     * 
     * @param spot The parking spot to vacate
     * @param vehicle The vehicle vacating the spot
     */
    public void vacateSpot(ParkingSpot spot, Vehicle vehicle){
        if(spot != null && spot.isOccupied() && spot.getVehicle().equals(vehicle)){
            spot.vacateSpot();
        } else {
            System.out.println("Invalid spot or vehicle for vacating.");
        }
    }

    /**
     * Retrieves a parking spot by its spot number.
     * 
     * IMPROVEMENT: Use HashMap<Integer, ParkingSpot> for O(1) lookup
     * instead of iterating through the list.
     * 
     * @param spotNumber The unique spot number to search for
     * @return The ParkingSpot with the given number, or null if not found
     */
    public ParkingSpot getParkingSpotByNumber(int spotNumber) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotNumber() == spotNumber) {
                return spot;
            }
        }
        return null; // No spot found with the given number
    }

    /**
     * Returns all parking spots in the lot.
     * 
     * @return List of all parking spots
     */
    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
