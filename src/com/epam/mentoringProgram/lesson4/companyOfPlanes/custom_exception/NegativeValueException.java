package com.epam.mentoringProgram.lesson4.companyOfPlanes.custom_exception;

public class NegativeValueException extends Exception {
    public NegativeValueException() {
        super();
    }

    public NegativeValueException(String message) {
        super(message);
    }

    public NegativeValueException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

