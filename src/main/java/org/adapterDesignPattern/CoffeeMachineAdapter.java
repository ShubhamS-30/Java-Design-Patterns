package org.adapterDesignPattern;

/**
 * CoffeeMachineAdapter Class - Concrete Adapter
 * This adapter allows the CoffeeMachine class to work with the SmartDevice interface.
 * It bridges the incompatibility between CoffeeMachine's methods and SmartDevice's
 * standardized interface.
 * By wrapping the CoffeeMachine and implementing SmartDevice, clients can treat
 * the CoffeeMachine as a SmartDevice without any modifications to either class.
 */
public class CoffeeMachineAdapter implements SmartDevice {
    // Composition: Hold a reference to the adaptee (CoffeeMachine)
    private final CoffeeMachine coffeeMachine;

    /**
     * Constructor - Initializes the adapter with a CoffeeMachine instance.
     * @param coffeeMachine the adaptee object to be adapted
     */
    public CoffeeMachineAdapter(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    /**
     * Adapts the SmartDevice turnOn() method to CoffeeMachine powerOn() method.
     * Allows unified control of the coffee machine through the SmartDevice interface.
     */
    @Override
    public void turnOn() {
        // Delegate to the adaptee's powerOn() method
        coffeeMachine.powerOn();
    }

    /**
     * Adapts the SmartDevice turnOff() method to CoffeeMachine powerOff() method.
     * Allows unified control of the coffee machine through the SmartDevice interface.
     */
    @Override
    public void turnOff() {
        // Delegate to the adaptee's powerOff() method
        coffeeMachine.powerOff();
    }
}
