package org.abstractFactoryDesignPattern.factory;

import org.abstractFactoryDesignPattern.car.Audi;
import org.abstractFactoryDesignPattern.car.BMW;
import org.abstractFactoryDesignPattern.car.Car;

/**
 * LuxuryFactory - Concrete Factory in Abstract Factory Pattern
 *
 * Role: Creates products from the "Luxury Car Family"
 * Products created: BMW, Audi
 *
 * Key Point: This factory is responsible for creating all luxury car variants
 * It ensures that only compatible luxury cars are created together
 */
public class LuxuryFactory implements Factory {

    private String carName;

    /**
     * Constructor stores the car model name to create
     * @param carName - The specific luxury car model (BMW or Audi)
     */
    public LuxuryFactory(String carName) {
        this.carName = carName;
    }

    /**
     * Creates and returns a luxury car based on the carName
     *
     * This method creates only luxury car products
     * If you want common cars, use CommonFactory instead
     */
    @Override
    public Car getCar() {
        // Factory uses switch to create the correct luxury car variant
        return switch (this.carName) {
            case "BMW" -> new BMW();
            case "Audi" -> new Audi();
            default -> null;
        };
    }
}
