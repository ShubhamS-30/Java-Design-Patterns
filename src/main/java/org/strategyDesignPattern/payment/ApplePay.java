package org.strategyDesignPattern.payment;

/**
 * CONCRETE STRATEGY: Apple Pay
 * This is one of the concrete implementations of the PaymentStrategy interface.
 * It implements a specific payment algorithm for processing Apple Pay transactions.
 * Role in Strategy Pattern:
 * - Concrete Strategy: Implements the PaymentStrategy interface
 * - Encapsulates the Apple Pay payment algorithm
 * - Can be swapped with other payment strategies at runtime
 * Benefits of using Apple Pay:
 * - Enhanced security through tokenization
 * - Biometric authentication (Face ID / Touch ID)
 * - One-click/one-tap payments
 * - Works seamlessly on Apple devices
 * Usage:
 * PaymentProcessor processor = new PaymentProcessor(new ApplePay());
 * processor.processPayment(100.0);
 */
public class ApplePay implements PaymentStrategy {
    
    /**
     * Implementation of Apple Pay payment processing.
     * This method defines the algorithm specific to Apple Pay transactions.
     * In a real application, this would:
     * - Authenticate user via biometrics or passcode
     * - Use tokenized payment information (not actual card details)
     * - Communicate with Apple Pay servers
     * - Contact merchant's payment gateway
     * - Handle transaction confirmation
     * 
     * @param amount The payment amount in dollars
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Apple Pay payment of $" + amount);
    }
}
