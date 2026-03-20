package org.abstractFactoryDesignPattern.factory;

import org.abstractFactoryDesignPattern.car.Car;

/**
 * CarFactory - Main Factory in Abstract Factory Pattern
 *
 * Role: Acts as the primary entry point that delegates to the appropriate
 *       concrete factory (LuxuryFactory or CommonFactory) based on car type
 *
 * Hierarchy:
 * CarFactory (routes requests)
 *   ├── LuxuryFactory (creates BMW, Audi)
 *   └── CommonFactory (creates Maruti, TATA)
 *
 * Benefits of Abstract Factory Pattern:
 * 1. Ensures related products are created together
 * 2. Prevents mixing luxury and common cars
 * 3. Easy to add new car families (e.g., ElectricFactory)
 * 4. Client code never changes when adding new car families
 */
public class CarFactory implements Factory {

    private String carName;

    /**
     * Constructor stores the car model to create
     * @param carName - The car model name (BMW, Audi, Maruti, TATA, etc.)
     */
    public CarFactory(String carName) {
        this.carName = carName;
    }

    /**
     * Routes the request to the appropriate concrete factory
     *
     * This method determines whether a luxury or common car is requested,
     * then delegates to the correct factory
     *
     * @return Car object from the appropriate family
     */
    @Override
    public Car getCar() {
        // Route to LuxuryFactory for luxury cars
        // Route to CommonFactory for common cars
        switch (this.carName) {
            case "BMW", "Audi":
                // Request goes to LuxuryFactory
                return new LuxuryFactory(this.carName).getCar();
            case "Maruti", "TATA":
                // Request goes to CommonFactory
                return new CommonFactory(this.carName).getCar();
            default:
                return null;
        }
    }
}
