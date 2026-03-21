package org.strategyDesignPattern.payment;

/**
 * CONTEXT: PaymentProcessor
 * This is the Context class in the Strategy Design Pattern.
 * Role in Strategy Pattern:
 * - Context: Uses a PaymentStrategy to perform payment operations
 * - Holds a reference to the PaymentStrategy interface (not concrete implementations)
 * - Delegates payment processing to the strategy object
 * - Allows runtime switching between different payment strategies
 * - Does NOT depend on concrete payment implementations
 * Key Advantages:
 * - Decouples payment logic from the processor
 * - Easy to add new payment methods without modifying this class
 * - Payment algorithms are interchangeable
 * - Follows Open/Closed Principle: Open for extension, closed for modification
 * - Single Responsibility: Handles payment orchestration, not payment details
 * Pattern Flow:
 * 1. Client creates PaymentProcessor with initial strategy (e.g., ApplePay)
 * 2. Client calls processPayment() which delegates to the strategy
 * 3. Strategy executes its specific payment algorithm
 * 4. Client can change strategy using setPaymentStrategy() at any time
 * 5. Subsequent calls use the new strategy
 */
public class PaymentProcessor {
    
    // Strategy reference: Holds reference to the PaymentStrategy interface
    // NOT to any concrete implementation. This allows interchangeability.
    private PaymentStrategy paymentStrategy;

    /**
     * Constructor with strategy injection.
     * This enforces that a PaymentProcessor must always have a valid strategy.
     * Follows dependency injection principle.
     * 
     * @param paymentStrategy The payment strategy to use for processing payments
     */
    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Change the payment strategy at runtime.
     * This is one of the key features of the Strategy pattern.
     * The same processor can handle different payment methods without modification.
     * Example:
     * processor.setPaymentStrategy(new CreditCardPayment());
     * processor.processPayment(100.0);
     * processor.setPaymentStrategy(new ApplePay());
     * processor.processPayment(200.0);
     * 
     * @param paymentStrategy The new payment strategy to use
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Process payment using the current strategy.
     * This method delegates to the strategy's processPayment() method.
     * The actual payment processing logic is encapsulated in the strategy.
     * Note: This method does NOT know which concrete strategy is being used.
     * It only knows about the PaymentStrategy interface.
     * 
     * @param amount The amount to be processed
     */
    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}
