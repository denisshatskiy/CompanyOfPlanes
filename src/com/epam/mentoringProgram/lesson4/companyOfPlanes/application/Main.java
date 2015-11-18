package com.epam.mentoringProgram.lesson4.companyOfPlanes.application;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.DataOutput;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.FileReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, NegativeValueException {
        FileReader fileReader = new FileReader();
        DataOutput dataOutput = new DataOutput();

        CompanyOfPlanes companyOfPlanes = fileReader.readFromXML();
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
        //fileReader.inputTopAndBottomLimits();
        dataOutput.listPrint(companyOfPlanes.searchByParameter());
    }
}
