package org.stateDesignPattern;

/**
 * TrafficLightState interface - Defines the contract for all state implementations.
 * The State Pattern is a behavioral design pattern that allows an object to alter its behavior
 * when its internal state changes. The object will appear to change its class.
 * Key Concepts:
 * - Each state is represented by a concrete class implementing this interface
 * - The context object delegates state-specific behavior to the current state object
 * - States can transition to other states by modifying the context's current state
 * - This pattern encapsulates state-specific behavior and eliminates large conditional statements
 * Benefits:
 * 1. Simplifies complex state machine logic
 * 2. Makes state transitions explicit
 * 3. Easier to add new states without modifying existing code
 * 4. Each state encapsulates its own behavior
 * 5. Eliminates switch/if-else statements for handling different states
 */
public interface TrafficLightState {
    
    /**
     * Transitions to the next state.
     * Each concrete state knows what state to transition to next.
     * 
     * @param context The context object that holds the current state
     */
    void next(TrafficLightContext context);
    
    /**
     * Returns the color representation of this state.
     * 
     * @return A string representing the color of this traffic light state
     */
    String getColor();
}
