package com.ridgue.homefood.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final String error = "Could not find the resource by the given ID.";
    private final String message = "Make sure if the given ID exist.";

    public ResourceNotFoundException() {
        super("Could not find the resource by the given ID. Make sure if the given ID exist.");
    }
}
