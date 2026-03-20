package org.strategyDesignPattern;

import org.strategyDesignPattern.vehicle.NormalVehicle;
import org.strategyDesignPattern.vehicle.Vehicle;

/**
 * Driving - Client demonstrating Strategy Design Pattern
 *
 * Key Points:
 * 1. To change driving strategy, just change the vehicle type
 * 2. Vehicle implementation remains the same
 * 3. No if-else statements needed for different strategies
 * 4. Easy to add new strategies without changing client code
 *
 * Strategy Pattern Benefits:
 * 1. Eliminates conditional logic (if-else, switch)
 * 2. Strategies are encapsulated and easily swappable
 * 3. Each strategy is independent and testable
 * 4. Follows Single Responsibility and Open/Closed principles
 *
 * Comparison with other approaches:
 *
 * Bad approach (without Strategy Pattern):
 * if (vehicleType == "normal") drive normally;
 * else if (vehicleType == "special") drive specially;
 * -> Creates tight coupling and hard to maintain
 *
 * Strategy Pattern approach:
 * Vehicle vehicle = new NormalVehicle();  // or new SpecialVehicle()
 * vehicle.drive();
 * -> Clean, extensible, and maintainable
 */
public class Driving {
    public static void main(String[] args) {

        // Change type of vehicle to get different results without changing any code anywhere else.
        // This is the power of Strategy Pattern!

        // Currently using NormalVehicle with NormalDrive strategy
        Vehicle vehicle = new NormalVehicle();
        vehicle.drive();  // Will call NormalDrive's implementation

        // To change strategy, just change the vehicle type:
        // Vehicle vehicle = new SpecialVehicle();
        // vehicle.drive();  // Will call SpecialDrive's implementation

        // The rest of the code doesn't need to change!
        // The strategy is encapsulated in the vehicle type
    }
}
