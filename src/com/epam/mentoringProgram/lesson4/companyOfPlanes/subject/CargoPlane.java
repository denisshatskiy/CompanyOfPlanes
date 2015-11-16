package com.epam.mentoringProgram.lesson4.companyOfPlanes.subject;

public class CargoPlane extends Plane {
    int boxNumber;

    public CargoPlane(String name, double carrying, double distance) {
        super(name, carrying, distance);
    }

    public void defineCapacity() {
        try {
            setCapacity(boxNumber * 0.89);
        } catch (ArithmeticException e) {
            System.out.println("There was an invalid arithmetic operation");
        }
    }

    public void setBoxNumber(int boxNumber){
        this.boxNumber = boxNumber;
    }
}
