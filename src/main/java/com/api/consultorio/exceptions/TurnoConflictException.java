package com.api.consultorio.exceptions;

public class TurnoConflictException extends RuntimeException {
    public TurnoConflictException(String message) {
        super(message);
    }
}