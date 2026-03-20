package org.strategyDesignPattern.vehicle;

import org.strategyDesignPattern.drive.Drive;

/**
 * Vehicle - Context Class in Strategy Design Pattern
 *
 * Role: Uses a strategy to accomplish a task
 * The vehicle holds a reference to the strategy and delegates to it
 *
 * Key Points:
 * 1. Vehicle doesn't know or care which strategy is used
 * 2. Strategy is injected via constructor (dependency injection)
 * 3. Vehicle just calls the strategy's method
 * 4. Strategy can be changed at runtime if needed
 *
 * This demonstrates composition over inheritance:
 * - Instead of extending Vehicle for NormalVehicle and SpecialVehicle,
 *   we use composition to inject the strategy
 */
public class Vehicle {
    // The strategy object - Vehicle uses this to drive
    private Drive drive;

    /**
     * Constructor Injection: The driving strategy is provided at creation time
     * This is dependency injection - the vehicle depends on a Drive strategy
     *
     * @param drive - The strategy to use for driving
     */
    Vehicle(Drive drive){
        this.drive = drive;
    }

    /**
     * Performs the driving action using the injected strategy
     * This is the key idea: Vehicle delegates to the strategy
     * Vehicle doesn't know HOW to drive, just THAT it should drive using its strategy
     */
    public void drive()
    {
        drive.drive();  // Delegate to the strategy
    }
}