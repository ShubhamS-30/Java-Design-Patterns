package org.commandDesignPattern;

/**
 * Television class - The Receiver object in the Command Pattern.
 * The Receiver knows how to perform the actual work. It contains the business logic
 * for the operations that commands will invoke.
 * In this pattern, commands encapsulate requests that operate on this receiver.
 * The receiver has no knowledge of which command is invoking its methods.
 * This class represents a television device with various operations that can be
 * requested through different commands.
 */
public class television {

    /**
     * Turns the television on.
     * This is an action that can be triggered by a command.
     */
    public void on() {
        System.out.println("Television is ON");
    }

    /**
     * Turns the television off.
     * This is an action that can be triggered by a command.
     */
    public void off() {
        System.out.println("Television is OFF");
    }

    /**
     * Adjusts the volume of the television.
     * This is an action that can be triggered by a command with a parameter.
     * 
     * @param volume The desired volume level
     */
    public void adjustVolume(int volume) {
        System.out.println("Volume adjusted to " + volume);
    }

    /**
     * Changes the television channel.
     * This is an action that can be triggered by a command with a parameter.
     * 
     * @param channel The channel number to change to
     */
    public void changeChannel(int channel) {
        System.out.println("Channel changed to " + channel);
    }

}
