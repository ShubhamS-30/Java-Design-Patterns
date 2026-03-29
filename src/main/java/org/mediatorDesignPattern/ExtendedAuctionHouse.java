package org.mediatorDesignPattern;

/**
 * ExtendedAuctionHouse Class - Extended Mediator Implementation
 * This class extends the basic AuctionHouse mediator with time-based bidding constraints.
 * It demonstrates the Open/Closed Principle by extending existing functionality without
 * modifying the original AuctionHouse class.
 * Additional Responsibilities:
 * - Enforces a bidding deadline/time window
 * - Rejects bids placed after the bidding end time
 * - Maintains all original mediator functionality
 * This is a good example of how the Mediator pattern allows for flexible extension
 * of business rules without affecting the existing implementation.
 */
public class ExtendedAuctionHouse extends AuctionHouse {
    
    /**
     * The timestamp when bidding is scheduled to end.
     * Stored as milliseconds since epoch for comparison with current time.
     */
    private long biddingEndTime;

    /**
     * Constructor that initializes the extended auction house with a bidding deadline.
     * 
     * @param biddingEndTime The time (in milliseconds since epoch) when bidding should end
     *                       Example: System.currentTimeMillis() + 5000 (5 seconds from now)
     */
    public ExtendedAuctionHouse(long biddingEndTime) {
        this.biddingEndTime = biddingEndTime;
    }

    /**
     * Updates the bidding end time dynamically.
     * This allows the auction to be extended or shortened if needed.
     * 
     * @param biddingEndTime The new bidding end time in milliseconds
     */
    public void setBiddingEndTime(long biddingEndTime) {
        this.biddingEndTime = biddingEndTime;
    }

    /**
     * Overrides the placeBid method to add time-based validation.
     * Process:
     * 1. Gets the current system time in milliseconds
     * 2. Checks if current time is within the bidding window
     * 3. If valid: delegates to parent class (AuctionHouse) to process the bid normally
     * 4. If expired: rejects the bid and informs the bidder
     * This demonstrates how the Mediator pattern allows extending behavior
     * while maintaining the original interface contract.
     * 
     * @param amount The bid amount
     * @param bidder The bidder placing the bid
     */
    @Override
    public void placeBid(int amount, Bidder bidder) {
        // Get the current time in milliseconds
        long currentTime = System.currentTimeMillis();
        
        // Check if the current time is within the bidding window
        if (currentTime <= biddingEndTime) {
            // If bidding is still open, process the bid normally through parent class
            super.placeBid(amount, bidder);
        } else {
            // If bidding has closed, reject the bid and notify the bidder
            System.out.println("Bidding has ended. " + bidder.getName() + " cannot place a bid of $" + amount);
        }
    }
}
