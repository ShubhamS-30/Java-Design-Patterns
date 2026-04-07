package org.chainOfResponsiblityPattern;

/**
 * Abstract base class defining the handler in the Chain of Responsibility pattern.
 * This class acts as the component in the chain that receives requests and either
 * handles them or passes them to the next handler in the chain. Each concrete approver
 * will extend this class and implement specific approval logic.
 * Pattern Benefits:
 * - Decouples request sender from receivers
 * - Allows multiple handlers to process a request without knowing about each other
 * - Provides flexibility to add/remove handlers at runtime
 */
abstract class Approver {
    // Reference to the next handler in the chain
    protected Approver nextApprover;

    /**
     * Sets the next approver in the chain.
     * This method dynamically builds the chain of responsibility at runtime.
     * 
     * @param nextApprover The next handler to process the request if current handler cannot
     */
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    /**
     * Abstract method to process leave requests.
     * Each concrete approver will implement their own approval logic.
     * 
     * @param requestDays The number of days of leave requested
     */
    public abstract void processLeaveRequest(int requestDays);
}
