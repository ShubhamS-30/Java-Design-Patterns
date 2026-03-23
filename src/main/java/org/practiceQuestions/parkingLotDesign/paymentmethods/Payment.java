package org.practiceQuestions.parkingLotDesign.paymentmethods;

/**
 * Payment processing class that delegates actual payment processing to strategy objects.
 * 
 * Design Pattern: Strategy Pattern (Context)
 * This class acts as the context that uses different payment strategies.
 * It encapsulates the payment processing flow while delegating method-specific
 * processing to the concrete strategy implementation.
 * 
 * Responsibilities:
 * - Store payment amount and selected payment method
 * - Validate payment amount
 * - Delegate payment processing to the appropriate strategy
 * - Provide user feedback on payment status
 * 
 * Key Features:
 * - Flexible payment method support via composition
 * - Easy to add new payment methods without modifying this class
 * - Validation of payment amount before processing
 * - Clear separation of concerns
 * 
 * IMPROVEMENTS:
 * 1. Add return type indicating success/failure/pending status
 * 2. Add exception handling for failed payment scenarios
 * 3. Track transaction ID and payment timestamp
 * 4. Add transaction receipt generation
 * 5. Support refund and cancellation operations
 * 6. Add payment status tracking and inquiry capabilities
 * 7. Consider using enums for payment status
 */
public class Payment {
    /** The amount to be charged for parking */
    private double amount;
    
    /** The payment method strategy to use for processing */
    private PaymentStrategy paymentStrategy;

    /**
     * Constructor to initialize a payment with amount and payment method.
     * 
     * @param amount The parking fee amount to be charged (in dollars)
     * @param paymentStrategy The payment method strategy to use
     */
    public Payment(double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Processes the payment using the assigned payment strategy.
     * Validates the payment amount before processing to ensure validity.
     * 
     * Processing Flow:
     * 1. Check if amount is positive (valid)
     * 2. If valid: Delegate to paymentStrategy.processPayment()
     * 3. If invalid: Inform user that no payment is required
     * 
     * IMPROVEMENT: Consider these enhancements:
     * - Return boolean indicating success/failure
     * - Throw PaymentException for error handling
     * - Track transaction details (ID, timestamp, receipt)
     * - Support partial payments or payment plans
     * - Add receipt generation and email capability
     */
    public void processPayment() {
        if(this.amount > 0){
            // Valid payment amount - process using the strategy
            paymentStrategy.processPayment(amount);
            System.out.println("Payment of $" + amount + " processed successfully.");
        }
        else {
            // No payment required (free parking, grace period, etc.)
            System.out.println("No payment required.");
        }
    }
}
