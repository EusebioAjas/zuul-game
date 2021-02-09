package com;

/**
 *
 * @author hikingcarrot7
 */
public class Command {
    
    private final String commandWord;
    private final String directionWord;

    public Command(String commandWord, String directionWord) {
	this.commandWord = commandWord;
	this.directionWord = directionWord;
    }

    public String getCommandWord() {
	return commandWord;
    }

    public String getDirectionWord() {
	return directionWord;
    }

    public boolean isUnknown() {
	return commandWord == null;
    }

    public boolean hasDirectionWord() {
	return directionWord != null;
    }
}
