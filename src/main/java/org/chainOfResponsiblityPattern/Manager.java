package org.chainOfResponsiblityPattern;

/**
 * Concrete handler: Manager level approver in the Chain of Responsibility pattern.
 * The Manager is the second level in the approval chain.
 * It can approve leave requests up to 7 days.
 * For requests exceeding 7 days, it forwards the request to the next handler (Director).
 * Notice how each handler has a higher authority than the previous one,
 * allowing increasingly larger requests to be approved at higher levels.
 */
public class Manager extends Approver {
    
    /**
     * Processes leave requests at the Manager level.
     * Decision Logic:
     * - If request days <= 7: Manager approves and handles the request
     * - If request days > 7: Manager cannot approve, forwards to next handler (Director)
     * This handler only gets called if the previous handler (Supervisor)
     * could not handle the request, demonstrating the chain delegation pattern.
     * 
     * @param requestDays The number of days of leave requested
     */
    @Override
    public void processLeaveRequest(int requestDays) {
        // Manager's approval limit is 7 days
        if (requestDays <= 7) {
            System.out.println("Manager approved leave request for " + requestDays + " days.");
        } else {
            // Cannot approve - forward to the next approver in the chain
            System.out.println("Manager cannot approve leave request for " + requestDays + " days. Forwarding to next approver.");
            // Check if there is a next approver before passing the request
            if (nextApprover != null) {
                nextApprover.processLeaveRequest(requestDays);
            }
        }
    }
}
