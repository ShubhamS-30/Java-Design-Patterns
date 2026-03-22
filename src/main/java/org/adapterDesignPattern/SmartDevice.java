package org.adapterDesignPattern;

/**
 * SmartDevice Interface - Target Interface for Adapter Pattern
 * This interface defines the standard contract that all smart devices should follow.
 * It acts as the "target interface" in the adapter pattern, providing a uniform
 * interface for controlling various devices using turnOn() and turnOff() methods.
 * Adapters implement this interface to make incompatible devices compatible with
 * this standardized interface.
 */
public interface SmartDevice {
    /**
     * Turns on the smart device.
     * All implementations should provide their own logic for powering on the device.
     */
    void turnOn();
    
    /**
     * Turns off the smart device.
     * All implementations should provide their own logic for powering off the device.
     */
    void turnOff();
}
