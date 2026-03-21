package org.stateDesignPattern;

/**
 * GreenState class - A Concrete State implementation.
 * This class represents the GREEN state of the traffic light.
 * In a traffic light system, Green means "Go" - vehicles can proceed.
 * When the traffic light is in the Green state:
 * - Current color is Green
 * - Next state is Yellow (caution - prepare to stop)
 * - The transition happens when change() is called
 * The Green state encapsulates the behavior when traffic light is green,
 * including knowing that it should transition to Yellow next.
 */
public class GreenState implements TrafficLightState {
    
    /**
     * Transitions from Green state to Yellow state.
     * This method is called when the traffic light needs to change.
     * Green always transitions to Yellow because that's the sequence: Red -> Green -> Yellow -> Red
     * Yellow is used as a warning that Red is coming soon.
     * 
     * @param context The traffic light context that will have its state changed
     */
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Changing from Green to Yellow");
        // Transition to Yellow state by creating a new YellowState and setting it on the context
        context.setState(new YellowState());
    }

    /**
     * Returns the color representation of the Green state.
     * 
     * @return "Green" - the color of this state
     */
    @Override
    public String getColor() {
        return "Green";
    }
}
