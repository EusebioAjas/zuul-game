package com;

public class CommandWords {

    private static final String[] VALID_COMMANDS = {"go", "quit", "help"};

    public CommandWords() {
    }

    public boolean isValidCommand(String aString) {
       boolean flag = false;
	for (int i = 0; i < VALID_COMMANDS.length; i++)
	    if (VALID_COMMANDS[i].equals(aString)) flag = true;
	return flag;
    }
}
