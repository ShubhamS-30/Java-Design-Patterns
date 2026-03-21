package org.commandDesignPattern;

/**
 * ChangeChannelCommand class - A Concrete Command implementation with parameters.
 * This command encapsulates the request to change the television channel.
 * Unlike simple commands, this one stores additional parameters (the channel number)
 * that are needed when the command is executed.
 * This demonstrates how commands can be parametrized with different values
 * for the same operation on the receiver.
 */
public class ChangeChannelCommand implements Command {
    private final television tv;      // The receiver object that performs the actual action
    private final int channel;        // Parameter: the channel number to change to

    /**
     * Constructor - Creates a command bound to a specific television and channel.
     * The command stores both the receiver and the parameter needed for execution.
     * 
     * @param tv The television device that this command will control
     * @param channel The channel number to change to when executed
     */
    public ChangeChannelCommand(television tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    /**
     * Executes the command by delegating to the receiver's changeChannel() method
     * with the stored channel parameter.
     * The invoker doesn't need to know about the channel number - it's encapsulated.
     */
    @Override
    public void execute() {
        tv.changeChannel(channel);
    }
}
