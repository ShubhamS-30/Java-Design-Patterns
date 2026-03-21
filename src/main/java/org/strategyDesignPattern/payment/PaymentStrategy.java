package org.strategyDesignPattern.payment;

/**
 * STRATEGY DESIGN PATTERN - Payment Strategy Interface
 * Purpose: Define a family of payment algorithms and encapsulate each one,
 * making them interchangeable. Strategy lets the algorithm vary independently 
 * of clients that use it.
 * Key Characteristics:
 * - Defines a common interface for all supported payment strategies
 * - Each concrete strategy implements this interface with its own algorithm
 * - Allows runtime selection and switching between different payment methods
 * - Promotes Open/Closed Principle: Open for extension, closed for modification
 * Benefits:
 * - Easy to add new payment methods without modifying existing code
 * - Payment logic is isolated from the PaymentProcessor
 * - Flexible switching between payment strategies at runtime
 * - Better testability: Each strategy can be tested independently
 * Real-world use cases: Payment processing, Sorting algorithms, Compression techniques,
 * Data validation rules, Routing algorithms
 */
public interface PaymentStrategy {
    /**
     * Process a payment transaction using the specific payment strategy.
     * Implementations: Apple Pay, CreditCardPayment, DebitCardPayment, StripePayment
     * 
     * @param amount The amount to be processed
     */
    public void processPayment(double amount);
}
