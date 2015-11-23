package com.epam.mentoringProgram.lesson4.companyOfPlanes.core;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.FileIsEmptyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CargoPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSONReaderFromSource extends DataReaderFromSource {
    @Override
    public CompanyOfPlanes readData() throws FileIsEmptyException {

        setSourceName("inputFileJSON.json");

        CompanyOfPlanes companyOfPlanes = new CompanyOfPlanes();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("inputFileJSON.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray companyOfPlanesArray = (JSONArray) jsonObject.get("companyOfPlanes");

            for (Object aCompanyOfPlanesArray : companyOfPlanesArray) {
                JSONObject currentPlane = (JSONObject) aCompanyOfPlanesArray;
                String planeType = (String) currentPlane.get("planeType");
                String planeName = (String) currentPlane.get("planeName");
                String carrying = (String) currentPlane.get("carrying");
                String distance = (String) currentPlane.get("distance");
                String freeSpaceNumber = (String) currentPlane.get("freeSpaceNumber");
                if (planeType.contains("P")) {
                    try {
                        PassengerPlane passengerPlane = new PassengerPlane(planeName,
                                Double.valueOf(carrying), Double.valueOf(distance), Integer.valueOf(freeSpaceNumber));
                        companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                    } catch (NumberFormatException e) {
                        System.out.println("There was an invalid parameter : plane  ("
                                + planeName + ") won't be added to list!");
                    } catch (NegativeValueException e) {
                        e.printStackTrace();
                    }
                } else if (planeType.contains("C")) {
                    try {
                        CargoPlane cargoPlane = new CargoPlane(planeName,
                                Double.valueOf(carrying), Double.valueOf(distance), Integer.valueOf(freeSpaceNumber));
                        companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                    } catch (NumberFormatException e) {
                        System.out.println("There was an invalid parameter : plane ("
                                + planeName + ") won't be added to list!");
                    }
                }
            }
            return companyOfPlanes;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
