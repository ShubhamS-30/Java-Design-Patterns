package org.strategyDesignPattern.drive;

/**
 * Drive - Strategy Interface in Strategy Design Pattern
 *
 * Purpose: Defines the contract for different driving strategies
 *
 * Strategy Design Pattern Key Concepts:
 * - Defines a family of algorithms (strategies)
 * - Makes them interchangeable
 * - Lets the algorithm vary independently of clients that use it
 *
 * In this example:
 * - Drive interface: Different ways to drive
 * - NormalDrive: One strategy (normal driving behavior)
 * - SpecialDrive: Another strategy (special/aggressive driving behavior)
 *
 * Benefits:
 * 1. Easy to add new driving strategies without modifying existing code
 * 2. Vehicle doesn't need to know concrete strategy implementation
 * 3. Strategy can be changed at runtime
 * 4. Follows Open/Closed Principle
 *
 * Real-world analogy:
 * - Payment strategy: Credit card, Debit card, PayPal, Crypto
 * - Sorting strategy: QuickSort, MergeSort, BubbleSort
 * - Compression strategy: ZIP, RAR, 7Z
 */
public interface Drive {
    /**
     * Different strategies will implement this differently
     * NormalDrive: drives normally
     * SpecialDrive: drives with special behavior
     */
    public void drive();
}
