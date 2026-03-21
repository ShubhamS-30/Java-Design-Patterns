package org.strategyDesignPattern.payment;

/**
 * CONCRETE STRATEGY: CreditCardPayment
 * This is one of the concrete implementations of the PaymentStrategy interface.
 * It implements a specific payment algorithm for processing credit card payments.
 * Role in Strategy Pattern:
 * - Concrete Strategy: Implements the PaymentStrategy interface
 * - Encapsulates the credit card payment algorithm
 * - Can be swapped with other payment strategies at runtime
 * Usage:
 * PaymentProcessor processor = new PaymentProcessor(new CreditCardPayment());
 * processor.processPayment(100.0);
 */
public class CreditCardPayment implements PaymentStrategy {
    
    /**
     * Implementation of credit card payment processing.
     * This method defines the algorithm specific to credit card transactions.
     * In a real application, this would:
     * - Validate card details
     * - Contact payment gateway (Stripe, Square, etc.)
     * - Handle transaction success/failure
     * - Update transaction logs
     * 
     * @param amount The payment amount in dollars
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
