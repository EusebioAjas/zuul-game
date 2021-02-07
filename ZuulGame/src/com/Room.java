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
    
      public void setExits(Room north, Room east, Room south, Room west) 
    {
        boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false; 
        if(north != null)
            flag1 = true;
           
        if(east!=null)
            flag2 = true;
           
        if(south != null)
            flag3 = true;
            
        if(west!= null)
            flag4 = true;
        
        if(flag1 ==true){
            northExit = north;
        }
        if(flag2==true){
            eastExit = east;
        }
        if(flag3 ==true)
        {
            southExit = south;
        }
        if(flag4 ==true)
        {
            westExit = west;
         }
        
    }
 
    public String getDescription()
    {
        return description;
    }
    
}
