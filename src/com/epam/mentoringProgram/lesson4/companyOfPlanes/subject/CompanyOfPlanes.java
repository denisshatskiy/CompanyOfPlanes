package com.epam.mentoringProgram.lesson4.companyOfPlanes.subject;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.DistanceComparator;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.FileReader;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyOfPlanes {
    private List<Plane> planes = new ArrayList<>();
    private List<Plane> resultOfSearch = new ArrayList<>();
    private double totalCapacity;
    private double totalCarrying;

    NumberFormat formatter = NumberFormat.getNumberInstance();


    public String toString(List<Plane> tempList){
        String string = "";
        for (Plane plane : tempList)
            string += (plane.getName() + " - carrying: " + String.valueOf(formatter.format(plane.getCarrying())) +
                    " , capacity: " + String.valueOf(formatter.format(plane.getCapacity())) +
                    " , distance: " + String.valueOf(formatter.format(plane.getDistance())) + "\n");
        return string;
    }

    public void addPlanesToCompanyList(Plane plane) {
        planes.add(plane);
    }

    public void defineTotalCapacity(){
        for (Plane plane: planes) totalCapacity += plane.getCapacity();
    }

    public Double getTotalCapacity(){
        return totalCapacity;
    }

    public void defineTotalCarrying(){
        for (Plane plane: planes) totalCarrying += plane.getCarrying();
    }

    public Double getTotalCarrying(){
        return totalCarrying;
    }

    public void sortPlaneFromCompany() {
        Collections.sort(planes, new DistanceComparator());
    }

    public List<Plane> searchByParameter() {
        FileReader fileReader = new FileReader();
        double[] limitsFroSearch = fileReader.inputTopAndBottomLimits();
        try {
            //DataOutput.consoleAndFileOutput("\nSearch by parameter \"Distance\" (" + formatter.format(limitsFroSearch[0]) + " , " + formatter.format(limitsFroSearch[limitsFroSearch.length-1]) + ")");
            for (Plane plane : planes) {
                double parameterForSearch = plane.getDistance();
                if (parameterForSearch >= limitsFroSearch[0] && parameterForSearch <= limitsFroSearch[1]) {
                    planes.add(plane);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("There was null value");
        }
        return planes;
    }
}

