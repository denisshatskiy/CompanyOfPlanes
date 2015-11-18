package com.epam.mentoringProgram.lesson4.companyOfPlanes.subject;

public class CargoPlane extends Plane {
    int boxNumber;

    public CargoPlane(String name, double carrying, double distance, int boxNumber) {
        super(name, carrying, distance);
        this.boxNumber = boxNumber;
    }

    public void defineCapacity() {
        try {
            setCapacity(boxNumber * 0.89);
        } catch (ArithmeticException e) {
            System.out.println("There was an invalid arithmetic operation");
        }
    }
}
