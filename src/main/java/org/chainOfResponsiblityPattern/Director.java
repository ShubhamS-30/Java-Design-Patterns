package org.chainOfResponsiblityPattern;

/**
 * Concrete handler: Director level approver in the Chain of Responsibility pattern.
 * The Director is the final (highest) level in the approval chain.
 * It can approve leave requests up to 14 days.
 * For requests exceeding 14 days, the request is denied (no further handlers).
 * The Director acts as the terminal handler - it either approves or rejects the request.
 * There is no next handler to pass the request to, making it the end of the chain.
 */
public class Director extends Approver {
    
    /**
     * Processes leave requests at the Director level.
     * This is the final authority in the approval chain.
     * Decision Logic:
     * - If request days <= 14: Director approves and handles the request
     * - If request days > 14: Director denies the request (end of chain - no more approvers)
     * Since this is the highest level in the chain, the Director has the final say.
     * Requests that reach this level are either approved or rejected.
     * 
     * @param requestDays The number of days of leave requested
     */
    @Override
    public void processLeaveRequest(int requestDays) {
        // Director's approval limit is 14 days (highest authority)
        if (requestDays <= 14) {
            System.out.println("Director approved leave request for " + requestDays + " days.");
        } else {
            // Request exceeds the maximum threshold - no further handlers to escalate to
            System.out.println("Too many days requested: " + requestDays + " days. Request Denied.");
            // Note: Unlike other handlers, Director does NOT forward to nextApprover
            // This is the end of the chain - the final decision is made here
        }
    }
}
