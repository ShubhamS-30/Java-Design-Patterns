package org.commandDesignPattern;

/**
 * TurnOffCommand class - A Concrete Command implementation.
 * This command encapsulates the request to turn the television OFF.
 * It implements the Command interface and holds a reference to the receiver (television).
 * When executed, it delegates the actual work to the receiver's off() method.
 * Similar to TurnOnCommand, this demonstrates how different commands can wrap
 * different operations on the same receiver, all following the same interface.
 */
public class TurnOffCommand implements Command {
    private television tv;  // The receiver object that performs the actual action

    /**
     * Constructor - Creates a command bound to a specific television receiver.
     * 
     * @param tv The television device that this command will control
     */
    public TurnOffCommand(television tv) {
        this.tv = tv;
    }

    /**
     * Executes the command by delegating to the receiver's off() method.
     * This is the method called by the invoker (RemoteControl) when the command is triggered.
     */
    @Override
    public void execute() {
        tv.off();
    }
}
