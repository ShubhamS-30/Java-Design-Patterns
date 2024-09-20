package org.strategyDesignPattern.vehicle;

import org.strategyDesignPattern.drive.NormalDrive;

public class NormalVehicle extends Vehicle {
    public NormalVehicle() {
        // assign strategy to Vehicle
        super(new NormalDrive());
    }
}
