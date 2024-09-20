package org.strategyDesignPattern;

import org.strategyDesignPattern.vehicle.NormalVehicle;
import org.strategyDesignPattern.vehicle.Vehicle;

public class Driving {
    public static void main(String[] args) {

        // change type of vehicle to get different results without changing any code anywhere else.
        Vehicle vehicle = new NormalVehicle();
        vehicle.drive();
    }
}
