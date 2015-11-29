package com.epam.mentoringProgram.lesson4.companyOfPlanes.application;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.*;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.FileIsEmptyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.IncorrectTypeOfPlaneException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DefineMethodOfInput {
    public void setTheMethodOfInput() throws NegativeValueException, IOException, SQLException,
            FileIsEmptyException, IncorrectTypeOfPlaneException {
        TXTReader txtReader = new TXTReader();
        XMLReader xmlReader = new XMLReader();
        JSONReader jsonReader = new JSONReader();
        DBReader dbReader = new DBReader();
        DataReader dataReader = new DataReader();
        DataOutput dataOutput = new DataOutput();
        CompanyOfPlanes companyOfPlanes = new CompanyOfPlanes();

        dataOutput.createFile();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose method of input : \n1 - manual\n2 - from TXT file\n3 " +
                "- from XML file\n4 - from JSON file\n5 - from database");
        switch (scanner.nextLine()){
            case "1":
                companyOfPlanes = dataReader.inputManually();
                break;
            case "2":
                companyOfPlanes = txtReader.readData();
                break;
            case "3":
                companyOfPlanes = xmlReader.readData();
                break;
            case "4":
                companyOfPlanes = jsonReader.readData();
                break;
            case "5":
                companyOfPlanes = dbReader.readData();
                break;
        }

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
        dataReader.inputTopAndBottomLimits();

    }
}
