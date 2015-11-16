package com.epam.mentoringProgram.lesson4.companyOfPlanes.application;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.my_exception.MyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.my_exception.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.ConsoleAndFileOutput;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.FileReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, MyException {
        FileReader fileReader = new FileReader();
        ConsoleAndFileOutput consoleAndFileOutput = new ConsoleAndFileOutput();
        CompanyOfPlanes companyOfPlanes = fileReader.inputFromFile();

        consoleAndFileOutput.createFile();

        companyOfPlanes.printPlaneList();
        companyOfPlanes.printTotalCapacity();
        companyOfPlanes.printTotalCarrying();
        companyOfPlanes.printSortPlane();
        companyOfPlanes.searchByParameter();
    }
}
