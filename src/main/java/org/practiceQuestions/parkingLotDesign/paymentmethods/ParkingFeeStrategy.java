package org.practiceQuestions.parkingLotDesign.paymentmethods;

/**
 * Interface defining the contract for parking fee calculation strategies.
 * 
 * Design Pattern: Strategy Pattern
 * This interface allows different pricing algorithms to be plugged into Vehicle
 * objects dynamically, enabling flexible and runtime-configurable fee calculations.
 * 
 * Implementations:
 * - BasicHourlyRateStrategy: Simple per-hour rate based on vehicle type
 * - PremiumRateStrategy: Base fee + hourly rate combination
 * - (Can add: TimeBasedStrategy, MonthlySubscriptionStrategy, etc.)
 * 
 * Benefits of Strategy Pattern:
 * 1. Encapsulates different fee calculation algorithms
 * 2. Makes it easy to switch strategies at runtime
 * 3. Allows adding new pricing strategies without modifying existing code
 * 4. Supports dynamic pricing adjustments (peak hours, discounts, etc.)
 * 
 * IMPROVEMENTS:
 * 1. Could add startTime and endTime parameters for time-based pricing
 * 2. Could return object with fee breakdown (base, hourly, discounts, taxes)
 * 3. Could add validation to prevent negative durations
 * 4. Could support seasonal/promotional pricing
 */
public interface ParkingFeeStrategy {
    
    /**
     * Calculates the parking fee based on vehicle type and duration.
     * Different implementations can use different algorithms for fee calculation.
     * 
     * @param vehicleType The type of vehicle (Car, Bike, Truck, etc.)
     * @param durationInHours The duration of parking in hours
     * @return The calculated parking fee in dollars
     * 
     * IMPROVEMENT: Consider validating parameters:
     * - vehicleType should not be null
     * - durationInHours should be positive
     * - Consider returning BigDecimal for precise money calculations instead of double
     */
    public double calculateFee(String vehicleType, double durationInHours);
}
