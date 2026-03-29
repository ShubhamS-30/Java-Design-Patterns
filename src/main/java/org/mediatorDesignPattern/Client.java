package org.mediatorDesignPattern;

/**
 * Client Class - Demonstrates the Mediator Design Pattern
 * This class showcases how the Mediator pattern works in a real-world auction system.
 * Key Concepts Demonstrated:
 * - Multiple bidders communicating through a central mediator (AuctionHouse)
 * - Loose coupling between bidders
 * - Centralized business logic for auction rules
 * - Extended functionality (time-based bidding) without modifying existing code
 * Pattern Benefits in This Example:
 * 1. Bidders don't need to know about each other
 * 2. The mediator encapsulates bidding logic
 * 3. New bidding rules can be added by extending the mediator
 * 4. System is easier to test and maintain
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        // Create an extended auction house with a bidding time window
        // The bidding will end 5 seconds from the current time
        AuctionMediator mediator = new ExtendedAuctionHouse(System.currentTimeMillis() + 5000);

        // Create three bidders
        // Notice: Bidders are created with a reference to the mediator
        // They don't have references to each other
        Bidder bidder1 = new Bidder("Alice", mediator);
        Bidder bidder2 = new Bidder("Bob", mediator);
        Bidder bidder3 = new Bidder("Charlie", mediator);

        // Register all bidders with the mediator
        // This allows the mediator to track who is participating and notify them of bids
        mediator.registerBidder(bidder1);
        mediator.registerBidder(bidder2);
        mediator.registerBidder(bidder3);

        // Simulate the auction process with timed bids
        
        // Alice places the first bid (at time 0)
        bidder1.placeBid(100);
        
        // Simulate a 2-second delay before Bob's bid
        Thread.sleep(2000);
        
        // Bob places a bid (at time 2 seconds)
        bidder2.placeBid(150);
        
        // Simulate a 4-second delay - total elapsed time will be 6 seconds
        // This exceeds the 5-second bidding window
        Thread.sleep(4000);
        
        // Charlie tries to place a bid (at time 6 seconds)
        // This bid will be REJECTED because the bidding window has closed
        // Notice: The mediator (ExtendedAuctionHouse) makes this decision, not the bidder
        bidder3.placeBid(200);
        
        /*
         * Expected Output:
         * 1. Alice places a bid of $100
         * 2. Bob receives notification about Alice's bid
         * 3. Charlie receives notification about Alice's bid
         * 4. Bob places a bid of $150
         * 5. Alice receives notification about Bob's bid
         * 6. Charlie receives notification about Bob's bid
         * 7. Charlie tries to place a bid of $200 - REJECTED
         */
    }
}
