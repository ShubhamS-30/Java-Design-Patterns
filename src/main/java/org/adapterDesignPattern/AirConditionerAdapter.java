package org.adapterDesignPattern;

/**
 * AirConditionerAdapter Class - Concrete Adapter
 * This adapter bridges the gap between the SmartDevice interface (target interface)
 * and the AirConditioner class (adaptee). It implements the SmartDevice interface
 * and wraps an instance of AirConditioner.
 * The adapter translates calls to SmartDevice methods (turnOn/turnOff) into calls
 * to AirConditioner methods (powerOn/powerOff), making the incompatible AirConditioner
 * class compatible with the SmartDevice interface.
 * This is an example of the "Class Adapter" or "Object Adapter" pattern.
 */
public class AirConditionerAdapter implements SmartDevice {
    // Composition: Hold a reference to the adaptee (AirConditioner)
    private final AirConditioner airConditioner;

    /**
     * Constructor - Initializes the adapter with an AirConditioner instance.
     * @param airConditioner the adaptee object to be adapted
     */
    public AirConditionerAdapter(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    /**
     * Adapts the SmartDevice turnOn() method to AirConditioner powerOn() method.
     * When client calls turnOn() on SmartDevice interface, it gets translated
     * to the powerOn() method of the adaptee (AirConditioner).
     */
    @Override
    public void turnOn() {
        // Delegate to the adaptee's powerOn() method
        airConditioner.powerOn();
    }

    /**
     * Adapts the SmartDevice turnOff() method to AirConditioner powerOff() method.
     * When client calls turnOff() on SmartDevice interface, it gets translated
     * to the powerOff() method of the adaptee (AirConditioner).
     */
    @Override
    public void turnOff() {
        // Delegate to the adaptee's powerOff() method
        airConditioner.powerOff();
    }
}
