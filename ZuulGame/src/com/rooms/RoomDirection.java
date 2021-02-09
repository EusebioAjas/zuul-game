

package com.rooms;

import java.util.Arrays;
import java.util.Optional;

public enum RoomDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;
    
    public static RoomDirection getDirection(String aString) {
	Optional<RoomDirection> roomDirectionMaybe = Arrays
		.asList(RoomDirection.values())
		.stream()
		.filter(roomDirection -> roomDirection.toString().equals(aString))
		.findAny();

	if (!roomDirectionMaybe.isPresent()) 
            System.out.println("Invalid direction " + aString);    
            
	return roomDirectionMaybe.get();
    }
    
    @Override public String toString() {
	return super.toString().toLowerCase();
    }
}
