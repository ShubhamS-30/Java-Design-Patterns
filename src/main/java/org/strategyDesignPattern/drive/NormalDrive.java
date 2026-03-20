package org.strategyDesignPattern.drive;

/**
 * NormalDrive - Concrete Strategy in Strategy Design Pattern
 *
 * Role: Implements one specific driving strategy
 * This strategy drives normally (follows rules, safe driving)
 *
 * Key Point: This is one algorithm in the family of driving strategies
 */
public class NormalDrive implements Drive {
    /**
     * Implements normal driving behavior
     */
    @Override
    public void drive() {
        System.out.println("Normal Drive Method");
    }
}

