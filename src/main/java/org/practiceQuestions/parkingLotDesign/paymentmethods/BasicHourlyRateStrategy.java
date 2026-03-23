package org.practiceQuestions.parkingLotDesign.paymentmethods;

/**
 * Concrete implementation of ParkingFeeStrategy using basic hourly rates.
 * 
 * Design Pattern: Strategy Pattern (Concrete Strategy)
 * Implements a simple pricing model where fees are calculated as:
 * Fee = Hourly Rate * Duration in Hours
 * 
 * Pricing Structure:
 * - Car: $5.00 per hour
 * - Bike: $2.00 per hour
 * - Truck: $10.00 per hour
 * - Other: $7.00 per hour (default)
 * 
 * IMPROVEMENTS:
 * 1. Add grace period (e.g., first 15 minutes free)
 * 2. Add bulk discount (e.g., reduced rate after 8 hours)
 * 3. Make rates configurable via properties file instead of hardcoded
 * 4. Add time-based pricing (peak vs off-peak hours)
 * 5. Support monthly passes or subscription discounts
 * 6. Add minimum fee threshold (e.g., $2 minimum even for short durations)
 */
public class BasicHourlyRateStrategy implements ParkingFeeStrategy{

    /**
     * Calculates parking fee using a simple hourly rate model.
     * Applies vehicle-type-specific rates for fair pricing.
     * 
     * @param vehicleType The type of vehicle (Car, Bike, Truck, Other)
     * @param durationInHours The parking duration in hours
     * @return The calculated parking fee (rate per hour × duration)
     */
    @Override
    public double calculateFee(String vehicleType, double durationInHours) {
        // Get the rate per hour based on vehicle type
        double ratePerHour = getRatePerHour(vehicleType);
        
        // Simple calculation: rate × duration
        return ratePerHour * durationInHours;
    }

    /**
     * Returns the hourly parking rate for a specific vehicle type.
     * Different vehicle types have different parking space requirements,
     * hence they are charged at different rates.
     * 
     * IMPROVEMENT: Load these rates from a configuration file or database
     * for easy updates without code changes.
     * 
     * @param vehicleType The type of vehicle
     * @return The hourly rate in dollars for this vehicle type
     */
    private double getRatePerHour(String vehicleType) {
        return switch (vehicleType.toLowerCase()) {
            // Motorcycles and bikes require minimal space
            case "bike" -> 2.0;
            
            // Standard cars require standard parking space
            case "car" -> 5.0;
            
            // Trucks require large parking spaces
            case "truck" -> 10.0;
            
            // Default rate for unknown or other vehicle types
            default -> 7.0;
        };
    }
}
