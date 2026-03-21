package org.commandDesignPattern;

/**
 * AdjustVolumeCommand class - A Concrete Command implementation with parameters.
 * This command encapsulates the request to adjust the television volume.
 * Like ChangeChannelCommand, it stores a parameter (the volume level)
 * that is needed when the command is executed.
 * This shows how the same receiver can be used with multiple different parameterized commands.
 */
public class AdjustVolumeCommand implements Command {
    private final television tv;      // The receiver object that performs the actual action
    private final int volume;         // Parameter: the volume level to set

    /**
     * Constructor - Creates a command bound to a specific television and volume.
     * The command encapsulates both the receiver and the parameter needed for execution.
     * 
     * @param tv The television device that this command will control
     * @param volume The volume level to adjust to when executed
     */
    public AdjustVolumeCommand(television tv, int volume) {
        this.tv = tv;
        this.volume = volume;
    }

    /**
     * Executes the command by delegating to the receiver's adjustVolume() method
     * with the stored volume parameter.
     * The invoker remains decoupled from the specific volume value.
     */
    @Override
    public void execute() {
        tv.adjustVolume(volume);
    }
}
