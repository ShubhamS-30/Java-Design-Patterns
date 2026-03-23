package org.practiceQuestions.parkingLotDesign;

import org.practiceQuestions.parkingLotDesign.parkinglot.BikeParkingSpot;
import org.practiceQuestions.parkingLotDesign.parkinglot.CarParkingSpot;
import org.practiceQuestions.parkingLotDesign.parkinglot.ParkingLot;
import org.practiceQuestions.parkingLotDesign.parkinglot.ParkingSpot;
import org.practiceQuestions.parkingLotDesign.paymentmethods.*;
import org.practiceQuestions.parkingLotDesign.vehicles.Vehicle;
import org.practiceQuestions.parkingLotDesign.vehicles.VehicleFactory;

import java.util.List;

/**
 * Client class demonstrating the Parking Lot System design.
 * DESIGN PATTERNS DEMONSTRATED:
 * 1. FACTORY PATTERN (VehicleFactory)
 *    - Creates different vehicle types without exposing creation logic
 *    - Benefits: Decoupling, easy to add new vehicle types
 * 2. STRATEGY PATTERN (ParkingFeeStrategy, PaymentStrategy)
 *    - ParkingFeeStrategy: Different pricing algorithms (BasicHourly vs Premium)
 *    - PaymentStrategy: Different payment methods (CreditCard vs Cash)
 *    - Benefits: Runtime algorithm selection, easy to add new strategies
 * 3. TEMPLATE METHOD PATTERN (ParkingSpot abstract class)
 *    - Defines structure of parking validation in abstract canPark()
 *    - Subclasses implement type-specific validation
 *    - Benefits: Code reuse, consistent behavior
 * 4. FACADE PATTERN (ParkingLot class)
 *    - Simplifies complex parking spot management
 *    - Provides clean interface for parking operations
 *    - Benefits: Reduced complexity for clients
 * 5. OBJECT COMPOSITION (Vehicle with ParkingFeeStrategy)
 *    - Assembles different fee strategies into vehicles
 *    - Benefits: Flexibility, avoids inheritance explosion
 * WORKFLOW DEMONSTRATION:
 * Step 1: Setup
 *   - Create ParkingLot with predefined spots (Cars and Bikes)
 *   - Initialize empty lot with mixed spot types
 * Step 2: Vehicle Creation
 *   - Use VehicleFactory to create different vehicle types
 *   - Each vehicle gets assigned a pricing strategy
 *   - Examples: BasicHourlyRateStrategy vs PremiumRateStrategy
 * Step 3: Parking
 *   - ParkingLot finds appropriate spot for vehicle type
 *   - Validates vehicle compatibility with spot
 *   - Updates spot occupancy status
 * Step 4: Payment
 *   - Calculate parking fee using vehicle's fee strategy
 *   - Process payment using selected payment method
 *   - Update parking records
 * Step 5: Vacation
 *   - Remove vehicle from spot
 *   - Mark spot as available for next vehicle
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== PARKING LOT MANAGEMENT SYSTEM ===\n");
        
        // STEP 1: Initialize Parking Lot
        // Create a parking lot with different types of parking spots
        // This demonstrates the Facade pattern - a single interface for complex operations
        System.out.println("Step 1: Creating Parking Lot...");
        ParkingLot parkingLot = new ParkingLot(List.of(
                new BikeParkingSpot(1),    // Spot 1: Bike
                new CarParkingSpot(2),     // Spot 2: Car
                new CarParkingSpot(3),     // Spot 3: Car
                new BikeParkingSpot(4)     // Spot 4: Bike
        ));
        System.out.println("Parking Lot Created with 4 spots (2 cars, 2 bikes)\n");

        // STEP 2: Create Vehicles using Factory Pattern
        // VehicleFactory abstracts vehicle creation and returns appropriate type
        System.out.println("Step 2: Creating Vehicles (using Factory Pattern)...");
        
        // Car 1: Using BasicHourlyRateStrategy ($5/hour for cars)
        Vehicle car = VehicleFactory.createVehicle("car", "ABC123", new BasicHourlyRateStrategy());
        
        // Bike: Using PremiumRateStrategy ($5 base + $7/hour)
        Vehicle bike = VehicleFactory.createVehicle("bike", "XYZ789", new PremiumRateStrategy());
        
        // Car 2: Using BasicHourlyRateStrategy
        Vehicle car1 = VehicleFactory.createVehicle("car", "ABC124", new BasicHourlyRateStrategy());
        
        // Car 3: Using BasicHourlyRateStrategy
        Vehicle car2 = VehicleFactory.createVehicle("car", "ABC125", new BasicHourlyRateStrategy());
        System.out.println("Vehicles Created: 1 Bike, 3 Cars\n");

        // STEP 3: Park Vehicles
        // ParkingLot.parkVehicle() uses Template Method pattern
        // Each spot implements type-specific canPark() validation
        System.out.println("Step 3: Parking Vehicles...");
        ParkingSpot carSpot = parkingLot.parkVehicle(car);
        ParkingSpot bikeSpot = parkingLot.parkVehicle(bike);
        ParkingSpot carSpot1 = parkingLot.parkVehicle(car1);
        ParkingSpot carSpot2 = parkingLot.parkVehicle(car2);
        System.out.println();

        // STEP 4: Process Payments
        // Demonstrates Strategy Pattern for both fee calculation and payment processing
        System.out.println("Step 4: Processing Payments (using Strategy Pattern)...\n");
        
        // Payment 1: Car parked for 20 hours with Credit Card
        if (carSpot != null) {
            // Use vehicle's fee strategy to calculate parking fee
            double fee = car.getParkingFeeStrategy().calculateFee(car.getType(), 20);
            System.out.println("Car ABC123 - Duration: 20 hours, Fee: $" + fee);
            
            // Use Payment Strategy to process payment
            Payment payment = new Payment(fee, new CreditCardPayment());
            payment.processPayment();
            
            // Vacate the spot to make it available for other vehicles
            parkingLot.vacateSpot(carSpot, car);
            System.out.println();
        }

        // Payment 2: Bike parked for 10 hours with Cash
        if (bikeSpot != null) {
            double fee = bike.getParkingFeeStrategy().calculateFee(bike.getType(), 10);
            System.out.println("Bike XYZ789 - Duration: 10 hours, Fee: $" + fee);
            
            Payment payment = new Payment(fee, new CashPayment());
            payment.processPayment();
            
            parkingLot.vacateSpot(bikeSpot, bike);
            System.out.println();
        }

        // Payment 3: Car parked for 3 hours with Credit Card
        if (carSpot1 != null) {
            double fee = car1.getParkingFeeStrategy().calculateFee(car1.getType(), 3);
            System.out.println("Car ABC124 - Duration: 3 hours, Fee: $" + fee);
            
            Payment payment = new Payment(fee, new CreditCardPayment());
            payment.processPayment();
            
            parkingLot.vacateSpot(carSpot1, car1);
            System.out.println();
        }

        // Payment 4: Car parked for 1 hour with Credit Card
        if (carSpot2 != null) {
            double fee = car2.getParkingFeeStrategy().calculateFee(car2.getType(), 1);
            System.out.println("Car ABC125 - Duration: 1 hour, Fee: $" + fee);
            
            Payment payment = new Payment(fee, new CreditCardPayment());
            payment.processPayment();
            
            parkingLot.vacateSpot(carSpot2, car2);
            System.out.println();
        }
        
        System.out.println("=== All Transactions Completed ===");
    }
}
