package org.strategyDesignPattern.payment;

/**
 * CLIENT: Strategy Pattern Demonstration
 * This class demonstrates the practical usage of the Strategy Design Pattern
 * in a real-world payment processing scenario.
 * How the Strategy Pattern Works Here:
 * ====================================
 * 1. STRATEGY INTERFACE:
 *    - PaymentStrategy: Defines the common interface for all payment methods
 *    - All payment methods implement this interface
 * 2. CONCRETE STRATEGIES:
 *    - CreditCardPayment: Strategy for credit card payments
 *    - DebitCardPayment: Strategy for debit card payments
 *    - Apple Pay: Strategy for Apple Pay payments
 *    - StripePayment: Strategy for Stripe payments
 *    Each has its own payment algorithm/implementation
 * 3. CONTEXT:
 *    - PaymentProcessor: The context that uses the strategies
 *    - Accepts any PaymentStrategy in its constructor
 *    - Can change strategy at runtime using setPaymentStrategy()
 *    - Delegates payment processing to the current strategy
 * Key Benefits Demonstrated:
 * ===========================
 * - Adding new payment methods doesn't require modifying PaymentProcessor
 * - Payment algorithms are encapsulated in separate classes
 * - Easy to switch between payment methods at runtime
 * - Easy to test each payment strategy independently
 * - Follows Open/Closed Principle (Open for extension, closed for modification)
 * - Follows Single Responsibility Principle (Each class has one reason to change)
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("===== STRATEGY DESIGN PATTERN - PAYMENT PROCESSING =====\n");
        
        // STEP 1: Create PaymentProcessor with initial strategy (Apple Pay)
        // The client doesn't care which concrete strategy is used
        // It only cares about the PaymentStrategy interface
        System.out.println("--- Step 1: Initial Strategy (ApplePay) ---");
        PaymentProcessor paymentProcessor = new PaymentProcessor(new ApplePay());
        paymentProcessor.processPayment(100.0);
        System.out.println();
        
        // STEP 2: Change strategy to StripePayment at runtime
        // This demonstrates the flexibility of the Strategy pattern
        // No changes needed to PaymentProcessor, Client simply calls setPaymentStrategy()
        System.out.println("--- Step 2: Runtime Strategy Change (StripePayment) ---");
        paymentProcessor.setPaymentStrategy(new StripePayment());
        paymentProcessor.processPayment(200.0);
        System.out.println();
        
        // ADDITIONAL EXAMPLES: You can add more strategies as needed
        // This shows how easy it is to extend with new payment methods
        System.out.println("--- Step 3: Using CreditCardPayment ---");
        paymentProcessor.setPaymentStrategy(new CreditCardPayment());
        paymentProcessor.processPayment(150.0);
        System.out.println();
        
        System.out.println("--- Step 4: Using DebitCardPayment ---");
        paymentProcessor.setPaymentStrategy(new DebitCardPayment());
        paymentProcessor.processPayment(250.0);
        System.out.println();
        
        System.out.println("===== KEY TAKEAWAYS =====");
        System.out.println("1. PaymentProcessor doesn't change - only the strategy changes");
        System.out.println("2. New payment methods can be added without modifying existing code");
        System.out.println("3. Each payment method's logic is isolated in its own class");
        System.out.println("4. Easy to test each strategy independently");
        System.out.println("5. Runtime flexibility: Strategies can be switched on the fly");
    }
}
