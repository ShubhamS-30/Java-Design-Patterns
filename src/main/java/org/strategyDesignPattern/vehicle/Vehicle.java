package org.strategyDesignPattern.vehicle;

import org.strategyDesignPattern.drive.Drive;

public class Vehicle {
    private Drive drive;

    // constructor injection
    Vehicle(Drive drive){
        this.drive = drive;
    }

    public void drive()
    {
        drive.drive();
    }
}