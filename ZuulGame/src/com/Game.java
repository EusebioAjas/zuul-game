package com;

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

    public Game() {
        commandParser = new CommandParser();
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
        Command command;

        do
            command = commandParser.getCommand();
        while (!processCommand(command));

        System.out.println("Thank you for playing. Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        currentRoom.printExits();
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

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        switch (commandWord) {
            case "help":
                printHelp();
                break;
            case "go":
                goRoom(command);
                break;
            case "quit":
                wantToQuit = quit(command);
                break;
            default:
                break;
        }

        return wantToQuit;
    }

    private void goRoom(Command command) {
        if (!command.hasDirectionWord()) {
            System.out.println("Go where?");
            return;
        }

        try {
            String direction = command.getDirectionWord();
            Room nextRoom = currentRoom.determineNextRoom(RoomDirection.getDirection(direction));

            if (!nextRoom.isNullRoom()) {
                currentRoom = nextRoom;
                currentRoom.printExits();
            } else
                System.out.println("There is no door!");

        } catch (InvalidDirectionException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean quit(Command command) {
        if (command.hasDirectionWord()) {
            sendWarning();
            return false;
        }
        return true;
    }

    private void sendWarning() {
        System.out.println("Quit what?");
    }
}
