package org.factoryDesignPattern.Shapes;

/**
 * ShapeFactory - Factory class in Factory Design Pattern
 * Role: Encapsulates object creation logic
 * Key Benefits:
 * 1. Client doesn't need to know concrete shape classes
 * 2. Loose coupling between client and shape classes
 * 3. Easy to add new shapes without modifying client code (Open/Closed Principle)
 * 4. Centralized object creation logic - easy to modify
 */
public class ShapeFactory {
    /**
     * Creates and returns a Shape object based on the type requested
     *
     * @param shapeType - The type of shape to create (Circle, Square, Triangle)
     * @return Shape instance of the requested type, or null if type is invalid
     * This method is the core of the Factory Pattern - it decides which
     * concrete class to instantiate based on the input parameter
     */
    public Shape createShape(String shapeType) {
        // Factory uses switch/if-else to determine which concrete product to create
        return switch (shapeType) {
            case "Circle" -> new Circle();
            case "Square" -> new Square();
            case "Triangle" -> new Triangle();
            default -> null;
        };
    }
}
