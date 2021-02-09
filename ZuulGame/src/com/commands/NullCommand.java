package com.commands;

import com.Game;

/**
 *
 * @author hikingcarrot7
 */
public class NullCommand extends Command {

    public static final String INVALID_COMMAND_WORD = null;
    public static final String INVALID_DIRECTION_WORD = null;

    public NullCommand() {
        super(INVALID_COMMAND_WORD, INVALID_DIRECTION_WORD);
    }

    @Override public void execute(Game game) {
        // Null command
    }

}
