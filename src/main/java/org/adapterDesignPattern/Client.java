package org.adapterDesignPattern;

/**
 * Client Class - Demonstrates the Adapter Design Pattern
 * ADAPTER PATTERN OVERVIEW:
 * The Adapter pattern converts the interface of a class into another interface
 * that clients expect. This allows incompatible interfaces to work together.
 * PROBLEM SOLVED:
 * We have three different device classes (AirConditioner, SmartLight, CoffeeMachine)
 * that each have their own different control methods:
 * - AirConditioner: uses powerOn() / powerOff()
 * - SmartLight: uses powerOn() / powerOff()
 * - CoffeeMachine: uses powerOn() / powerOff()
 * We want a unified way to control all these devices with a common interface.
 * SOLUTION:
 * Create adapter classes that implement a common SmartDevice interface, translating
 * calls from the common interface to each device's specific methods.
 * COMPONENTS:
 * 1. Target Interface: SmartDevice (turnOn/turnOff)
 * 2. Adaptees: AirConditioner, SmartLight, CoffeeMachine (original classes)
 * 3. Concrete Adapters: AirConditionerAdapter, SmartLightAdapter, CoffeeMachineAdapter
 * 4. Client: This class, which uses SmartDevice interface to control all devices without worrying about their specific implementations.
 * BENEFITS:
 * - Unified control of heterogeneous devices
 * - Reuse of existing code without modification (Open/Closed Principle)
 * - Easy to add new device types with new adapters
 */
public class Client {
    public static void main(String[] args) {
        // STEP 1: Create instances of the original (incompatible) devices
        // These devices have their own methods (powerOn/powerOff) not matching our interface
        AirConditioner airConditioner = new AirConditioner();
        SmartLight smartLight = new SmartLight();
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        // STEP 2: Create adapters for each device
        // The adapters implement the SmartDevice interface and wrap the original devices.
        // They translate SmartDevice method calls to the device-specific methods.
        SmartDevice airConditionerAdapter = new AirConditionerAdapter(airConditioner);
        SmartDevice smartLightAdapter = new SmartLightAdapter(smartLight);
        SmartDevice coffeeMachineAdapter = new CoffeeMachineAdapter(coffeeMachine);

        // STEP 3: Use the adapters through the unified SmartDevice interface
        // Notice how we can now control all devices with the same interface (turnOn/turnOff)
        // The actual method calls to each device are handled by the adapters.
        System.out.println("=== Turning ON all devices ===");
        airConditionerAdapter.turnOn();
        smartLightAdapter.turnOn();
        coffeeMachineAdapter.turnOn();

        System.out.println("\n=== Turning OFF all devices ===");
        airConditionerAdapter.turnOff();
        smartLightAdapter.turnOff();
        coffeeMachineAdapter.turnOff();
        
        /*
         * KEY TAKEAWAY:
         * Thanks to the Adapter pattern, we can now control three completely different
         * devices using the same interface, without modifying any of the original classes.
         * This makes the system flexible, maintainable, and easy to extend.
         */
    }
}
