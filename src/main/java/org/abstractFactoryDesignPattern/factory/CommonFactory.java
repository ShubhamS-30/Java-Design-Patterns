package org.abstractFactoryDesignPattern.factory;

import org.abstractFactoryDesignPattern.car.Car;
import org.abstractFactoryDesignPattern.car.Maruti;
import org.abstractFactoryDesignPattern.car.TATA;

/**
 * CommonFactory - Concrete Factory in Abstract Factory Pattern
 *
 * Role: Creates products from the "Common/Budget Car Family"
 * Products created: Maruti, TATA
 *
 * Key Point: This factory is responsible for creating all common car variants
 * It ensures that only compatible budget cars are created together
 */
public class CommonFactory implements Factory {

    private String carName;

    /**
     * Constructor stores the car model name to create
     * @param carName - The specific common car model (Maruti or TATA)
     */
    public CommonFactory(String carName) {
        this.carName = carName;
    }

    /**
     * Creates and returns a common car based on the carName
     *
     * This method creates only common/budget car products
     * If you want luxury cars, use LuxuryFactory instead
     */
    @Override
    public Car getCar() {
        // Factory uses switch to create the correct common car variant
        return switch (this.carName) {
            case "Maruti" -> new Maruti();
            case "TATA" -> new TATA();
            default -> null;
        };
    }
}
