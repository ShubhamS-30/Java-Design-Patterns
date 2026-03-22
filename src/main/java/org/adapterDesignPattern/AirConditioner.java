package org.adapterDesignPattern;

/**
 * AirConditioner Class - Adaptee Class
 * This is the "adaptee" in the adapter pattern. It has an existing interface
 * that is incompatible with the SmartDevice interface.
 * Instead of using turnOn() and turnOff(), it uses powerOn() and powerOff().
 * This is a legacy or incompatible interface that needs to be adapted to work
 * with the standardized SmartDevice interface.
 * The adapter (AirConditionerAdapter) will translate calls from SmartDevice
 * methods to these specific AirConditioner methods.
 */
public class AirConditioner {
    /**
     * Powers on the air conditioner with default settings (24 degrees, Cooling mode).
     * This is the adaptee's original method with a different name than the target interface.
     */
    public void powerOn() {
        System.out.println("Air Conditioner is now ON.");
        setTemperature(24);
        setMode("Cooling");
    }

    /**
     * Powers off the air conditioner.
     * This is the adaptee's original method with a different name than the target interface.
     */
    public void powerOff() {
        System.out.println("Air Conditioner is now OFF.");
    }

    /**
     * Sets the temperature for the air conditioner.
     * @param temperature the desired temperature in degrees Celsius
     */
    public void setTemperature(int temperature) {
        System.out.println("Air Conditioner temperature set to " + temperature + " degrees.");
    }

    /**
     * Sets the operating mode of the air conditioner.
     * @param mode the desired mode (e.g., "Cooling", "Heating", "Fan Only")
     */
    public void setMode(String mode) {
        System.out.println("Air Conditioner mode set to " + mode + ".");
    }
}
