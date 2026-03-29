package org.mediatorDesignPattern;

/**
 * Bidder Class - Colleague in the Mediator Design Pattern
 * This class represents a participant (colleague) in the auction system.
 * Each bidder communicates with other bidders only through the AuctionMediator,
 * promoting loose coupling between bidders.
 * Key Characteristics:
 * - Does not have direct references to other bidders
 * - Communicates exclusively through the mediator
 * - Notified of other bidders' actions via the mediator
 * - Reduces dependencies and makes the system more maintainable
 */
public class Bidder {
    // The bidder's name for identification
    private String name;
    
    // Reference to the mediator for all communication
    private AuctionMediator mediator;

    /**
     * Constructor to create a bidder with a name and mediator reference.
     * 
     * @param name     The name of the bidder
     * @param mediator The auction mediator through which this bidder communicates
     */
    public Bidder(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    /**
     * Gets the name of the bidder.
     * 
     * @return The name of this bidder
     */
    public String getName() {
        return name;
    }

    /**
     * Places a bid through the mediator.
     * This method demonstrates how the bidder doesn't communicate directly
     * with other bidders. Instead, it delegates to the mediator to handle
     * the bid notification logic.
     * 
     * @param amount The amount being bid
     */
    public void placeBid(int amount) {
        System.out.println(name + " places a bid of $" + amount);
        // Delegate to mediator - the bidder doesn't need to know other bidders
        mediator.placeBid(amount, this);
    }

    /**
     * Receives notification of a bid placed by another bidder.
     * This method is called by the mediator to notify this bidder about
     * bids placed by others. The bidder is unaware of how the mediator
     * obtained this information or how many other bidders are involved.
     * 
     * @param amount The bid amount placed by the other bidder
     * @param bidder The bidder who placed the bid
     */
    public void receiveBid(int amount, Bidder bidder){
        System.out.println(name + " is notified. " + bidder.getName() + " has placed a bid of $" + amount);
    }
}
