package org.chainOfResponsiblityPattern;

/**
 * Client class demonstrating the Chain of Responsibility design pattern.
 * PATTERN OVERVIEW:
 * The Chain of Responsibility pattern allows an object to send a request that passes
 * through a chain of handlers. Each handler decides either to process the request or
 * to pass it to the next handler in the chain.
 * REAL-WORLD EXAMPLE:
 * This implementation models a leave approval system where:
 * - Supervisor can approve up to 3 days
 * - Manager can approve up to 7 days
 * - Director can approve up to 14 days
 * - Any request beyond 14 days is denied
 * ADVANTAGES:
 * 1. Loose coupling: Sender doesn't need to know who will handle the request
 * 2. Dynamic chain: Can modify the chain at runtime
 * 3. Single Responsibility: Each handler only knows its own logic
 * 4. Open/Closed Principle: Easy to add new handlers without modifying existing ones
 */
public class Client {
    public static void main(String[] args) {
        // Step 1: Create the handlers (approvers)
        // Each represents a different approval level in the hierarchy
        Supervisor supervisor = new Supervisor();
        Manager manager = new Manager();
        Director director = new Director();

        // Step 2: Set up the chain of responsibility
        // The order matters - requests start from the first handler and move down if needed
        supervisor.setNextApprover(manager);   // Supervisor's next is Manager
        manager.setNextApprover(director);     // Manager's next is Director
        // Director has no next approver - it's the final authority

        // Step 3: Test the chain with various leave requests
        // The request will travel through the chain until someone approves it
        
        System.out.println("=== Testing Chain of Responsibility Pattern ===\n");
        
        // Test Case 1: Request within Supervisor's limit (0-3 days)
        System.out.println("Requesting 2 days of leave:");
        supervisor.processLeaveRequest(2);  // Supervisor will handle this

        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test Case 2: Request within Manager's limit (4-7 days)
        // This will be passed from Supervisor to Manager
        System.out.println("Requesting 5 days of leave:");
        supervisor.processLeaveRequest(5);  // Supervisor passes to Manager

        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test Case 3: Request within Director's limit (8-14 days)
        // This will be passed from Supervisor -> Manager -> Director
        System.out.println("Requesting 10 days of leave:");
        supervisor.processLeaveRequest(10);  // Passed through the entire chain

        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test Case 4: Request beyond all limits (> 14 days)
        // Request travels through entire chain and is finally rejected
        System.out.println("Requesting 20 days of leave:");
        supervisor.processLeaveRequest(20);  // Gets rejected at Director level
    }
}
