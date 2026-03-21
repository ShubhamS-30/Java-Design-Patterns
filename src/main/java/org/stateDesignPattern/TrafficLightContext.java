package org.stateDesignPattern;

/**
 * TrafficLightContext class - The Context object in the State Pattern.
 * The context maintains a reference to a state object that encapsulates the state-specific behavior.
 * The context delegates state-specific requests to the current state object.
 * Key Responsibilities:
 * 1. Hold a reference to the current state
 * 2. Delegate behavior to the current state
 * 3. Provide a way for states to transition to other states (setState method)
 * 4. Expose a simple interface to clients (change, getCurrentColor)
 * The traffic light's behavior changes based on its current state (Red, Yellow, Green),
 * but from the client's perspective, it always calls the same methods (change, getCurrentColor).
 * The actual behavior depends on which state is currently active.
 */
public class TrafficLightContext {
    private TrafficLightState currentState;  // The current state of the traffic light

    /**
     * Constructor - Initializes the traffic light with the starting state (Red).
     * The traffic light always starts with the Red state.
     */
    public TrafficLightContext() {
        currentState = new RedState(); // Initial state is always Red
    }

    /**
     * Sets the current state of the traffic light.
     * This method is called by the state objects to transition to a new state.
     * 
     * @param state The new state to set as the current state
     */
    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    /**
     * Triggers a state change/transition.
     * Delegates to the current state's next() method to determine what happens.
     * The current state is responsible for transitioning to the next state.
     */
    public void change() {
        currentState.next(this);
    }

    /**
     * Gets the color of the current state.
     * Delegates to the current state's getColor() method.
     * The client doesn't need to know which specific state is active.
     * 
     * @return The color of the current traffic light state
     */
    public String getCurrentColor() {
        return currentState.getColor();
    }
}
