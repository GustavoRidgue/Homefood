package com.ridgue.homefood.exceptions;

import lombok.Getter;

@Getter
public class ClientAlreadyActivatedException extends RuntimeException {
    private final String error = "Could not activate this client.";
    private final String message = "This client already is activated.";

    public ClientAlreadyActivatedException() {
        super("Could not activate this client. This client already is activated.");
    }
}
