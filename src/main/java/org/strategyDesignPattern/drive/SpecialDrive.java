package org.strategyDesignPattern.drive;

/**
 * SpecialDrive - Concrete Strategy in Strategy Design Pattern
 *
 * Role: Implements another specific driving strategy
 * This strategy drives specially/aggressively (high-performance driving)
 *
 * Key Point: This is another algorithm in the family of driving strategies
 * It coexists with NormalDrive without any coupling
 */
public class SpecialDrive implements Drive {
    /**
     * Implements special/aggressive driving behavior
     */
    @Override
    public void drive() {
        System.out.println("Special Drive method");
    }
}