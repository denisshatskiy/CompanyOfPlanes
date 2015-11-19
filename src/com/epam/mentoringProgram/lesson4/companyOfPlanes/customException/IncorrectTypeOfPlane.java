package com.epam.mentoringProgram.lesson4.companyOfPlanes.customException;

public class IncorrectTypeOfPlane extends Exception {
    public IncorrectTypeOfPlane() {
        super("You entered an incorrect code!");
    }
}
