package org.chainOfResponsiblityPattern;

/**
 * Concrete handler: Supervisor level approver in the Chain of Responsibility pattern.
 * The Supervisor is the first level in the approval chain.
 * It can approve leave requests up to 3 days.
 * For requests exceeding 3 days, it forwards the request to the next handler (Manager).
 * This demonstrates how each handler in the chain has a specific responsibility
 * and knows when to pass the request to the next handler.
 */
public class Supervisor extends Approver {
    
    /**
     * Processes leave requests at the Supervisor level.
     * Decision Logic:
     * - If request days <= 3: Supervisor approves and handles the request
     * - If request days > 3: Supervisor cannot approve, forwards to next handler (Manager)
     * This is the core principle of Chain of Responsibility: each handler decides
     * whether it can handle the request or pass it along the chain.
     * 
     * @param requestDays The number of days of leave requested
     */
    @Override
    public void processLeaveRequest(int requestDays) {
        // Supervisor's approval limit is 3 days
        if (requestDays <= 3) {
            System.out.println("Supervisor approved leave request for " + requestDays + " days.");
        } else {
            // Cannot approve - forward to the next approver in the chain
            System.out.println("Supervisor cannot approve leave request for " + requestDays + " days. Forwarding to next approver.");
            // Check if there is a next approver before passing the request
            if (nextApprover != null) {
                nextApprover.processLeaveRequest(requestDays);
            }
        }
    }
}
