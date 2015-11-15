package com.epam;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private List<Plane> planes = new ArrayList<>();
    private double totalCapacity;
    private double totalCarrying;

    public void addPlanesToCompanyList(Plane plane) {
        planes.add(plane);
    }

    NumberFormat formatter = NumberFormat.getNumberInstance();
    Writer writer = new Writer();

    public void printPlaneList() {
        System.out.println("List of planes in company : ");
        writer.writeFile("List of planes in company : ");
        if (planes.isEmpty()) {
            System.out.println("List is Empty");
            writer.writeFile("List is Empty");
        } else {
            for (Plane plane : planes) {
                System.out.println(plane.toString());
                writer.writeFile(plane.toString());
            }
        }
    }

    public double defineTotalCapacity(){
        for (Plane plane: planes) totalCapacity += plane.getCapacity();
        return totalCapacity;
    }

    public void printTotalCapacity(){
        defineTotalCapacity();
        System.out.println("\nTotal capacity : " + formatter.format(totalCapacity));
        writer.writeFile("\nTotal capacity : " + formatter.format(totalCapacity).toString());
    }

    public double defineTotalCarrying(){
        for (Plane plane: planes) totalCarrying += plane.getCarrying();
        return totalCarrying;
    }

    public void printTotalCarrying(){
        defineTotalCarrying();
        System.out.println("\nTotal carrying : " + formatter.format(totalCarrying));
        writer.writeFile("\nTotal carrying : " + formatter.format(totalCarrying).toString());
    }

    public void sortPlaneFromCompany() {
        Collections.sort(planes, new DistanceComparator());
    }

    public void printSortPlane(){
        sortPlaneFromCompany();
        System.out.println("\nSorted list of planes : ");
        writer.writeFile("\nSorted list of planes : ");
        for (Plane plane : planes) {
            System.out.println(plane.getName() + " : " + formatter.format(plane.getDistance()));
            writer.writeFile(plane.getName() + " : " + formatter.format(plane.getDistance()).toString());
        }
    }

    public void searchByParametr(double bottomParametr, double topParametr) {
        double distance;
        System.out.println("\nSearch by parameter \"Distance\" (" + formatter.format(bottomParametr) + " , " + formatter.format(topParametr) + ")");
        writer.writeFile("\nSearch by parameter \"Distance\" (" + formatter.format(bottomParametr) + " , " + formatter.format(topParametr) + ")");
        for (Plane plane : planes){
            distance = plane.getDistance();
            if(distance >= bottomParametr && distance <= topParametr){
                System.out.println(plane.getName() + " : " + formatter.format(plane.getDistance()));
                writer.writeFile(plane.getName() + " : " + formatter.format(plane.getDistance()));
            }
        }
    }
}

