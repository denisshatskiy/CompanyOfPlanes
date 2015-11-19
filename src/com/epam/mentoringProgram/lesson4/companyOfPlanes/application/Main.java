package com.epam.mentoringProgram.lesson4.companyOfPlanes.application;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, NegativeValueException, SQLException {
        Interface userInterface = new Interface();
        userInterface.userInterface();
    }
}
