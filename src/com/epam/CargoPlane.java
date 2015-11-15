package com.epam;

public class CargoPlane extends Plane {
    int boxNumber;

    CargoPlane(String name, double carrying, double distance) {
        super(name, carrying, distance);
    }

    public void defineCapacity() {
        setCapacity(boxNumber * 0.89);
    }

    public void setBoxNumber(int boxNumber){
        this.boxNumber = boxNumber;
    }
}
