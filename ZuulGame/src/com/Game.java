package com;

import com.commands.Command;
import com.exceptions.InvalidDirectionException;
import com.rooms.Room;
import com.rooms.RoomDirection;
import com.rooms.RoomExitsBuilder;

/**
 *
 * @author Eusebio Ajas
 */
public class Game {

    private final CommandParser commandParser;
    private Room currentRoom;
    private boolean gameOver;

    public Game() {
        commandParser = new CommandParser();
        setGameOver(false);
        createRooms();
    }

    private void createRooms() {
        Room outside, theatre, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        outside.setExits(new RoomExitsBuilder()
                .setSouthRoom(lab)
                .setEastRoom(theatre)
                .setWestRoom(pub)
                .build());

        theatre.setExits(new RoomExitsBuilder()
                .setEastRoom(outside)
                .build());

        pub.setExits(new RoomExitsBuilder()
                .setEastRoom(outside)
                .build());

        lab.setExits(new RoomExitsBuilder()
                .setNorthRoom(outside)
                .setEastRoom(office)
                .build());

        office.setExits(new RoomExitsBuilder()
                .setWestRoom(lab)
                .build());

        currentRoom = outside;
    }

    public void play() {
        printWelcome();

        do {
            Command command = commandParser.getCommand();
            processCommand(command);
        } while (!isGameOver());

        System.out.println("Thank you for playing. Good bye.");
    }

    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        currentRoom.printExits();
        System.out.println();
    }

    public void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    public void goRoom(Command command) {
        if (!command.hasDirectionWord()) {
            System.out.println("Go where?");
            return;
        }
        getCommandDirection(command);
    }
    
    public void getCommandDirection(Command command) {
        try {
            String direction = command.getDirectionWord();
            Room nextRoom = currentRoom.determineNextRoom(RoomDirection.getDirection(direction));

            if (!nextRoom.isNullRoom()) {
                currentRoom = nextRoom;
                currentRoom.printExits();
            } else {
                System.out.println("There is no door!");
            }

        } catch (InvalidDirectionException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean quitGame(Command command) {
        if (command.hasDirectionWord()) {
            sendWarning();
            return false;
        }
        return true;
    }

    private void processCommand(Command command) {
        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return;
        }

        command.execute(this);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    private void sendWarning() {
        System.out.println("Quit what?");
    }
}
