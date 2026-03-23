package org.practiceQuestions.parkingLotDesign.paymentmethods;

/**
 * Interface defining the contract for payment method strategies.
 * 
 * Design Pattern: Strategy Pattern
 * This interface allows different payment methods (Credit Card, Cash, Digital Wallet, etc.)
 * to be plugged into the Payment class dynamically.
 * 
 * Implementations:
 * - CreditCardPayment: Handle credit/debit card transactions
 * - CashPayment: Handle cash payments
 * - (Can add: DigitalWalletPayment, CryptocurrencyPayment, etc.)
 * 
 * Benefits:
 * 1. Decouples payment processing logic from the main Payment class
 * 2. Allows adding new payment methods without modifying existing code
 * 3. Each payment method can have its own validation and processing logic
 * 4. Supports runtime selection of payment methods
 * 
 * IMPROVEMENTS:
 * 1. Add return value for payment status (success/failure/pending)
 * 2. Add exception handling for failed payments
 * 3. Add transaction ID generation and return
 * 4. Add receipt generation
 * 5. Add refund capability
 */
public interface PaymentStrategy {
    
    /**
     * Processes a payment using the specific payment method.
     * Implementation should handle all method-specific logic:
     * - Validation of payment details
     * - Connection to payment processors
     * - Error handling and reporting
     * 
     * @param amount The amount to be charged (in dollars)
     * @throws PaymentException if payment processing fails
     */
    void processPayment(double amount);
    
    /**
     * Returns the name/description of the payment method.
     * Useful for logging, receipts, and user communication.
     * 
     * @return A descriptive string identifying the payment method
     *         (e.g., "Credit Card", "Cash", "Digital Wallet")
     */
    String getPaymentMethod();
}
