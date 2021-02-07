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
  
  private void printHelp(){
    System.out.println("You are lost. YOu are alone. You wander");
    System.out.println("around at the university.");
    System.out.println();
    System.out.println("Your command words are:");
    System.out.println("   go quit help");
  }
}
