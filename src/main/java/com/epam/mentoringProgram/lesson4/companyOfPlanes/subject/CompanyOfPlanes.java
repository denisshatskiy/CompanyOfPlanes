package com.epam.mentoringProgram.lesson4.companyOfPlanes.subject;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.DataOutput;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.DistanceComparator;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.core.DataReader;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyOfPlanes {
    private List<Plane> planes = new ArrayList<>();

    public List<Plane> getResultOfSearch() {
        return resultOfSearch;
    }

    private List<Plane> resultOfSearch = new ArrayList<>();
    private double totalCapacity;
    private double totalCarrying;
    private double[] limitsForSearch;

    NumberFormat formatter = NumberFormat.getNumberInstance();


    public String toString(){
        String string = "";
        for (Plane plane : planes)
            try {
                string += (plane.getName() + " - carrying: " + String.valueOf(formatter.format(plane.getCarrying())) +
                        " , capacity: " + String.valueOf(formatter.format(plane.getCapacity())) +
                        " , distance: " + String.valueOf(formatter.format(plane.getDistance())) + "\n");
            }
            catch (NullPointerException e){
                System.out.println("List contained NULL value:");
            }
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

    public List<Plane> searchByParameter( double[] limitsForSearch) {
        DataOutput dataOutput = new DataOutput();
        //dataReader.inputTopAndBottomLimits();
        //limitsForSearch = dataReader.inputTopAndBottomLimits();
        //getLimitsForSearch();
        try {
            for (Plane plane : planes) {
                double parameterForSearch = plane.getDistance();
                if (parameterForSearch >= limitsForSearch[0] && parameterForSearch <= limitsForSearch[limitsForSearch.length-1]) {
                    resultOfSearch.add(plane);
                    dataOutput.listPrint(resultOfSearch);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Limits for search contained NULL value");
        }
        return resultOfSearch;
    }

    public double[] getLimitsForSearch(){
        DataReader dataReader = new DataReader();
        dataReader.inputTopAndBottomLimits();
        return limitsForSearch;
    }

    public void setLimitsForSearch(double[] limitsForSearch){
        this.limitsForSearch = limitsForSearch;
    }
}

