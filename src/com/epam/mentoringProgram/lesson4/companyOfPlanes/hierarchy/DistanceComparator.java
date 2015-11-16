package com.epam.mentoringProgram.lesson4.companyOfPlanes.hierarchy;

public class DistanceComparator implements java.util.Comparator<Plane> {

    public int compare(Plane o1, Plane o2) {
        return (int)(o1.getDistance() - o2.getDistance());
    }
}
