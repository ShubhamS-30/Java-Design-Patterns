package org.factoryDesignPattern;

import org.factoryDesignPattern.Shapes.Shape;
import org.factoryDesignPattern.Shapes.ShapeFactory;

public class Client {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        String shapeToCreate = "Circle";
        Shape shape = shapeFactory.createShape(shapeToCreate);
        shape.draw();
    }
}
