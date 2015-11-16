package com.epam.mentoringProgram.lesson4.companyOfPlanes.subject;

public class PassengerPlane extends Plane {
    int seatsNumber;

    public PassengerPlane(String name, double carrying, double distance) {
        super(name, carrying, distance);
    }

    public void defineCapacity() {
        try {
            setCapacity(seatsNumber * 0.7);
        }
            catch (ArithmeticException e) {
            System.out.println("There was an invalid arithmetic operation");
        }
    }

    public void setSeatsNumber(int seatsNumber){
        this.seatsNumber = seatsNumber;
    }
}
