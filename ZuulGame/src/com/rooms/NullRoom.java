package com.rooms;

import java.util.HashMap;

/**
 *
 * @author HikingCarrot7
 */
public class NullRoom extends Room {

    private static NullRoom instance;

    public static NullRoom getInstance() {
        if (instance == null)
            instance = new NullRoom();

        return instance;
    }

    private NullRoom() {
        super("", new HashMap<>());
    }

    @Override public boolean isNullRoom() {
        return true;
    }

}
