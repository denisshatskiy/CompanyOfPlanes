package com.epam.mentoringProgram.lesson4.companyOfPlanes.subject;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;

public class PassengerPlane extends Plane {
    int seatsNumber;

    public PassengerPlane(String name, double carrying, double distance, int seatsNumber) throws NegativeValueException {
        super(name, carrying, distance);
        this.seatsNumber = seatsNumber;
        if (seatsNumber < 0){
            throw new NegativeValueException();
        }else{
            this.seatsNumber = seatsNumber;
        }
    }

    public void defineCapacity() {
        try {
            setCapacity(seatsNumber * 0.7);
        }
        catch (ArithmeticException e) {
            System.out.println("There was an invalid arithmetic operation!");
        }
    }
}
