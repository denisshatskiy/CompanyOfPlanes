package com.epam.mentoringProgram.lesson4.companyOfPlanes.customException;

public class NegativeValueException extends Exception {
    public NegativeValueException() {
        super("There was negative value!");
    }
}

