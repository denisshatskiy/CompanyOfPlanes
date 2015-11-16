package com.epam.mentoringProgram.lesson4.companyOfPlanes.childClasses;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.*;

public class CargoPlane extends Plane {
    int boxNumber;

    public CargoPlane(String name, double carrying, double distance) {
        super(name, carrying, distance);
    }

    public void defineCapacity() {
        setCapacity(boxNumber * 0.89);
    }

    public void setBoxNumber(int boxNumber){
        this.boxNumber = boxNumber;
    }
}
