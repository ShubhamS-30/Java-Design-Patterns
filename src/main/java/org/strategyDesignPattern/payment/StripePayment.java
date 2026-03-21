package org.strategyDesignPattern.payment;

/**
 * CONCRETE STRATEGY: StripePayment
 * This is one of the concrete implementations of the PaymentStrategy interface.
 * It implements a specific payment algorithm for processing payments via Stripe gateway.
 * Role in Strategy Pattern:
 * - Concrete Strategy: Implements the PaymentStrategy interface
 * - Encapsulates the Stripe payment algorithm
 * - Can be swapped with other payment strategies at runtime
 * Benefits of Stripe Integration:
 * - Supports multiple payment methods (cards, wallets, bank transfers)
 * - PCI DSS compliance handled by Stripe
 * - Fraud detection and prevention
 * - Global payment processing
 * - Detailed analytics and reporting
 * Usage:
 * PaymentProcessor processor = new PaymentProcessor(new StripePayment());
 * processor.processPayment(100.0);
 */
public class StripePayment implements PaymentStrategy {
    
    /**
     * Implementation of Stripe payment processing.
     * This method defines the algorithm specific to Stripe transactions.
     * In a real application, this would:
     * - Initialize Stripe API client
     * - Create or use Stripe payment method token
     * - Send payment request to Stripe servers
     * - Handle webhook notifications
     * - Process payment confirmation/failure
     * - Handle retries for declined payments
     * 
     * @param amount The payment amount in dollars
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment of $" + amount);
    }
}
