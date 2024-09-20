package org.strategyDesignPattern.vehicle;

import org.strategyDesignPattern.drive.SpecialDrive;

public class SpecialVehicle extends Vehicle{
    public SpecialVehicle() {
        // assign strategy to Vehicle
        super(new SpecialDrive());
    }
}

