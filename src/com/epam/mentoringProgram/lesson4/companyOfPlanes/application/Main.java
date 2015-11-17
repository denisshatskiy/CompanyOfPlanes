package com.epam.mentoringProgram.lesson4.companyOfPlanes.application;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.my_exception.MyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.DataOutput;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.FileReader;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.Plane;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, MyException {
        FileReader fileReader = new FileReader();
        DataOutput dataOutput = new DataOutput();
        CompanyOfPlanes companyOfPlanes = fileReader.inputFromFile();

        dataOutput.createFile();


        dataOutput.consoleAndFileOutput("\nList of planes in the Company : ");
        dataOutput.consoleAndFileOutput(companyOfPlanes.toString());

        dataOutput.consoleAndFileOutput("Total capacity : ");
        companyOfPlanes.defineTotalCapacity();
        dataOutput.consoleAndFileOutput(String.valueOf(companyOfPlanes.getTotalCapacity()));

        dataOutput.consoleAndFileOutput("\nTotal carrying : ");
        companyOfPlanes.defineTotalCarrying();
        dataOutput.consoleAndFileOutput(String.valueOf(companyOfPlanes.getTotalCarrying()));

        dataOutput.consoleAndFileOutput("\nSorted list of planes in the Company : ");
        companyOfPlanes.sortPlaneFromCompany();
        dataOutput.consoleAndFileOutput(companyOfPlanes.toString());

        dataOutput.consoleAndFileOutput("\nSearch by parameter \"Distance\" : ");
        companyOfPlanes.searchByParameter();
        dataOutput.consoleAndFileOutput(companyOfPlanes.toString());
    }
}
