package org.stateDesignPattern;

/**
 * RedState class - A Concrete State implementation.
 * This class represents the RED state of the traffic light.
 * In a traffic light system, Red means "Stop" - vehicles must not proceed.
 * When the traffic light is in the Red state:
 * - Current color is Red
 * - Next state is Green (vehicles can proceed)
 * - The transition happens when change() is called
 * Each concrete state class encapsulates the behavior specific to that state,
 * including knowing what state comes next.
 */
public class RedState implements TrafficLightState {
    
    /**
     * Transitions from Red state to Green state.
     * This method is called when the traffic light needs to change.
     * Red always transitions to Green because that's the sequence: Red -> Green -> Yellow -> Red
     * @param context The traffic light context that will have its state changed
     */
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Changing from Red to Green");
        // Transition to Green state by creating a new GreenState and setting it on the context
        context.setState(new GreenState());
    }

    /**
     * Returns the color representation of the Red state.
     * 
     * @return "Red" - the color of this state
     */
    @Override
    public String getColor() {
        return "Red";
    }
}
