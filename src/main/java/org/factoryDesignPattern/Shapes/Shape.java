package org.factoryDesignPattern.Shapes;

/**
 * Shape Interface - Part of Factory Design Pattern
 * Purpose: Defines the contract for all shape objects
 * Factory Design Pattern:
 * - Creates objects without specifying exact classes
 * - Encapsulates object creation logic
 * - Allows client to request objects by type instead of instantiating directly
 */
public interface Shape {
    /**
     * Draws the shape
     * Each concrete shape will implement this differently
     */
    public void draw();
}
