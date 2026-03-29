package org.mediatorDesignPattern;

/**
 * AuctionMediator Interface
 * This interface defines the contract for the Mediator in the Mediator Design Pattern.
 * The mediator acts as a centralized hub that coordinates communication between multiple
 * bidders in an auction system, preventing direct communication between bidders.
 * Key Responsibilities:
 * - Manage registration of bidders
 * - Facilitate bid placement and notification of other bidders
 * Benefits:
 * - Decouples bidders from each other
 * - Centralizes business logic for auction rules
 * - Makes the system easier to maintain and extend
 */
public interface AuctionMediator {
    /**
     * Registers a bidder with the auction mediator.
     * This allows the mediator to track active bidders and notify them of bids.
     * 
     * @param bidder The bidder to be registered in the auction
     */
    void registerBidder(Bidder bidder);

    /**
     * Processes a bid placement by a bidder.
     * The mediator notifies all other bidders about this bid without the bidder
     * having direct knowledge of other bidders.
     * 
     * @param amount The bid amount
     * @param bidder The bidder placing the bid
     */
    void placeBid(int amount, Bidder bidder);
}
