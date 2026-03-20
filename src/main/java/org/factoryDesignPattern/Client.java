package org.factoryDesignPattern;

import org.factoryDesignPattern.Shapes.Shape;
import org.factoryDesignPattern.Shapes.ShapeFactory;

/**
 * Client - Demonstrates Factory Design Pattern
 * Key Points:
 * 1. Client doesn't create Shape objects directly (new Circle(), new Square())
 * 2. Client uses ShapeFactory to get Shape objects
 * 3. Client works with Shape interface, not concrete classes
 * 4. If you need to add new shapes, no need to modify this class
 */
public class Client {
    public static void main(String[] args) {
        // Step 1: Create the factory
        ShapeFactory shapeFactory = new ShapeFactory();

        // Step 2: Request shape from factory by type (not by instantiation)
        String shapeToCreate = "Circle";
        Shape shape = shapeFactory.createShape(shapeToCreate);

        // Step 3: Use the returned shape through the Shape interface
        // Client doesn't know if it's Circle, Square, or Triangle
        shape.draw();

        // Advantage: You can easily change "Circle" to "Square" or "Triangle"
        // and the rest of the code remains unchanged!
    }
}
