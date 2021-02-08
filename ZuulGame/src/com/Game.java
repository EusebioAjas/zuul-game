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
}
