package org.commandDesignPattern;

/**
 * Client class - Demonstrates the Command Design Pattern in action.
 * The Command Pattern is a behavioral design pattern that encapsulates a request as an object,
 * allowing you to parameterize clients with different requests, queue requests, log requests,
 * and support undoable operations.
 * Pattern Components:
 * 1. Command Interface - Defines the execute() method contract
 * 2. Concrete Commands - Implement the Command interface (TurnOnCommand, ChangeChannelCommand, etc.)
 * 3. Receiver - The object that performs the actual work (television)
 * 4. Invoker - The object that executes commands (RemoteControl)
 * 5. Client - Creates command objects and associates them with invokers
 * Key Benefits:
 * - Decouples objects that issue operations from objects that perform them
 * - Commands can be queued, scheduled, or logged
 * - Supports macro commands (multiple operations as one command)
 * - Makes it easy to add new commands without modifying existing code
 * - Enables undo/redo functionality
 * In this example:
 * - television is the Receiver (performs the actual work)
 * - TurnOnCommand, TurnOffCommand, etc. are Concrete Commands
 * - RemoteControl is the Invoker (executes commands)
 * - Client creates and configures everything
 */
public class Client {
    public static void main(String[] args) {
        
        // Step 1: Create the Receiver object
        // The television doesn't know which command will invoke its methods
        television tv = new television();
        
        // Step 2: Create Concrete Command objects
        // Each command knows how to invoke a method on the receiver
        Command turnOnCommand = new TurnOnCommand(tv);
        Command turnOffCommand = new TurnOffCommand(tv);

        // Step 3: Create the Invoker object
        // The remote control doesn't need to know about the receiver or specific commands
        RemoteControl remoteControl = new RemoteControl();
        
        // Step 4: Configure the Invoker with Commands
        // This demonstrates runtime configuration of commands
        remoteControl.setOnCommand(turnOnCommand);
        remoteControl.setOffCommand(turnOffCommand);

        // Step 5: Execute commands through the Invoker
        // The remote control just calls execute() without knowing what happens
        remoteControl.pressOnButton();       // TV is now ON - command executed
        remoteControl.pressOffButton();      // TV is now OFF - command executed

        // Step 6: Create and execute parameterized commands
        // These commands store additional information needed for execution
        Command changeChannelCommand = new ChangeChannelCommand(tv, 5);
        changeChannelCommand.execute();      // TV is now on channel 5

        // Step 7: Execute another parameterized command
        Command adjustVolumeCommand = new AdjustVolumeCommand(tv, 10);
        adjustVolumeCommand.execute();       // TV volume is now set to 10

        // Step 8: Execute a Complex/Macro command
        // This single command performs multiple operations
        Command complexCommand = new ComplexCommand(tv, 3, 15);
        complexCommand.execute();            // TV is ON, channel set to 3, volume set to 15
    }
}
