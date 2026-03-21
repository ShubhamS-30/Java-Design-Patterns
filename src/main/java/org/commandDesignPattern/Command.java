package org.commandDesignPattern;

/**
 * Command interface - Defines the contract for all command implementations.
 * The Command Pattern is a behavioral design pattern that encapsulates a request as an object,
 * allowing parameterization of clients with different requests, queuing requests, and 
 * logging of requests.
 * Key Benefits:
 * 1. Decouples the object that invokes the operation from the one that knows how to perform it
 * 2. Commands can be queued, scheduled, or logged
 * 3. Supports undo/redo functionality
 * 4. Enables dynamic command configuration at runtime
 * This interface defines a single method that all concrete commands must implement.
 */
public interface Command {
    /**
     * Executes the command.
     * Each concrete command implementation provides its own execution logic.
     */
    void execute();
}
