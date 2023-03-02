package com.lapotko.exception;

public class CsvFileReadException extends RuntimeException {
    public CsvFileReadException() {
    }

    public CsvFileReadException(String message) {
        super(message);
    }
}
