package org.strategyDesignPattern.vehicle;

import org.strategyDesignPattern.drive.SpecialDrive;

/**
 * SpecialVehicle - Concrete Context in Strategy Design Pattern
 *
 * Role: Creates a vehicle with the SpecialDrive strategy
 *
 * Key Point: Only difference between NormalVehicle and SpecialVehicle
 * is the strategy they inject. Everything else is identical!
 *
 * This shows the power of Strategy Pattern:
 * - Different behaviors with minimal code duplication
 * - Easy to add new vehicle types (ElectricVehicle, HybridVehicle, etc.)
 */
public class SpecialVehicle extends Vehicle{
    /**
     * Constructor injects the SpecialDrive strategy into the Vehicle
     * This vehicle will always use special driving behavior
     */
    public SpecialVehicle() {
        // assign strategy to Vehicle via constructor
        // This is the only difference from NormalVehicle!
        super(new SpecialDrive());
    }
}

