
package com.exceptions;

public class InvalidDirectionException extends RuntimeException{
    
    public InvalidDirectionException(String word) {
	super("Invalid Direction: " + word);
    }
    
}
