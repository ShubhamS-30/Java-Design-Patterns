package org.commandDesignPattern;

/**
 * ComplexCommand class - A Concrete Command that performs multiple actions (Macro Command).
 * This command demonstrates the Command Pattern's flexibility by executing multiple
 * operations as a single command. It's often called a "Macro Command" because it
 * groups several operations together.
 * When executed, this command:
 * 1. Turns the TV ON
 * 2. Changes the channel to the specified channel
 * 3. Adjusts the volume to the specified level
 * This shows how the Command Pattern supports composition and can execute complex
 * sequences of operations while maintaining the simple execute() interface.
 */
public class ComplexCommand implements Command {
    private final television tv;      // The receiver object
    private final int channel;        // Parameter: the channel number
    private final int volume;         // Parameter: the volume level

    /**
     * Constructor - Creates a complex command with multiple parameters.
     * This command will perform three operations when executed.
     * 
     * @param tv The television device that this command will control
     * @param channel The channel number to change to
     * @param volume The volume level to set
     */
    public ComplexCommand(television tv, int channel, int volume) {
        this.tv = tv;
        this.channel = channel;
        this.volume = volume;
    }

    /**
     * Executes the complex command by performing multiple operations in sequence.
     * This demonstrates how commands can orchestrate multiple receiver operations
     * while still presenting a single execute() interface to the invoker.
     * The sequence:
     * 1. First, turn the television ON
     * 2. Then, change to the specified channel
     * 3. Finally, adjust to the specified volume
     */
    @Override
    public void execute() {
        tv.on();
        tv.changeChannel(channel);
        tv.adjustVolume(volume);
    }
}
