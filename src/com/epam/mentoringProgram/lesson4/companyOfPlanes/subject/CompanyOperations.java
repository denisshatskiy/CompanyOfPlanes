package com.epam.mentoringProgram.lesson4.companyOfPlanes.subject;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.ConsoleAndFileOutput;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.DistanceComparator;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.FileReader;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyOperations {
    private List<Plane> planes = new ArrayList<>();
    private double totalCapacity;
    private double totalCarrying;

    public void addPlanesToCompanyList(Plane plane) {
        planes.add(plane);
    }

    NumberFormat formatter = NumberFormat.getNumberInstance();
    ConsoleAndFileOutput consoleAndFileOutput = new ConsoleAndFileOutput();

    public void printPlaneList() {
        consoleAndFileOutput.consoleAndFileWrite("List of planes in company : ");
        if (planes.isEmpty()) {
            consoleAndFileOutput.consoleAndFileWrite("List is Empty");
        } else {
            for (Plane plane : planes) {
                consoleAndFileOutput.consoleAndFileWrite(plane.toString());
            }
        }
    }

    public double defineTotalCapacity(){
        for (Plane plane: planes) totalCapacity += plane.getCapacity();
        return totalCapacity;
    }

    public void printTotalCapacity(){
        defineTotalCapacity();
        consoleAndFileOutput.consoleAndFileWrite("\nTotal capacity : " + formatter.format(totalCapacity).toString());
    }

    public double defineTotalCarrying(){
        for (Plane plane: planes) totalCarrying += plane.getCarrying();
        return totalCarrying;
    }

    public void printTotalCarrying(){
        defineTotalCarrying();
        consoleAndFileOutput.consoleAndFileWrite("\nTotal carrying : " + formatter.format(totalCarrying).toString());
    }

    public void sortPlaneFromCompany() {
        Collections.sort(planes, new DistanceComparator());
    }

    public void printSortPlane(){
        sortPlaneFromCompany();
        consoleAndFileOutput.consoleAndFileWrite("\nSorted list of planes : ");
        for (Plane plane : planes) {
            consoleAndFileOutput.consoleAndFileWrite(plane.getName() + " : " + formatter.format(plane.getDistance()).toString());
        }
    }

    public void searchByParameter() {
        FileReader fileReader = new FileReader();
        double[] limitsFroSearch = fileReader.inputTopAndBottomLimits();

        consoleAndFileOutput.consoleAndFileWrite("\nSearch by parameter \"Distance\" (" + formatter.format(limitsFroSearch[0]) + " , " + formatter.format(limitsFroSearch[1]) + ")"); //как избавиться от статических значений?
        for (Plane plane : planes){
            double distance = plane.getDistance();
            if(distance >= limitsFroSearch[0] && distance <= limitsFroSearch[1]){
                consoleAndFileOutput.consoleAndFileWrite(plane.getName() + " : " + formatter.format(plane.getDistance()));
            }
        }
    }
}

