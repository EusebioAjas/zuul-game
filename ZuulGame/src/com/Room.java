/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author Alexis
 */
public class Room {
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    
    public Room(String description) 
    {
        this.description = description;
    }
 
    public String getDescription()
    {
        return description;
    }
    
}
