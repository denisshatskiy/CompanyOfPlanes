package com.epam;

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

    public void printPlaneList() {
        if (planes.isEmpty()) {
            System.out.println("List is Empty");
        } else {
            for (Plane plane : planes) System.out.println(plane.toString());
        }
    }

    public double defineTotalCapacity(){
        for (Plane plane: planes) totalCapacity += plane.getCapacity();
        return totalCapacity;
    }

    public void printTotalCapacity(){
        defineTotalCapacity();
        System.out.println("Total capacity : " + totalCapacity);
    }

    public double defineTotalCarrying(){
        for (Plane plane: planes) totalCarrying += plane.getCarrying();
        return totalCarrying;
    }

    public void printTotalCarrying(){
        defineTotalCarrying();
        System.out.println("Total carrying : " + totalCarrying);
    }

    public void sortPlaneFromCompany() {
        Collections.sort(planes, new DistanceComparator());
    }

    public void printSortPlane(){
        sortPlaneFromCompany();
        System.out.println("Сортированный список самолетов : ");
        for (Plane plane : planes) {
            System.out.println(" " + plane.getDistance());
        }
    }

    public void searchByParametr(double bottomParametr, double topParametr) {
        double distance;
        System.out.println("Поиск самолета по параметру \"Дальность полета\" (" + bottomParametr + "," + topParametr + ")");
        for (Plane plane : planes){
            distance = plane.getDistance();
            if(distance >= bottomParametr && distance <= topParametr){
                System.out.println(" " + plane.getDistance());
            }
        }
    }
}

