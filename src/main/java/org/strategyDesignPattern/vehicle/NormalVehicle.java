package org.strategyDesignPattern.vehicle;

import org.strategyDesignPattern.drive.NormalDrive;

/**
 * NormalVehicle - Concrete Context in Strategy Design Pattern
 * Role: Creates a vehicle with the NormalDrive strategy
 * Key Point: Instead of Vehicle extending NormalVehicle and SpecialVehicle,
 * we create concrete vehicle types that inject their specific strategy
 */
public class NormalVehicle extends Vehicle {
    /**
     * Constructor injects the NormalDrive strategy into the Vehicle
     * This vehicle will always use normal driving behavior
     */
    public NormalVehicle() {
        // assign strategy to Vehicle via constructor
        // This is the only difference from SpecialVehicle!
        super(new NormalDrive());
    }
}
