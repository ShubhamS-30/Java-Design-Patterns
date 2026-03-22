package org.adapterDesignPattern;

/**
 * CoffeeMachine Class - Adaptee Class
 * This is the third "adaptee" in the adapter pattern. Like the other devices,
 * it has its own specific interface that doesn't conform to the SmartDevice interface.
 * The CoffeeMachine uses powerOn() and powerOff() methods, which need to be adapted
 * to the SmartDevice interface using the CoffeeMachineAdapter.
 * This demonstrates that the adapter pattern can be applied to any number of
 * incompatible classes to provide a unified interface.
 */
public class CoffeeMachine {
    /**
     * Powers on the coffee machine with default settings (Medium strength, Large cup).
     * This is the adaptee's original method with a different name than the target interface.
     */
    public void powerOn() {
        System.out.println("Coffee Machine is now ON.");
        setBrewStrength("Medium");
        setCupSize("Large");
    }

    /**
     * Powers off the coffee machine.
     * This is the adaptee's original method with a different name than the target interface.
     */
    public void powerOff() {
        System.out.println("Coffee Machine is now OFF.");
    }

    /**
     * Sets the brewing strength of the coffee.
     * @param strength the desired strength level (e.g., "Weak", "Medium", "Strong")
     */
    public void setBrewStrength(String strength) {
        System.out.println("Coffee Machine brew strength set to " + strength + ".");
    }

    /**
     * Sets the cup size for brewing.
     * @param size the desired cup size (e.g., "Small", "Medium", "Large")
     */
    public void setCupSize(String size) {
        System.out.println("Coffee Machine cup size set to " + size + ".");
    }
}
