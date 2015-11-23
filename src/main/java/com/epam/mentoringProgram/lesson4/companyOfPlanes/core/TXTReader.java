package com.epam.mentoringProgram.lesson4.companyOfPlanes.core;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.FileIsEmptyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CargoPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

public class TXTReader extends DataReaderFromSource {

    @Override
    public CompanyOfPlanes readData() throws FileIsEmptyException {

        setSourceName("inputFileTXT.txt");

        CompanyOfPlanes companyOfPlanes = new CompanyOfPlanes();
        if (getSourceName().length() == 0) {
            throw new FileIsEmptyException();
        } else {
            try {
                BufferedReader read = new BufferedReader(new java.io.FileReader(getSourceName()));
                String line;
                while ((line = read.readLine()) != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(line, " : ");
                    while (stringTokenizer.hasMoreElements()) {
                        if (line.contains("P")) {
                            try {
                                stringTokenizer.nextElement();
                                PassengerPlane passengerPlane = new PassengerPlane(stringTokenizer.nextToken(),
                                        Double.valueOf(stringTokenizer.nextToken()),
                                        Double.valueOf(stringTokenizer.nextToken()),
                                        Integer.valueOf(stringTokenizer.nextToken()));
                                companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                            } catch (NumberFormatException e) {
                                System.out.println("There was an invalid parameter : line ("
                                        + line + ") won't be added to list!");
                            }
                        } else if (line.contains("C")) {
                            try {
                                stringTokenizer.nextElement();
                                CargoPlane cargoPlane = new CargoPlane(stringTokenizer.nextToken(),
                                        Double.valueOf(stringTokenizer.nextToken()),
                                        Double.valueOf(stringTokenizer.nextToken()),
                                        Integer.valueOf(stringTokenizer.nextToken()));
                                companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                            } catch (NumberFormatException e) {
                                System.out.println("There was an invalid parameter : line ("
                                        + line + ") won't be added to list!");
                            }
                        }
                    }
                }
                read.close();
                return companyOfPlanes;
            } catch (NullPointerException e) {
                System.out.println("File is empty");
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (NegativeValueException | IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
