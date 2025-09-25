package it.its.demo.exceptions;

public class MovieAlreadyExists extends RuntimeException {
    public MovieAlreadyExists(String message) {
        super(message);
    }
}
