package com;

import java.util.Scanner;

/**
 *
 * @author hikingcarrot7
 */
public class CommandParser {

    private final CommandWords commandWords;
    private final Scanner reader;

    public CommandParser() {
	commandWords = new CommandWords();
	reader = new Scanner(System.in);
    }

    public Command getCommand() {
	String inputLine;
	String commandWord = null;
	String directionWord = null;

	System.out.print("> ");

	inputLine = reader.nextLine();

	Scanner tokenizer = new Scanner(inputLine);
	if (tokenizer.hasNext()) {
	    commandWord = tokenizer.next();
	    if (tokenizer.hasNext()) directionWord = tokenizer.next();
	}

	if (commandWords.isValidCommand(commandWord)) return new Command(commandWord, directionWord);
	else return new Command(null, directionWord);
    }

}
