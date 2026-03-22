package org.adapterDesignPattern;

/**
 * SmartLight Class - Adaptee Class
 * This is another "adaptee" in the adapter pattern. Like AirConditioner,
 * it has an existing interface that is incompatible with the SmartDevice interface.
 * It uses powerOn() and powerOff() methods instead of the standardized
 * turnOn() and turnOff() methods defined in the SmartDevice interface.
 * The SmartLightAdapter will translate SmartDevice method calls to these
 * SmartLight-specific methods.
 */
public class SmartLight {
    /**
     * Powers on the smart light with default settings (70% brightness, Warm White color).
     * This is the adaptee's original method with a different name than the target interface.
     */
    public void powerOn() {
        System.out.println("Smart Light is now ON.");
        setBrightness(70);
        setColor("Warm White");
    }

    /**
     * Powers off the smart light.
     * This is the adaptee's original method with a different name than the target interface.
     */
    public void powerOff() {
        System.out.println("Smart Light is now OFF.");
    }

    /**
     * Sets the brightness level of the smart light.
     * @param brightness the brightness level as a percentage (0-100)
     */
    public void setBrightness(int brightness) {
        System.out.println("Smart Light brightness set to " + brightness + "%.");
    }

    /**
     * Sets the color of the smart light.
     * @param color the desired color name (e.g., "Warm White", "Cool White", "Red")
     */
    public void setColor(String color) {
        System.out.println("Smart Light color set to " + color + ".");
    }
}
