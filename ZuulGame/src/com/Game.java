package com;

/**
 *
 * @author Eusebio Ajas
 */
public class Game {
  private Parser parser;
  private Room currRoom;

  public Game() {
    parser = new Parser();
  }
  
   private void printWelcome() 
   {
      System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
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

  private void printHelp(){
    System.out.println("You are lost. YOu are alone. You wander");
    System.out.println("around at the university.");
    System.out.println();
    System.out.println("Your command words are:");
    System.out.println("   go quit help");
  }

  private void goRoom(Command command) 
  {
    if (!command.hasDirectionWord()) 
    {
      System.out.println("Go where?");
      return;
    }
    String direction = command.getDirectionWord();
    Room nextRoom = null;
    if (direction.equals("east")) 
    {
      nextRoom = currRoom.eastExit;
    }
    if (direction.equals("west")) 
    {
      nextRoom = currRoom.westExit;
    }
    if (direction.equals("north")){
      nextRoom = currRoom.northExit;

    }
    if (direction.equals("south")) 
    {
      nextRoom = currRoom.southExit;
    }
    if (nextRoom == null) 
    {
      System.out.println("There is no door");
    } else 
    {
      currRoom = nextRoom;
      System.out.println("You are " + currRoom.getDescription());
      System.out.println("Exits: ");
      if (currRoom.northExit != null) 
      {
        System.out.println("north ");
      }
      if (currRoom.eastExit != null) 
      {
        System.out.println("east ");
      }
      if (currRoom.southExit != null) 
      {
        System.out.println("south ");
      }
      if (currRoom.westExit != null) 
      {
        System.out.println("west ");
      }
      
      System.out.println();
    }
  }
  
  private boolean quit(Command command)
  {
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
