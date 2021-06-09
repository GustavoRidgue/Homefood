package com.ridgue.homefood.exceptions;

import lombok.Getter;

@Getter
public class InvalidClientTokenException extends RuntimeException {
    private final String error = "Could not activate this client.";
    private final String message = "This is not the client's token.";

    public InvalidClientTokenException() {
        super("Could not activate this client. This is not the client's token.");
    }
}
