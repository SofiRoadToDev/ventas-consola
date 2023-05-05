package com.besysoft.ventas.exceptions;

public class AlreadyStoredObjectException extends RuntimeException {

    public AlreadyStoredObjectException(String message) {
        super(message);
    }
}
