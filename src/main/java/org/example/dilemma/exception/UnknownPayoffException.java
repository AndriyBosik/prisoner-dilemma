package org.example.dilemma.exception;

public class UnknownPayoffException extends RuntimeException {
    public UnknownPayoffException(String message) {
        super(message);
    }
}
