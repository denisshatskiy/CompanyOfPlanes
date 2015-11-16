package com.epam.mentoringProgram.lesson4.companyOfPlanes.subject;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.my_exception.MyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.my_exception.NegativeValueException;

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

    public void setSeatsNumber(int seatsNumber) throws MyException{
        if (seatsNumber < 0){
            throw new MyException("There are negative value");
        }else{
            this.seatsNumber = seatsNumber;
        }
    }
}
