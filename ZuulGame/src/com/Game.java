package com;

/**
 *
 * @author Eusebio Ajas
 */
public class Game {

    private final CommandParser parser;
    private Room currentRoom;

    public Game() {
	parser = new CommandParser();
	createRooms();
    }

    private void createRooms() {
	Room outside, theatre, pub, lab, office;

	outside = new Room("outside the main entrance of the university");
	theatre = new Room("in a lecture theatre");
	pub = new Room("in the campus pub");
	lab = new Room("in a computing lab");
	office = new Room("in the computing admin office");

	outside.setExits(null, theatre, lab, pub);
	theatre.setExits(null, null, null, outside);
	pub.setExits(null, outside, null, null);
	lab.setExits(outside, office, null, null);
	office.setExits(null, null, null, lab);

	currentRoom = outside;
    }

    public void play() {
	printWelcome();
	Command command;

	do command = parser.getCommand();
	while (!processCommand(command));

	System.out.println("Thank you for playing. Good bye.");
    }

    private void printWelcome() {
      System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getRoomDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    private void printHelp() {
	System.out.println("You are lost. You are alone. You wander");
	System.out.println("around at the university.");
	System.out.println();
	System.out.println("Your command words are:");
	System.out.println("   go quit help");
    }

    private boolean processCommand(Command command) {
       boolean wantToQuit = false;

	if (command.isUnknown()) 
	{
	    System.out.println("I don't know what you mean...");
	    return false;
	}

	String commandWord = command.getCommandWord();

	switch (commandWord) {
	    case "help":printHelp(); break;
	    case "go":goRoom(command); break;
	    case "quit":wantToQuit = quit(command); break;
	    default: break;
	}

	return wantToQuit;
    }

    private void goRoom(Command command) {
    if (!command.hasDirectionWord()) 
    {
      System.out.println("Go where?");
      return;
    }
    String direction = command.getDirectionWord();
    Room nextRoom = null;
    if (direction.equals("east")) 
    {  
      nextRoom = currentRoom.eastExit;
    }
    if (direction.equals("west")) 
    {
      nextRoom = currentRoom.westExit;
    }
    if (direction.equals("north")){
      nextRoom = currentRoom.northExit;

    }
    if (direction.equals("south")) 
    {
      nextRoom = currentRoom.southExit;
    }
    if (nextRoom == null) 
    {
      System.out.println("There is no door");
    } else 
    {
      currentRoom = nextRoom;
      System.out.println("You are " + currentRoom.getRoomDescription());
      System.out.println("Exits: ");
      if (currentRoom.northExit != null) 
      {
        System.out.println("north ");
      }
      if (currentRoom.eastExit != null) 
      {
        System.out.println("east ");
      }
      if (currentRoom.southExit != null) 
      {
        System.out.println("south ");
      }
      if (currentRoom.westExit != null) 
      {
        System.out.println("west ");
      }
      
      System.out.println();
    }
    }

    private boolean quit(Command command) {
	boolean finished =false;
      if(command.hasDirectionWord()){
            System.out.println("Quit what?");
            return finished;
      }else{
        finished = true;
      }
      return finished;
    }

}
