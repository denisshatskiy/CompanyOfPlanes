package com.epam.mentoringProgram.lesson4.companyOfPlanes;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        ConsoleAndFileOutput consoleAndFileOutput = new ConsoleAndFileOutput();
        CompanyOperations companyOperations = fileReader.inputFromFile();

        consoleAndFileOutput.createFile();

        companyOperations.printPlaneList();
        companyOperations.printTotalCapacity();
        companyOperations.printTotalCarrying();
        companyOperations.printSortPlane();
        companyOperations.searchByParameter();
    }
}
