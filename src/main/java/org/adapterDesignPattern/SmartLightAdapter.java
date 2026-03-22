package org.adapterDesignPattern;

/**
 * SmartLightAdapter Class - Concrete Adapter
 * This adapter enables the SmartLight class to be used through the SmartDevice interface.
 * It implements SmartDevice and wraps a SmartLight instance, translating method calls
 * from the standard interface to the adaptee's specific methods.
 * The adapter pattern allows SmartLight to be treated as a SmartDevice without
 * modifying the original SmartLight class.
 */
public class SmartLightAdapter implements SmartDevice {
    // Composition: Hold a reference to the adaptee (SmartLight)
    private final SmartLight smartLight;

    /**
     * Constructor - Initializes the adapter with a SmartLight instance.
     * @param smartLight the adaptee object to be adapted
     */
    public SmartLightAdapter(SmartLight smartLight) {
        this.smartLight = smartLight;
    }

    /**
     * Adapts the SmartDevice turnOn() method to SmartLight powerOn() method.
     * Provides a consistent interface for controlling the light.
     */
    @Override
    public void turnOn() {
        // Delegate to the adaptee's powerOn() method
        smartLight.powerOn();
    }

    /**
     * Adapts the SmartDevice turnOff() method to SmartLight powerOff() method.
     * Provides a consistent interface for controlling the light.
     */
    @Override
    public void turnOff() {
        // Delegate to the adaptee's powerOff() method
        smartLight.powerOff();
    }
}
