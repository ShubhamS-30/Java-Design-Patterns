package org.stateDesignPattern;

/**
 * Client class - Demonstrates the State Design Pattern in action.
 * The State Pattern is a behavioral design pattern that allows an object to alter its behavior
 * when its internal state changes. The object will appear to change its class.
 * Pattern Components:
 * 1. State Interface - Defines the contract for all states (TrafficLightState)
 * 2. Concrete States - Implement the state interface (RedState, GreenState, YellowState)
 * 3. Context - Maintains state and delegates behavior to current state (TrafficLightContext)
 * 4. Client - Uses the context object and triggers state changes
 * In this example:
 * - The traffic light starts in RED state
 * - Each call to change() transitions to the next state: Red -> Green -> Yellow -> Red (cycles)
 * - The context object handles the transitions transparently
 * - Client doesn't need to know about specific states or implement transition logic
 * Key Benefits:
 * - Simplifies state machine implementation
 * - Eliminates complex if-else or switch statements
 * - Makes it easy to add new states
 * - Each state encapsulates its own behavior
 * - State transitions are explicit and clear
 */
public class Client {
    public static void main(String[] args) {
        
        // Create a traffic light context
        // The traffic light starts in RED state automatically
        TrafficLightContext trafficLight = new TrafficLightContext();

        // Iterate 6 times to demonstrate the state transition cycle
        // The traffic light will cycle through: Red -> Green -> Yellow -> Red -> Green -> Yellow
        for (int i = 0; i < 6; i++) {
            // Display the current color of the traffic light
            System.out.println("i = " + i + " Current Traffic Light: " + trafficLight.getCurrentColor());
            
            // Change the traffic light state to the next state
            // The actual transition logic is handled by the concrete state objects
            // Client just calls change() and doesn't need to know the details
            trafficLight.change();
        }
    }
}
