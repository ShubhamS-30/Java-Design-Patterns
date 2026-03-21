package org.stateDesignPattern;

/**
 * YellowState class - A Concrete State implementation.
 * This class represents the YELLOW state of the traffic light.
 * In a traffic light system, Yellow means "Caution" - prepare to stop soon.
 * When the traffic light is in the Yellow state:
 * - Current color is Yellow
 * - Next state is Red (stop)
 * - The transition happens when change() is called
 * The Yellow state acts as a transitional state between Green (go) and Red (stop),
 * warning drivers that they should prepare to stop.
 */
public class YellowState implements TrafficLightState {
    
    /**
     * Transitions from Yellow state to Red state.
     * This method is called when the traffic light needs to change.
     * Yellow always transitions to Red because that's the sequence: Red -> Green -> Yellow -> Red
     * Red indicates vehicles must stop.
     * 
     * @param context The traffic light context that will have its state changed
     */
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Changing from Yellow to Red");
        // Transition to Red state by creating a new RedState and setting it on the context
        context.setState(new RedState());
    }

    /**
     * Returns the color representation of the Yellow state.
     * 
     * @return "Yellow" - the color of this state
     */
    @Override
    public String getColor() {
        return "Yellow";
    }
}
