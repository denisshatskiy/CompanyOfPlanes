package com.epam.mentoringProgram.lesson4.companyOfPlanes.application;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.FileIsEmptyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.IncorrectTypeOfPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, NegativeValueException, SQLException, FileIsEmptyException, IncorrectTypeOfPlane {
        Interface userInterface = new Interface();
        userInterface.userInterface();
    }
}
