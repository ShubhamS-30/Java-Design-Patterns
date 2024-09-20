package org.factoryDesignPattern.Shapes;

public class ShapeFactory {
    public Shape createShape(String shapeType) {
        switch (shapeType) {
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            case "Triangle":
                return new Triangle();
            default:
                return null;
        }
    }
}
