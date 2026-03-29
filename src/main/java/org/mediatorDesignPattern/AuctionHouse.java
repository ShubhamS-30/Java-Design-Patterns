package org.mediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * AuctionHouse Class - Concrete Mediator Implementation
 * This class is the concrete implementation of the AuctionMediator interface.
 * It acts as the central mediator that coordinates all communication between bidders.
 * Responsibilities:
 * - Maintains a list of registered bidders
 * - Handles bid placement and forwards notifications to other bidders
 * - Ensures bidders don't communicate directly with each other
 * The AuctionHouse encapsulates the interaction logic and enforces rules
 * for how bidders are notified about bids placed by others.
 */
public class AuctionHouse implements AuctionMediator {
    // List to store all registered bidders participating in the auction
    List<Bidder> bidders = new ArrayList<>();

    /**
     * Registers a bidder with the auction house.
     * The registered bidder will be notified whenever other bidders place bids.
     * 
     * @param bidder The bidder to register for participation in the auction
     */
    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    /**
     * Processes a bid placement and notifies all other bidders.
     * This method implements the core mediator logic:
     * 1. Iterates through all registered bidders
     * 2. Excludes the bidder who placed the current bid
     * 3. Notifies all other bidders about the bid
     * This way, bidders don't need to know about each other directly;
     * the mediator handles all communication.
     * 
     * @param amount The bid amount placed by the bidder
     * @param bidder The bidder who placed the bid
     */
    @Override
    public void placeBid(int amount, Bidder bidder) {
        // Notify all other bidders (except the one who placed the bid) about this bid
        for (Bidder b : bidders) {
            if (b != bidder) {
                b.receiveBid(amount, bidder);
            }
        }
    }
}
