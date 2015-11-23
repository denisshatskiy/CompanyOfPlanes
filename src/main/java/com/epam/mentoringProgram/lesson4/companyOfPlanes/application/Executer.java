package com.epam.mentoringProgram.lesson4.companyOfPlanes.application;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.FileIsEmptyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.IncorrectTypeOfPlaneException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;

import java.io.IOException;
import java.sql.SQLException;

public class Executer {

    public static void main(String[] args) throws IOException, NegativeValueException, SQLException,
            FileIsEmptyException, IncorrectTypeOfPlaneException {
        DefineMethodOfInput userDefineMethodOfInput = new DefineMethodOfInput();
        userDefineMethodOfInput.setTheMethodOfInput();
    }
}
