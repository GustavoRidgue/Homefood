package com.ridgue.homefood.exceptions;

import lombok.Getter;

@Getter
public class InvalidFieldException extends RuntimeException {
    private final String error = "Could not create.";
    private final String message = "Make sure if all fields are correctly.";

    public InvalidFieldException() {
        super("Could not create. Make sure if all fields are correctly.");
    }
}
