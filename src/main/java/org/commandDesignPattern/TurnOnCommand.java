package org.commandDesignPattern;

/**
 * TurnOnCommand class - A Concrete Command implementation.
 * This command encapsulates the request to turn the television ON.
 * It implements the Command interface and holds a reference to the receiver (television).
 * When executed, it delegates the actual work to the receiver's on() method.
 * The command pattern decouples this class from the remote control - 
 * the remote doesn't know or care what this command does, it just calls execute().
 */
public class TurnOnCommand implements Command {
    private television tv;  // The receiver object that performs the actual action

    /**
     * Constructor - Creates a command bound to a specific television receiver.
     * 
     * @param tv The television device that this command will control
     */
    public TurnOnCommand(television tv) {
        this.tv = tv;
    }

    /**
     * Executes the command by delegating to the receiver's on() method.
     * This is the method called by the invoker (RemoteControl) when the command is triggered.
     */
    @Override
    public void execute() {
        tv.on();
    }
}
