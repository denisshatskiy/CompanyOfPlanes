package com.epam.mentoringProgram.lesson4.companyOfPlanes.subject;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;

public class CargoPlane extends Plane {
    int boxNumber;

    public CargoPlane(String name, double carrying, double distance, int boxNumber) throws NegativeValueException {
        super(name, carrying, distance);
        if (boxNumber < 0){
            throw new NegativeValueException();
        }else{
            this.boxNumber = boxNumber;
        }
        defineCapacity();
    }
    public CargoPlane(int boxNumber){
        super();
        this.boxNumber =boxNumber;
    }


    public void defineCapacity() {
        try {
            setCapacity(boxNumber * 0.89);
        } catch (ArithmeticException e) {
            System.out.println("There was an invalid arithmetic operation");
        }
    }
}
