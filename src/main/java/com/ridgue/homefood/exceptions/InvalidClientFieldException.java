package com.ridgue.homefood.exceptions;

import lombok.Getter;

@Getter
public class InvalidClientFieldException extends RuntimeException {
    private final String error = "Could not create the client.";
    private final String message = "Make sure if all the client's field are correctly.";

    public InvalidClientFieldException() {
        super("Could not create the client. Make sure if all the client's field are correctly");
    }
}
