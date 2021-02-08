package com;

public class CommandWords {

    private static final String[] validCommands = {"go", "quit", "help"};

    public CommandWords() {
    }

    public boolean isCommand(String str) {
       boolean flag = false;
	for (int i = 0; i < validCommands.length; i++)
	    if (validCommands[i].equals(str)) flag = true;
	return flag;
    }
}
