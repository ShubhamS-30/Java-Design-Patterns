package org.practiceQuestions.parkingLotDesign.paymentmethods;

/**
 * Concrete implementation of ParkingFeeStrategy using premium pricing model.
 * 
 * Design Pattern: Strategy Pattern (Concrete Strategy)
 * Implements a premium pricing model with:
 * Fee = Base Fee + (Hourly Rate × Duration in Hours)
 * 
 * This model is suitable for:
 * - Premium/VIP parking spots
 * - Preferred location parking
 * - High-value vehicle insurance
 * - Valet parking services
 * 
 * Current Rates:
 * - Base Fee: $5.00 (covers administrative overhead and spot reservation)
 * - Hourly Rate: $7.00 per hour
 * 
 * IMPROVEMENTS:
 * 1. Make base fee and hourly rates configurable
 * 2. Add tiered pricing (first hour premium, then standard)
 * 3. Add duration-based discounts (long-term parking)
 * 4. Support daily/weekly/monthly caps
 * 5. Add loyalty program discounts
 * 6. Add time-based surcharges (peak hours)
 */
public class PremiumRateStrategy implements ParkingFeeStrategy{

    /** Base fee charged regardless of parking duration */
    private static final double BASE_FEE = 5.0;
    
    /** Hourly rate for premium parking */
    private static final double HOURLY_RATE = 7.0;

    /**
     * Calculates parking fee using premium pricing model.
     * Charges a flat base fee plus hourly rate for duration.
     * This model ensures minimum revenue per parking transaction.
     * 
     * Formula: Fee = $5.00 + ($7.00 × duration in hours)
     * 
     * Example calculations:
     * - 1 hour: $5 + ($7 × 1) = $12
     * - 2 hours: $5 + ($7 × 2) = $19
     * - 3 hours: $5 + ($7 × 3) = $26
     * 
     * @param vehicleType The type of vehicle (currently unused in premium model)
     * @param durationInHours The parking duration in hours
     * @return The calculated premium parking fee
     */
    @Override
    public double calculateFee(String vehicleType, double durationInHours) {
        // Premium model: base charge + hourly rate
        // Note: Unlike BasicHourlyRateStrategy, this ignores vehicle type
        // IMPROVEMENT: Could make fees vehicle-type dependent for better differentiation
        return BASE_FEE + (HOURLY_RATE * durationInHours);
    }

    /**
     * Returns the base fee for premium parking.
     * 
     * IMPROVEMENT: Make configurable via configuration file
     * 
     * @return The flat base fee in dollars
     */
    private static double getBaseFee() {
        return BASE_FEE;
    }

    /**
     * Returns the hourly rate for premium parking.
     * 
     * IMPROVEMENT: Make configurable via configuration file or database
     * 
     * @return The hourly rate in dollars
     */
    private static double getHourlyRate() {
        return HOURLY_RATE;
    }
}
