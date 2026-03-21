package org.commandDesignPattern;

/**
 * RemoteControl class - The Invoker object in the Command Pattern.
 * The Invoker asks a command to carry out a request. It doesn't know or care
 * about the actual implementation of the command - it just invokes the execute() method.
 * This decouples the invoker from the receiver and the specific operations.
 * The invoker holds references to command objects and triggers them when needed.
 * A remote control is a good example of an invoker - when you press a button,
 * it invokes a command without knowing what device it controls or what action it performs.
 */
public class RemoteControl {
    private Command onCommand;      // Command for the "ON" button
    private Command offCommand;     // Command for the "OFF" button

    /**
     * Sets the command to be executed when the ON button is pressed.
     * This allows dynamic assignment of commands at runtime.
     * 
     * @param onCommand The command to execute when ON button is pressed
     */
    public void setOnCommand(Command onCommand) {
        this.onCommand = onCommand;
    }

    /**
     * Sets the command to be executed when the OFF button is pressed.
     * This allows dynamic assignment of commands at runtime.
     * 
     * @param offCommand The command to execute when OFF button is pressed
     */
    public void setOffCommand(Command offCommand) {
        this.offCommand = offCommand;
    }

    /**
     * Simulates pressing the ON button.
     * Invokes the execute() method of the onCommand object.
     * The invoker doesn't need to know what the command does.
     */
    public void pressOnButton() {
        onCommand.execute();
    }

    /**
     * Simulates pressing the OFF button.
     * Invokes the execute() method of the offCommand object.
     * The invoker doesn't need to know what the command does.
     */
    public void pressOffButton() {
        offCommand.execute();
    }
}
