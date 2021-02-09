package com;

import java.util.Scanner;

/**
 *
 * @author hikingcarrot7
 */
public class CommandParser {

    private final CommandWords commands;
    private final Scanner reader;

    public CommandParser() {
	commands = new CommandWords();
	reader = new Scanner(System.in);
    }

    public Command getCommand() {
	String phrase;
	String commandWord = null;
	String directionWord = null;

	System.out.print("> ");
	phrase = reader.nextLine();
	Scanner tokenizer = new Scanner(phrase);
	if (tokenizer.hasNext()) {
	    commandWord = tokenizer.next();
	    if (tokenizer.hasNext())
		directionWord = tokenizer.next();
	}

	if (commands.isValidCommand(commandWord))
	    return new Command(commandWord, directionWord);
	else
	    return new Command(null, directionWord);
    }

}
