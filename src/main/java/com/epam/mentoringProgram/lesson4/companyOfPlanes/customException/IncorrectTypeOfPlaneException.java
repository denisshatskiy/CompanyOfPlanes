package com.epam.mentoringProgram.lesson4.companyOfPlanes.customException;

public class IncorrectTypeOfPlaneException extends Exception {
    public IncorrectTypeOfPlaneException() {
        super("You entered an incorrect code!");
    }
}
