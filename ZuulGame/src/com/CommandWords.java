package com;

import java.util.Arrays;
import java.util.List;

public class CommandWords {

    private static final String[] VALID_COMMANDS = {"go", "quit", "help"};

    public boolean isValidCommand(String commandWord) {
	List<String> commandWords = Arrays.asList(VALID_COMMANDS);
	return commandWords.contains(commandWord);
    }
}
