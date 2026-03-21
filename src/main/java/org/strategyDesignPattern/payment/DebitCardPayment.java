package org.strategyDesignPattern.payment;

/**
 * CONCRETE STRATEGY: DebitCardPayment
 * This is one of the concrete implementations of the PaymentStrategy interface.
 * It implements a specific payment algorithm for processing debit card payments.
 * Role in Strategy Pattern:
 * - Concrete Strategy: Implements the PaymentStrategy interface
 * - Encapsulates the debit card payment algorithm
 * - Can be swapped with other payment strategies at runtime
 * Differences from CreditCardPayment:
 * - Debit cards directly deduct from bank account (no credit)
 * - Different validation rules (PIN instead of CVV)
 * - Different transaction limits and fees
 * Usage:
 * PaymentProcessor processor = new PaymentProcessor(new DebitCardPayment());
 * processor.processPayment(100.0);
 */
public class DebitCardPayment implements PaymentStrategy {

    /**
     * Implementation of debit card payment processing.
     * This method defines the algorithm specific to debit card transactions.
     * In a real application, this would:
     * - Validate debit card details and PIN
     * - Check account balance
     * - Contact bank/payment processor
     * - Ensure immediate fund transfer
     * - Log transaction
     *
     * @param amount The payment amount in dollars
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing debit card payment of $" + amount);
    }
}
