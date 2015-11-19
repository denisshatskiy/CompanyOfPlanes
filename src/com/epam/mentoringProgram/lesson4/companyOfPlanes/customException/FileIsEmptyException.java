package com.epam.mentoringProgram.lesson4.companyOfPlanes.customException;

public class FileIsEmptyException extends Exception {
    public FileIsEmptyException() {
        super("File is empty!");
    }
}