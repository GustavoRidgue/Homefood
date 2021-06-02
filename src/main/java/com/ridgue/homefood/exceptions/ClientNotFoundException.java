package com.ridgue.homefood.exceptions;

import lombok.Getter;

@Getter
public class ClientNotFoundException extends RuntimeException {
    private final String error = "Could not find the client by the given ID.";
    private final String message = "Make Sure if the given ID exist.";

    public ClientNotFoundException() {
        super("Could not find the client by the given ID. Make Sure if the given ID exist.");
    }
}
